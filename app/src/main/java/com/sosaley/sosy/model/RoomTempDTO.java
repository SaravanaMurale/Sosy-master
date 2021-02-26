package com.sosaley.sosy.model;

public class RoomTempDTO {

    String roomTempId;
    String roomTempRoomName;
    String roomTempClickedStatus;

    public RoomTempDTO(String roomTempId, String roomTempRoomName) {
        this.roomTempId = roomTempId;
        this.roomTempRoomName = roomTempRoomName;
    }

    public String getRoomTempId() {
        return roomTempId;
    }

    public void setRoomTempId(String roomTempId) {
        this.roomTempId = roomTempId;
    }

    public String getRoomTempRoomName() {
        return roomTempRoomName;
    }

    public void setRoomTempRoomName(String roomTempRoomName) {
        this.roomTempRoomName = roomTempRoomName;
    }

    public String getRoomTempClickedStatus() {
        return roomTempClickedStatus;
    }

    public void setRoomTempClickedStatus(String roomTempClickedStatus) {
        this.roomTempClickedStatus = roomTempClickedStatus;
    }
}
