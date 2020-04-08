package com.example.demo.GeneralMessage;


import java.util.HashMap;

public class VideoMessage {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String MediaId;
    private String ThumbMediaId;
    private String MsgId;
    private HashMap<String,String> hashMap;

    public VideoMessage(HashMap<String, String> hashMap) {
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

    public String getMediaId() {
        return hashMap.get("MediaId");
    }

    public String getThumbMediaId() {
        return hashMap.get("ThumbMediaId");
    }

    public String getMsgId() {
        return hashMap.get("MsgId");
    }




}
