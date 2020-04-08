package com.example.demo;


import com.example.demo.AccessToken.AccessToken;
import okhttp3.*;
import org.apache.logging.log4j.message.Message;
import org.junit.Test;

import java.io.IOException;


public class MyTest {

    @Test
    public void testGet() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxde07d035a8192b36&secret=6919b5c88001f0c2cd5b3beec86dbeb5")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }


    @Test
    public void testPost() throws Exception {
//        AccessToken accessToken= new AccessToken();
//        String access_token = accessToken.GetAccessToken();
//        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
//
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
//        Request request = new Request.Builder().post(body).url(url).build();
//
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//
//            @Override
//            public void onResponse(Call call, okhttp3.Response response) throws IOException {
//                String s = response.body().toString();
//                System.out.println(s);
//            }
//        });


    }


}
