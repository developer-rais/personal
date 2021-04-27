package com.pubsub.service;

import com.pubsub.model.Message;


public interface ProducerService<T> {
    void send(PubSubService pubSubService, Message message);
}
