package com.rais.model;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String channelName;
    private List<Subscriber> subscribeList;

    private long subscriberCount;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.subscribeList = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribeList.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber) {
        subscribeList.remove(subscriber);
    }

    public void pushNotifications() {

        for (Subscriber subscriber : subscribeList) {
            subscriber.update();
            System.out.println("push notification to " + subscriber);
        }
    }

    public void upload(String channelName) {
        this.channelName = channelName;
        pushNotifications();
    }
}
