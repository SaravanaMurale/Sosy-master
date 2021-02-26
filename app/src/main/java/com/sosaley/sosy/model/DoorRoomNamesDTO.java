package com.sosaley.sosy.model;

public class DoorRoomNamesDTO {

    private String doorRoomId;
    private String doorRoomName;
    private int doorRoomClickedStatus;

    public DoorRoomNamesDTO(String doorRoomId, String doorRoomName) {
        this.doorRoomId = doorRoomId;
        this.doorRoomName = doorRoomName;

    }

    public String getDoorRoomId() {
        return doorRoomId;
    }

    public void setDoorRoomId(String doorRoomId) {
        this.doorRoomId = doorRoomId;
    }

    public String getDoorRoomName() {
        return doorRoomName;
    }

    public void setDoorRoomName(String doorRoomName) {
        this.doorRoomName = doorRoomName;
    }

    public int getDoorRoomClickedStatus() {
        return doorRoomClickedStatus;
    }

    public void setDoorRoomClickedStatus(int doorRoomClickedStatus) {
        this.doorRoomClickedStatus = doorRoomClickedStatus;
    }
}
