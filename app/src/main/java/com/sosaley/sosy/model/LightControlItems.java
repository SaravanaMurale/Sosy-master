package com.sosaley.sosy.model;

public class LightControlItems {

    String lightControl_ID;
    int lightControl_Img;
    String lightControl_LightName;
    int lightControl_LightCount=0;



    public LightControlItems(String lightControl_ID, int lightControl_Img, String lightControl_LightName, int lightControl_LightCount) {
        this.lightControl_ID = lightControl_ID;
        this.lightControl_Img = lightControl_Img;
        this.lightControl_LightName = lightControl_LightName;
        this.lightControl_LightCount = lightControl_LightCount;
    }

    public String getLightControl_ID() {
        return lightControl_ID;
    }

    public void setLightControl_ID(String lightControl_ID) {
        this.lightControl_ID = lightControl_ID;
    }

    public int getLightControl_Img() {
        return lightControl_Img;
    }

    public void setLightControl_Img(int lightControl_Img) {
        this.lightControl_Img = lightControl_Img;
    }

    public String getLightControl_LightName() {
        return lightControl_LightName;
    }

    public void setLightControl_LightName(String lightControl_LightName) {
        this.lightControl_LightName = lightControl_LightName;
    }

    public int getLightControl_LightCount() {
        return lightControl_LightCount;
    }

    public void setLightControl_LightCount(int lightControl_LightCount) {
        this.lightControl_LightCount = lightControl_LightCount;
    }
}
