package com.trading.services;

import com.trading.model.Trade;
import com.trading.model.TradeResult;
import com.trading.utility.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FsmConsumer extends Thread {
    private TradesProducer tradesProducer;

//    // having clients in a map at FSM
//    public void setClientServiceMap(List<ClientService> clientServiceList) {
//        this.clientServiceMap = clientServiceList.stream().collect(Collectors.toMap(ClientService::getClientStock, ClientService::getClientService));
//    }

    private List<ClientService> clientServiceList;


    private static double INTERVAL_TIME = 15000000000.0;  //15 seconds
    private static Map<String, TradeResult> currentIntervalTrades = new HashMap<>();

    // start time for a interval
    private static double intervalStartedTime = 0.0;  //15 seconds
    // incremental barNumber
    private static AtomicInteger barNumber = new AtomicInteger(1);

    public FsmConsumer(TradesProducer tradesProducer, List<ClientService> clientServiceList) {
        this.tradesProducer = tradesProducer;
        this.clientServiceList=clientServiceList;

    }


    @Override
    public void run() {
        try {
            while (true) {
                Trade trade = tradesProducer.getMessage();
                //System.out.println("Consumed new Trade.."+trade);
                if (trade.getTimeStamp2() - intervalStartedTime > INTERVAL_TIME) {
                     //System.out.println("Published result for bar: " + barNumber);

                    // publish results to clients
                    publishTradeResultsToClients(currentIntervalTrades);
                    // flush previous records
                    currentIntervalTrades.clear();
                    // incr bar number
                    barNumber.getAndIncrement();
                    // set new interval
                    intervalStartedTime = trade.getTimeStamp2();
                } else {
                    //  System.out.println("evaluating  result for bar: " + barNumber);

                    // Get from Map and update
                    TradeResult tradeResult = currentIntervalTrades.getOrDefault(trade.getStockName()
                            , Utils.getEmptyTradeResult(trade, barNumber.get()));
                    // set highest bid in-case of high price
                    if (trade.getPrice() > tradeResult.getHighestPrice()) {
                        tradeResult.setHighestPrice(trade.getPrice());
                    }
                    // set lowest bid in-case of high price
                    if (trade.getPrice() < tradeResult.getLowestPrice()) {
                        tradeResult.setLowestPrice(trade.getPrice());
                    }
                    // add to volume
                    tradeResult.setVolume(tradeResult.getVolume() + trade.getQuantity());

                    // setting closing price
                    tradeResult.setClosingPrice(trade.getPrice());

                    // updating map
                    currentIntervalTrades.put(trade.getStockName(), tradeResult);
                }
            }
        } catch (Exception exception) {
            System.out.println(" Exception occurred at consumer end. Exception is " + exception);
        }
    }

    private void publishTradeResultsToClients(Map<String, TradeResult> tradeResultMap) throws InterruptedException {
        System.out.println("Bar "+barNumber.get()+" starts here");
        for( ClientService clientService: clientServiceList)
        {
           TradeResult tradeResult= tradeResultMap.getOrDefault(clientService.getClientStockName(),
                   Utils.getEmptyTradeResult(clientService.getClientStockName(), barNumber.get()));
           clientService.pushMessage(tradeResult);
        }
    }

}