package com.pubsub.service;

import com.pubsub.exception.InvalidTopicException;
import com.pubsub.model.Message;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class KafkaProducerImpl<T> implements ProducerService<T> //, KafkaProducerService<T>
{



//    @Override
//    public void send(String key, T value, String topicName) throws Exception {
//        this.send(key, value, topicName, new HashMap<>());
//    }
//
//    @Override
//    public void send(String key, T value, String topicName, Map<String, String> header) throws InvalidTopicException {
//
//        if (pubSubService.isValidTopic(topicName)) {
//            throw new InvalidTopicException("invalid topic");
//        }
//
//        Message producerMessage = new Message(topicName, key, value);
//        send(pubSubService, producerMessage);
//    }

    @Override
    public void send(PubSubService pubSubService, Message message) {
        pubSubService.addMessage(message);

    }
}
