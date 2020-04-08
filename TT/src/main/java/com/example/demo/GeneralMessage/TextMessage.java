package com.example.demo.GeneralMessage;

import java.util.HashMap;

public class TextMessage {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;
    private String MsgId;
    private HashMap<String,String> hashMap;

    public TextMessage(HashMap<String, String> hashMap) {
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

    public String getContent() {
        return hashMap.get("Content");
    }

    public String getMsgId() {
        return hashMap.get("MsgId");
    }
}
