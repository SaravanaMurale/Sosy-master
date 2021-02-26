package com.sosaley.sosy.model;

public class IntruderRoomNameDTO {

    String intruderRoomId;
    String intruderRoomName;
    String itruderRoomClickedStatus;

    public IntruderRoomNameDTO(String intruderRoomId, String intruderRoomName) {
        this.intruderRoomId = intruderRoomId;
        this.intruderRoomName = intruderRoomName;
    }

    public String getIntruderRoomId() {
        return intruderRoomId;
    }

    public void setIntruderRoomId(String intruderRoomId) {
        this.intruderRoomId = intruderRoomId;
    }

    public String getIntruderRoomName() {
        return intruderRoomName;
    }

    public void setIntruderRoomName(String intruderRoomName) {
        this.intruderRoomName = intruderRoomName;
    }

    public String getItruderRoomClickedStatus() {
        return itruderRoomClickedStatus;
    }

    public void setItruderRoomClickedStatus(String itruderRoomClickedStatus) {
        this.itruderRoomClickedStatus = itruderRoomClickedStatus;
    }
}
