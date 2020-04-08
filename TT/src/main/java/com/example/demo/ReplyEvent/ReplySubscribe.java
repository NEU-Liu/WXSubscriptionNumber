package com.example.demo.ReplyEvent;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class ReplySubscribe {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Event;
    private HashMap<String,String> hashMap;

    public ReplySubscribe(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String buildMessage(){
        String content = "感谢你的关注,回复help查看帮助!";
        try {
            content = new String(content.getBytes(),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException!");
        }
        return generateXml(content);
    }


    private String generateXml(String content){
        return "<xml>\n" +
                "<ToUserName><![CDATA["+hashMap.get("FromUserName")+"]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+hashMap.get("ToUserName")+"]]></FromUserName>\n" +
                "<CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA["+content+"]]></Content>\n" +
                "</xml>";
    }

}
