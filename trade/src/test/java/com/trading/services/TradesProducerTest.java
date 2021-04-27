package com.trading.services;

import com.trading.model.Trade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Vector;

@RunWith(MockitoJUnitRunner.class)
public class TradesProducerTest {

    @Test
    public void shouldBeAbleToProduceTrades() throws InterruptedException, URISyntaxException {
         Vector<Trade> tradesQueue=new Vector<>();

        URL url = this.getClass().getClassLoader().getResource("trades.json");
        TradesProducer tradesProducer = new TradesProducer(Paths.get(url.toURI()).toFile().getAbsolutePath(),tradesQueue);
        tradesProducer.start();
        tradesProducer.join();
        assertEquals(2,tradesQueue.size());

    }

}
