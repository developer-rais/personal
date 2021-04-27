package com.trading.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Trade {

    @JsonProperty("sym")
    private String stockName;

    @JsonProperty("T")
    private String t;

    @JsonProperty("P")
    private double price;

    @JsonProperty("Q")
    private double quantity;

    @JsonProperty("side")
    private String side;

    @JsonProperty("TS")
    private double timeStamp1;

    @JsonProperty("TS2")
    private double timeStamp2;

}
