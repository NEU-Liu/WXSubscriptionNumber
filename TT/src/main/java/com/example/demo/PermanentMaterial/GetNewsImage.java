package com.example.demo.PermanentMaterial;


import java.util.Random;

public class GetNewsImage {

    public String Get_News_Image_Media_Id_With_Random(){
        return RandomAccessMediaId();
    }

    private String RandomAccessMediaId() {
        ImageVoiceAndVideoList list = new GetMaterialList("image","0","20").GetImageVoiceAndVideoList();
        String[] Media_Id = list.media_id;
        String someMediaId = Media_Id[new Random().nextInt(list.item_count)];
        return someMediaId;
    }


}
