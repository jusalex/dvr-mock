package com.akenori.web.mock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemInfo {

    private static final String GPS_DELIMITER = " ";

    @JsonProperty("version")
    private String version;

    @JsonProperty("gps")
    private String gps;

    @JsonProperty("sn")
    private String sn;

    @JsonProperty("storage")
    private boolean storage;

    @JsonProperty("storage_wp")
    private boolean storage_wp;

    @JsonProperty("total_space")
    private int total_space;

    @JsonProperty("filled_space")
    private int filled_space;

    @JsonProperty("battery_level")
    private int battery_level;

    @JsonProperty("recording_status")
    private int recording_status = -1;

    @JsonProperty("processing_emergency")
    private boolean processing_emergency;

    public String getVersion() {
        return version;
    }

    public boolean hasGps() {
        return gps != null && !gps.equals("no geo data");
    }

    public double getLatitude() {
        if (!hasGps()) {
            return 0;
        }

        String[] coordinates = gps.split(GPS_DELIMITER);
        return Double.parseDouble(coordinates[0]);
    }

    public double getLongitude() {
        if (!hasGps()) {
            return 0;
        }

        String[] coordinates = gps.split(GPS_DELIMITER);
        return Double.parseDouble(coordinates[1]);
    }

    public boolean hasStorage() {
        return storage;
    }

    public boolean isStorageWriteProtected() {
        return storage_wp;
    }

    public int getTotalSpace() {
        return total_space;
    }

    public int getFilledSpace() {
        return filled_space;
    }

    public int getFreeSpace() {
        return total_space - filled_space;
    }

    public int getBatteryLevel() {
        return battery_level;
    }

    public boolean isRecording() {
        return recording_status >= 0;
    }

    public void setRecording(boolean recordingStatus) {
        this.recording_status = recordingStatus ? 0 : -1;
    }

    public int getRecordingProgress() {
        return recording_status;
    }

    public boolean isProcessingEmergency() {
        return processing_emergency;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getMinorVersion() {
        if (version == null) {
            return 0;
        }
        try {
            return Integer.parseInt(version.split("\\.")[2]);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public void setStorage(boolean storage) {
        this.storage = storage;
    }

    public void setStorage_wp(boolean storage_wp) {
        this.storage_wp = storage_wp;
    }

    public void setTotal_space(int total_space) {
        this.total_space = total_space;
    }

    public void setFilled_space(int filled_space) {
        this.filled_space = filled_space;
    }

    public void setBattery_level(int battery_level) {
        this.battery_level = battery_level;
    }

    public void setRecording_status(int recording_status) {
        this.recording_status = recording_status;
    }

    public void setProcessing_emergency(boolean processing_emergency) {
        this.processing_emergency = processing_emergency;
    }
}
