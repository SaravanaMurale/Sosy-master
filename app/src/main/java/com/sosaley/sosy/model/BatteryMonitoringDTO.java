package com.sosaley.sosy.model;

public class BatteryMonitoringDTO {

    String batteryId;
    int batteryImg;
    String batteryName;

    public BatteryMonitoringDTO(String batteryId, int batteryImg, String batteryName) {
        this.batteryId = batteryId;
        this.batteryImg = batteryImg;
        this.batteryName = batteryName;
    }

    public String getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(String batteryId) {
        this.batteryId = batteryId;
    }

    public int getBatteryImg() {
        return batteryImg;
    }

    public void setBatteryImg(int batteryImg) {
        this.batteryImg = batteryImg;
    }

    public String getBatteryName() {
        return batteryName;
    }

    public void setBatteryName(String batteryName) {
        this.batteryName = batteryName;
    }
}
