package com.example.demo.PermanentMaterial;


public class ImageVoiceAndVideoList {
    public int total_count;
    public int item_count;
    public String[] media_id;
    public String[] name;
    public String[] update_time;
    public String[] url;

    public ImageVoiceAndVideoList() {
    }

    public ImageVoiceAndVideoList(int total_count, int item_count) {
        this.total_count = total_count;
        this.item_count = item_count;
        this.media_id = new String[this.item_count];
        this.name = new String[this.item_count];
        this.update_time = new String[this.item_count];
        this.url = new String[this.item_count];
    }
}
