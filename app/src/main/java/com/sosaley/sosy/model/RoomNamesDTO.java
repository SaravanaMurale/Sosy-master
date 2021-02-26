package com.sosaley.sosy.model;

public class RoomNamesDTO {

    private String roomId;
    private String roomName;
    private int roomClickedStatus;

    public RoomNamesDTO(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomClickedStatus() {
        return roomClickedStatus;
    }

    public void setRoomClickedStatus(int roomClickedStatus) {
        this.roomClickedStatus = roomClickedStatus;
    }
}
