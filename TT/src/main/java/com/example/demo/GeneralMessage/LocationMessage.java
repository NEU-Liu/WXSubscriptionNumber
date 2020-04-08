package com.example.demo.GeneralMessage;

import java.util.HashMap;

public class LocationMessage {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Location_X;
    private String Location_Y;
    private String Scale;
    private String Label;
    private String MsgId;
    private HashMap<String,String> hashMap;

    public LocationMessage(HashMap<String, String> hashMap) {
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

    public String getLocation_X() {
        return hashMap.get("Location_X");
    }

    public String getLocation_Y() {
        return hashMap.get("Location_Y");
    }

    public String getScale() {
        return hashMap.get("Scale");
    }

    public String getLabel() {
        return hashMap.get("Label");
    }

    public String getMsgId() {
        return hashMap.get("MsgId");
    }
}
