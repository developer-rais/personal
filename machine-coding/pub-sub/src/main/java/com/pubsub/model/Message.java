package com.pubsub.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class Message<T> {

    private String topicName;
    private String key;
    private T value;
    private Map<String, String> headers;

    public Message(String topicName, String key, T value) {
        this.topicName = topicName;
        this.key = key;
        this.value = value;
    }


}
