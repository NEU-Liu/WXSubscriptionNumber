package com.example.demo.GeneralMessage;

import java.util.HashMap;

public class ImageMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String PicUrl;
    private String MediaId;
    private String MsgId;
    private HashMap<String,String> hashMap;

    public ImageMessage(HashMap<String, String> hashMap) {
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

    public String getPicUrl() {
        return hashMap.get("PicUrl");
    }

    public String getMediaId() {
        return hashMap.get("MediaId");
    }

    public String getMsgId() {
        return hashMap.get("MsgId");
    }
}
