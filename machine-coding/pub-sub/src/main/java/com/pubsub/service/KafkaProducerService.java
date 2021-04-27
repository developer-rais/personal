//package com.pubsub.service;
//
//import com.pubsub.exception.InvalidTopicException;
//
//import java.util.Map;
//
//public interface KafkaProducerService<T> {
//    void send(String key, T value,String topicName) throws  Exception;
//    void send(String key, T value, String topicName, Map<String,String> header) throws InvalidTopicException;
//}
