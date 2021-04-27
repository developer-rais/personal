package com.elavator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request  implements  Comparable<Request>{

    private ExternalRequest externalRequest;
    private InternalRequest internalRequest;

    @Override
    public int compareTo(Request o) {
        return 0;
    }
}
