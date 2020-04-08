package com.example.demo.AccessToken;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class AccessToken {
    private String access_token;
    private String expires_in;
    private long expireTime;
    private static AccessToken accessToken = null;


    private AccessToken() {
    }

    public static AccessToken getInstance() {
        if (accessToken == null) {
            accessToken = new AccessToken();
        }
        return accessToken;
    }


    public String GetAccessToken() {
        if (HasExpire(new Date())) {
            GetAccessTokenJSON();
        }
        // System.out.println(access_token);
        return access_token;
    }

    private boolean HasExpire(Date date) {
        if (access_token == null) return true;
        if (date.getTime() > expireTime - 30000) return true;
        return false;
    }

    private void GetAccessTokenJSON() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxde07d035a8192b36&secret=6919b5c88001f0c2cd5b3beec86dbeb5")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ParseJsonString(response.body().string());
        } catch (IOException e) {
            System.out.println("ParseJsonString(response.body().string())!");
        }
    }

    private void ParseJsonString(String json) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            access_token = jsonObject.getString("access_token");
            expires_in = jsonObject.getString("expires_in");
            expireTime = new Date().getTime() + Integer.valueOf(expires_in) * 1000;
        } catch (JSONException e) {
            System.out.println("Exception!");
        }
    }
}
