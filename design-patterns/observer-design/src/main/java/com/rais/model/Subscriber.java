package com.rais.model;

public class Subscriber {

    private String name;

    private Channel channel;

    public  Subscriber(String name)
    {
        this.name=name;
    }
public void update()
    {
        System.out.println("new content available");
    }

    public void subscribe(Channel channel)
    {
        this.channel=channel;
    }
}
