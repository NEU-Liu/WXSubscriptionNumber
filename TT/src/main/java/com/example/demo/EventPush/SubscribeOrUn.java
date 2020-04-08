package com.example.demo.EventPush;

import java.util.HashMap;

public class SubscribeOrUn {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Event;
    private HashMap<String,String> hashMap;

    public SubscribeOrUn(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String getToUserName() {
        return hashMap.get("ToUserName");
    }

    public String getFromUserName() {
        return hashMap.get("FromUserName");
    }

    public String getCreateTime() {
        return hashMap.get("CreateTime");
    }

    public String getMsgType() {
        return hashMap.get("MsgType");
    }

    public String getEvent() {
        return hashMap.get("Event");
    }
}
