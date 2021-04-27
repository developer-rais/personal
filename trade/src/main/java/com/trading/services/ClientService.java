package com.trading.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.model.Trade;
import com.trading.model.TradeResult;
import com.trading.utility.Utils;

import java.util.Vector;

public class ClientService extends Thread {

    // to uniquely identify a client.
    private long id;

    private ObjectMapper objectMapper;

    public void setTradesResultsQueue(Vector<TradeResult> tradesResultsQueue) {
        this.tradesResultsQueue = tradesResultsQueue;
    }

    // initialization of queue size
    static final int MAX = 1000;

    // synchronized collections to manage trades
    private Vector<TradeResult> tradesResultsQueue;

    public String getClientStockName() {
        return clientStockName;
    }

    private String clientStockName;

    public ClientService( long id, String clientStockName) {
        this.id = id;
        this.clientStockName = clientStockName;
        tradesResultsQueue= new Vector<>();
        this.objectMapper = new ObjectMapper();
    }


    @Override
    public void run() {
        try {
            while (true) {
                TradeResult tradeResult=getMessage();
                tradeResult.setClientId(this.id);
                System.out.println(objectMapper.writeValueAsString(tradeResult));
            }
        } catch (Exception exception) {
            System.out.println("Exception occurred at client end. Exception is " + exception);

        }
    }


    public synchronized void pushMessage(TradeResult tradeResult) throws InterruptedException {

        // checks whether the queue is full or not
        while (this.tradesResultsQueue.size() == MAX) {
            // waits for the queue to get empty
            wait();
        }

        // add messages
        this.tradesResultsQueue.addElement(tradeResult);
        //System.out.println("Published new Trade.."+trade);
        notify();
    }

    public synchronized TradeResult getMessage() throws InterruptedException {
        notify();
        // To plot empty bar when there are no trades in the interval
        while (tradesResultsQueue.size() == 0) {
           wait();
        }


        // read the first trade from queue
        TradeResult tradeResult = tradesResultsQueue.firstElement();
        // extracts the message from the queue
        tradesResultsQueue.removeElement(tradeResult);
        return tradeResult;
    }

}
