package com.pubsub.model;

import lombok.Data;

@Data
public class Topic {
    String topicName;
    short replicationFactor;
    int partitions;

    public Topic( String topicName,short replicationFactor, int partitions)
    {
        this.topicName=topicName;
        this.replicationFactor=replicationFactor;
        this.partitions=partitions;
    }

}
