package com.trading.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.model.Trade;
import com.trading.utility.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class TradesProducer extends Thread {

    // initialization of queue size
    static final int MAX = 1000;
    // synchronized collections to manage trades
    private Vector<Trade> tradesQueue;

    private ObjectMapper objectMapper;

    // trades.json file absolute path
    private String tradesFilePath;

    public TradesProducer(String filePath,Vector<Trade> tradesQueue) {
        this.tradesFilePath = filePath;
        this.objectMapper = new ObjectMapper();
        this.tradesQueue =tradesQueue;
    }


    @Override
    public void run() {
        // reading from trades.json file
        try (BufferedReader br = new BufferedReader(new FileReader(tradesFilePath))) {

            String tradeInput = "";
            while ((tradeInput = br.readLine()) != null) {
                // reading a line from file and pushing Trade data into queue
                Trade trade = objectMapper.readValue(tradeInput, Trade.class);

                // producing a message to send to the consumer
                pushMessage(trade);
            }
        } catch (InterruptedException exception) {
            System.out.println("InterruptedException exception occurred at producer end. Exception is "+exception);
        } catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException exception occurred at producer end. Exception is "+exception);
        } catch (IOException exception) {
            System.out.println("IOException exception occurred at producer end. Exception is "+exception);
        }
    }

    public synchronized void pushMessage(Trade trade) throws InterruptedException {

        // checks whether the queue is full or not
        while (tradesQueue.size() == MAX) {
            // waits for the queue to get empty
            wait();
        }

        // add messages
        tradesQueue.addElement(trade);
        //System.out.println("Published new Trade.."+trade);
        notify();
    }

    public synchronized Trade getMessage() {
        notify();
        // To plot empty bar when there are no trades in the interval
        while (tradesQueue.size() == 0) {
            return Utils.getEmptyTrade("EMPTY");
        }


        // read the first trade from queue
        Trade trade = tradesQueue.firstElement();
        // extracts the message from the queue
        tradesQueue.removeElement(trade);
        return trade;
    }

}


