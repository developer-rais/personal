package com.pubsub.model;

import com.pubsub.service.PubSubService;
import lombok.Data;

import java.util.List;

@Data
public abstract class Subscriber {

    private List<Message>  subscriberMessages;

    public abstract void  subscribe(String topicName, PubSubService pubSubService);
    public abstract void  unSubscribe(String topicName, PubSubService pubSubService);
    public abstract void  getMessagesOfTopic(String topicName, PubSubService pubSubService);
    // ack things

    public void printMessages()
    {
        for(Message message : subscriberMessages){
            System.out.println("Message Topic -> "+ message.getTopicName() + " : key " + message.getKey()
            +"  value: "+message.getValue());
        }
    }


}
