package com.example.demo.Http;

import com.example.demo.AccessToken.AccessToken;
import okhttp3.*;

import java.io.IOException;

public class doPost {

    public static String PostJsonAndGetResponse(String urlHeader, String json){
        String access_token= AccessToken.getInstance().GetAccessToken();
        String url = urlHeader + access_token;
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(body).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            System.out.println("response.body().string()!");
        }
        return null;
    }

}
