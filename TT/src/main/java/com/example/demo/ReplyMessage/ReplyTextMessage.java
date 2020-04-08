package com.example.demo.ReplyMessage;

import com.example.demo.AccessToken.AccessToken;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ReplyTextMessage {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;

    private String ToAuthorName = "oF2-wjp3wXG4Adyc091iatgy6ImI";

    private HashMap<String,String> hashMap;

    public ReplyTextMessage(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String buildToAuthorMessage(){
        String content = hashMap.get("Content");
        try {
            content = new String(content.getBytes(),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException!");
        }
        return generateToAuthorXml(content);
    }

    public String buildMessage(){
        String content = "Hello,Nice to meet you!";
        Content = hashMap.get("Content");
        if (Content.equals("help")){
            content = getHelpMessage();
        }else if (Content.equals("1")){
            content = get1Message();
        }else if (Content.equals("2")){
            content = get2Message();
        }else if (Content.equals("3")){
            content = get3Message();
        }else if (Content.equals("4")){
            return get4Message();
        }else if (isOtherNums(Content)){
            content = get0Message();
        }else if (Content.equals("AccessToken")){
            content = getAccessTokenMessage();
        }

        try {
            content = new String(content.getBytes(),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException!");
        }
        return generateXml(content);
    }

    private String getAccessTokenMessage() {
        return AccessToken.getInstance().GetAccessToken();
    }

    private boolean isOtherNums(String content) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(content).matches()){
            return true;
        }
        return false;
    }

    private String get0Message() {
        return "你回复的数字不正确，请重新回复！";
    }

    private String get1Message() {
        return "作者邮箱:liudd3610@163.com!";
    }

    private String get2Message() {
        return "很遗憾，暂无推荐内容，敬请期待！";
    }

    private String get3Message() {
        return "Hello,Nice to Meet you!\n谢谢你的留言，作者将很快回复你！";
    }

    private String get4Message() {
        return new ReplyImageMessage(hashMap).buildMessageContribute();
    }



    private String getHelpMessage() {
        String content;
        content = "回复1:\n" +
                  "联系作者，\n" +
                  "回复2:\n" +
                  "获取推荐，\n" +
                  "回复3：\n" +
                  "我想对你说,留言给作者，\n" +
                  "回复4:\n" +
                  "捐赠作者!";
        return content;
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

    private String generateToAuthorXml(String content){
        return "<xml>\n" +
                "<ToUserName><![CDATA["+ ToAuthorName +"]]></ToUserName>\n" +
                "<FromUserName><![CDATA["+hashMap.get("ToUserName")+"]]></FromUserName>\n" +
                "<CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA["+content+"]]></Content>\n" +
                "</xml>";
    }
}
