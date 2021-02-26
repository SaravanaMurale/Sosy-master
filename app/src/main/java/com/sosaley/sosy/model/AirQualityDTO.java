package com.sosaley.sosy.model;

public class AirQualityDTO {

    String airQualityId;
    String airQualityRoomName;
    String airQualityRoomClickedStatus;

    public AirQualityDTO(String airQualityId, String airQualityRoomName) {
        this.airQualityId = airQualityId;
        this.airQualityRoomName = airQualityRoomName;
    }

    public String getAirQualityId() {
        return airQualityId;
    }

    public void setAirQualityId(String airQualityId) {
        this.airQualityId = airQualityId;
    }

    public String getAirQualityRoomName() {
        return airQualityRoomName;
    }

    public void setAirQualityRoomName(String airQualityRoomName) {
        this.airQualityRoomName = airQualityRoomName;
    }

    public String getAirQualityRoomClickedStatus() {
        return airQualityRoomClickedStatus;
    }

    public void setAirQualityRoomClickedStatus(String airQualityRoomClickedStatus) {
        this.airQualityRoomClickedStatus = airQualityRoomClickedStatus;
    }
}
