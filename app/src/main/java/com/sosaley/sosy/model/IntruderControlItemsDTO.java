package com.sosaley.sosy.model;

public class IntruderControlItemsDTO {

    String intruderDetecId;
    int intruderDetecImg;
    String intruderDetecName;
    int intruderDetcCount;

    public IntruderControlItemsDTO(String intruderDetecId, int intruderDetecImg, String intruderDetecName, int intruderDetcCount) {
        this.intruderDetecId = intruderDetecId;
        this.intruderDetecImg = intruderDetecImg;
        this.intruderDetecName = intruderDetecName;
        this.intruderDetcCount = intruderDetcCount;
    }

    public String getIntruderDetecId() {
        return intruderDetecId;
    }

    public void setIntruderDetecId(String intruderDetecId) {
        this.intruderDetecId = intruderDetecId;
    }

    public int getIntruderDetecImg() {
        return intruderDetecImg;
    }

    public void setIntruderDetecImg(int intruderDetecImg) {
        this.intruderDetecImg = intruderDetecImg;
    }

    public String getIntruderDetecName() {
        return intruderDetecName;
    }

    public void setIntruderDetecName(String intruderDetecName) {
        this.intruderDetecName = intruderDetecName;
    }

    public int getIntruderDetcCount() {
        return intruderDetcCount;
    }

    public void setIntruderDetcCount(int intruderDetcCount) {
        this.intruderDetcCount = intruderDetcCount;
    }
}
