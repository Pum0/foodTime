package com.example.foodtime.listView;

public class ListData {
    private int poster;
    private String storeName;
    private String distance;

    public ListData(int poster, String storeName, String distance) {
        this.poster = poster;
        this.storeName = storeName;
        this.distance = distance;
    }

    public int getPoster() {
        return this.poster;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDistance() {
        return distance;
    }
}
