package com.neo.com.learning.pattrn.observer;

public class EventSource {
    long wakeupTime;
    String location;

    public EventSource(long wakeupTime,String location){
        this.wakeupTime = wakeupTime;
        this.location = location;
    }
}
