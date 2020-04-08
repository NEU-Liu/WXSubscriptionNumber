package com.example.demo.ReplyMessage;

import com.example.demo.PermanentMaterial.GetNewsImage;

import java.util.HashMap;


public class ReplyImageMessage {
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Image;
    private String MediaId;
    private HashMap<String,String> hashMap;

    public ReplyImageMessage(HashMap<String, String> hashMap) {
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

    public String getImage() {
        return hashMap.get("Image");
    }

    public String getMediaId() {
        return hashMap.get("MediaId");
    }

    public String buildMessage(String media_id){
        return generateXml(media_id);
    }

    public String buildMessage(){
        return generateXml(getMediaId());
    }

    public String buildMessageRandom(){
        String Media_Id_WX = "gl9XpkGEsZobV-OICPvRdU_H7KZREWfgXUVUl-w9I9w";
        String Media_Id = new GetNewsImage().Get_News_Image_Media_Id_With_Random();
        if (Media_Id.equals(Media_Id_WX)){
            return generateXml(getMediaId())  ;
        }
        return generateXml(Media_Id);
    }


    private String generateXml(String content){
        return "<xml>\n" +
                "  <ToUserName><![CDATA[" + getFromUserName()  +"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + getToUserName()+ "]]></FromUserName>\n" +
                "  <CreateTime>" +  System.currentTimeMillis()/1000 +"</CreateTime>\n" +
                "  <MsgType><![CDATA[image]]></MsgType>\n" +
                "  <Image>\n" +
                "    <MediaId><![CDATA[" + content + "]]></MediaId>\n" +
                "  </Image>\n" +
                "</xml>";
    }


    public String buildMessageContribute() {
        String Media_Id_wx = "gl9XpkGEsZobV-OICPvRdU_H7KZREWfgXUVUl-w9I9w";
        return generateXml(Media_Id_wx);
    }
}
