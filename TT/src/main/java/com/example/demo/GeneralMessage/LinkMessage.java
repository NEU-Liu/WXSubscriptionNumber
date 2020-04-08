package com.example.demo.GeneralMessage;


import java.util.HashMap;

public class LinkMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Title;
    private String Description;
    private String Url;
    private String MsgId;
    private HashMap<String,String> hashMap;

    public LinkMessage(HashMap<String, String> hashMap) {
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

    public String getTitle() {
        return hashMap.get("Title");
    }

    public String getDescription() {
        return hashMap.get("Description");
    }

    public String getUrl() {
        return hashMap.get("Url");
    }

    public String getMsgId() {
        return hashMap.get("MsgId");
    }
}
