package com.example.demo.Main;


import com.example.demo.Http.doPost;
import org.junit.Test;


public class MyApplicationRunner{


    public void myInit(){
        okhttp3post();
    }

    @Test
    public void okhttp3post(){
        String urlHeader = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
        String json = menu();
        String str = doPost.PostJsonAndGetResponse(urlHeader, json);
        System.out.println("doPost.PostJsonAndGetResponse:" + str);
    }

    private String menu(){
        return "{\n" +
                "     \"button\":[\n" +
                "     {\t\n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"互动\",\n" +
                "          \"key\":\"CLICK_Interact\"\n" +
                "      },\n" +
                "      {\n" +
                "           \"name\":\"推荐\",\n" +
                "           \"sub_button\":[\n" +
                "           {\t\n" +
                "               \"type\":\"view\",\n" +
                "               \"name\":\"阅览\",\n" +
                "               \"url\":\"http://www.baidu.com/\"\n" +
                "            },\n" +
                "            {\n" +
                "               \"type\":\"click\",\n" +
                "               \"name\":\"捐赠\",\n" +
                "               \"key\":\"CLICK_Contribute\"\n" +
                "            }]\n" +
                "       }]\n" +
                " }";
    }




}
