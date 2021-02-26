package com.sosaley.sosy.model;

public class HomeItemResponse {

    String homeItemId;
    int homeImage;
    String homeItemName;

    public HomeItemResponse(String homeItemId, int homeImage, String homeItemName) {
        this.homeItemId = homeItemId;
        this.homeImage = homeImage;
        this.homeItemName = homeItemName;
    }

    public String getHomeItemId() {
        return homeItemId;
    }

    public void setHomeItemId(String homeItemId) {
        this.homeItemId = homeItemId;
    }

    public int getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(int homeImage) {
        this.homeImage = homeImage;
    }

    public String getHomeItemName() {
        return homeItemName;
    }

    public void setHomeItemName(String homeItemName) {
        this.homeItemName = homeItemName;
    }
}
