package com.wxblockchain.com.learning.pattrn.observer;

public class MomListener implements ObserverEvent {
    @Override
    public void wakeUpActionOnEvent(EventSource eventSource) {
        String location = eventSource.location;
        //对地点进行判断
        switch(location){
            case "bed":
                System.out.println("mom hugchild on bed...");
                break;
            case "kitchen":
                System.out.println("mom hugchild on kitchen...");
                break;
        }
    }
}
