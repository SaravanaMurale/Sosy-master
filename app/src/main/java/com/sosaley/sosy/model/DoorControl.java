package com.sosaley.sosy.model;

public class DoorControl {

    String doorId;
    int doorImage;
    int doorCount;
    String doorName;

    public DoorControl(String doorId, int doorImage, int doorCount, String doorName) {
        this.doorId = doorId;
        this.doorImage = doorImage;
        this.doorCount = doorCount;
        this.doorName = doorName;
    }

    public String getDoorId() {
        return doorId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    public int getDoorImage() {
        return doorImage;
    }

    public void setDoorImage(int doorImage) {
        this.doorImage = doorImage;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }
}
