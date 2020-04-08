package com.example.demo.PermanentMaterial;


import com.example.demo.Http.doPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class GetMaterialList {

    private String TYPE;
    private String OFFSET;
    private String COUNT;

    public GetMaterialList(String TYPE, String OFFSET, String COUNT) {
        this.TYPE = TYPE;
        this.OFFSET = OFFSET;
        this.COUNT = COUNT;
    }


    public ImageVoiceAndVideoList GetImageVoiceAndVideoList() {
        String urlHeader = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
        String json = null;
        if (this.TYPE.equals("image")){
            json = ImageJson();
        }
        String out = doPost.PostJsonAndGetResponse(urlHeader, json);
        return getList(out);
    }

    private ImageVoiceAndVideoList getList(String json) {
        JSONObject jsonObject = null;
        ImageVoiceAndVideoList imageVoiceAndVideoList = null;
        try {
            jsonObject = new JSONObject(json);
            int total_count = Integer.valueOf(jsonObject.getString("total_count"));
            int item_count = Integer.valueOf(jsonObject.getString("item_count"));
            imageVoiceAndVideoList = new ImageVoiceAndVideoList(total_count, item_count);
            JSONArray item = jsonObject.getJSONArray("item");
            for (int i = 0; i < item.length(); i++) {
                imageVoiceAndVideoList.media_id[i] = item.getJSONObject(i).getString("media_id");
                imageVoiceAndVideoList.name[i] = item.getJSONObject(i).getString("name");
                imageVoiceAndVideoList.update_time[i] = item.getJSONObject(i).getString("update_time");
                imageVoiceAndVideoList.url[i] = item.getJSONObject(i).getString("url");
            }
        } catch (JSONException e) {
            System.out.println("Exception!");
        }
        return imageVoiceAndVideoList;
    }

    private String ImageJson() {
        return "{\n" +
                "            \"type\":" + "\"image\"" + ",\n" +
                "                \"offset\":" + this.OFFSET + ",\n" +
                "                \"count\":" + this.COUNT + "\n" +
                "}";
    }
}
