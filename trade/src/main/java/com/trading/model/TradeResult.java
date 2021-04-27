package com.trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TradeResult {

    @JsonProperty("client_id")
    private long clientId;

    @JsonProperty("o")
    private double openingPrice;

    @JsonProperty("h")
    private double highestPrice;

    @JsonProperty("l")
    private double lowestPrice;

    @JsonProperty("c")
    private double closingPrice;

    @JsonProperty("volume")
    private double volume;

    @JsonProperty("event")
    @Builder.Default
    private String eventType="ohlc_notify";

    @JsonProperty("symbol")
    private String stockName;

    @JsonProperty("bar_num")
    private long barNumber;

}
