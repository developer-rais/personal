package com.trading.utility;

import com.trading.model.Trade;
import com.trading.model.TradeResult;

public class Utils {

    public static Trade getEmptyTrade(String stockName) {
        return Trade.builder().stockName(stockName).price(0.0).quantity(0.0).timeStamp2(System.currentTimeMillis() * 1000000).build();
    }
    public static TradeResult getEmptyTradeResult(Trade trade,long barNumber) {
        return TradeResult.builder()
                .stockName(trade.getStockName())
                .openingPrice(trade.getPrice())
                .highestPrice(trade.getPrice())
                .lowestPrice(trade.getPrice())
                .closingPrice(trade.getPrice())
                .volume(trade.getQuantity())
                .barNumber(barNumber)
                .build();
    }

    public static TradeResult getEmptyTradeResult(String stockName, long barNumber) {
        return getEmptyTradeResult(getEmptyTrade(stockName), barNumber);
    }
}
