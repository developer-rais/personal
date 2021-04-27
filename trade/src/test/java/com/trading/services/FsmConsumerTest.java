
package com.trading.services;

import com.trading.model.Trade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@RunWith(MockitoJUnitRunner.class)
public class FsmConsumerTest {

    @Test
    public void shouldBeAbleToConsumeTrades() throws InterruptedException, URISyntaxException {
        Vector<Trade> tradesQueue = new Vector<>();

        URL res = getClass().getClassLoader().getResource("trades.json");
        TradesProducer tradesProducer = new TradesProducer(Paths.get(res.toURI()).toFile().getAbsolutePath(), tradesQueue);
        tradesProducer.start();
        tradesProducer.join();

        // clients
        List<ClientService> clientServiceList = new ArrayList() {{
            add(new ClientService(1, "XZECXXBT"));
            add(new ClientService(2, "XETHZUSD"));

        }};

        assertEquals(2, tradesQueue.size());

        // FSM service to consume trades from queue
        FsmConsumer fsmConsumer = new FsmConsumer(tradesProducer, clientServiceList);
        fsmConsumer.start();
        Thread.sleep(5000);
        assertEquals(0, tradesQueue.size());

    }

}

