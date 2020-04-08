package com.example.demo.Main;

import com.example.demo.ReplyEvent.ReplySubscribe;
import com.example.demo.ReplyMessage.ReplyImageMessage;
import com.example.demo.ReplyMessage.ReplyTextMessage;
import com.example.demo.GeneralMessage.ParseXml;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@RestController
public class HelloController {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        out.print(echostr);
    }

    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    public void handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ParseXml parseXml = new ParseXml(request);
        HashMap<String, String> hashMap = parseXml.getHashMap();
        PrintWriter printWriter = response.getWriter();
        switch (hashMap.get("MsgType")) {
            case "text":
                ReplyTextMessage replyTextMessage = new ReplyTextMessage(hashMap);
                String responseMessageText = replyTextMessage.buildMessage();
                printWriter.print(responseMessageText);
                break;
            case "image":
                ReplyImageMessage replyImageMessage = new ReplyImageMessage(hashMap);
                String responseMessageImage = replyImageMessage.buildMessageRandom();
                printWriter.print(responseMessageImage);
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "link":
                break;
            case "event":
                if (hashMap.get("Event").equals("subscribe")) {
                    String responseSubscribeEvent = new ReplySubscribe(hashMap).buildMessage();
                    printWriter.print(responseSubscribeEvent);
                }
                break;
            default:
                System.out.println("Unknown message type!");
                break;
        }
        printWriter.flush();
        printWriter.close();
    }
}
