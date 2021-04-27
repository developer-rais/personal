package com.elavator.model;

import lombok.Data;

@Data
public class ExternalRequest {

    int sourceFloor;
    Direction direction;

    public ExternalRequest(int sourceFloor, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.direction = direction;
    }
}
