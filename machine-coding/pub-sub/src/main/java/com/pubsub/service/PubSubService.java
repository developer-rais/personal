package com.pubsub.service;

import java.util.*;

import com.pubsub.model.Message;
import com.pubsub.model.Subscriber;
import com.pubsub.model.Topic;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class PubSubService {

    Map<String, Topic> topicMetaData;
    Map<String,Queue<Message>> logsQueue;

    Map<String,Set<Subscriber>> subscribersMap;


    public boolean isValidTopic(String topicName) {
        if (MapUtils.isEmpty(topicMetaData)) {
            return false;
        } else {
            return topicMetaData.containsKey(topicName);
        }
    }



    public void addMessage(Message message)
    {
        Topic topic=topicMetaData.get(message.getTopicName());
        if(topic!=null)
        {
            Queue queue1=logsQueue.get(topic.getTopicName());
            if(!CollectionUtils.isEmpty(queue1))
            {
                queue1.add(message);
            }
        }
    }


}
