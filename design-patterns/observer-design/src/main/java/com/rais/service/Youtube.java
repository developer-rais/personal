package com.rais.service;

import com.rais.model.Channel;
import com.rais.model.Subscriber;

public class Youtube {

    public static void main(String[] args) {

        Channel myChannel=new Channel("LLD");

        Subscriber subscriber1=new Subscriber("Sub1");
        Subscriber subscriber2=new Subscriber("Sub2");
        Subscriber subscriber3=new Subscriber("Sub3");

        myChannel.subscribe(subscriber1);
        myChannel.subscribe(subscriber2);
        myChannel.subscribe(subscriber3);

        myChannel.upload("Rais");

        subscriber1.subscribe(myChannel);
        subscriber2.subscribe(myChannel);
        subscriber3 .subscribe(myChannel);





    }




}
