package com.akenori.web.mock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class About {

    @JsonProperty("total_space")
    private int totalSpace;
    @JsonProperty("filled_space")
    private int filledSpace;
    @JsonProperty("version")
    private String version;

    public About(int totalSpace, int filledSpace, String version) {
        this.totalSpace = totalSpace;
        this.filledSpace = filledSpace;
        this.version = version;
    }

    public int getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(int totalSpace) {
        this.totalSpace = totalSpace;
    }

    public int getFilledSpace() {
        return filledSpace;
    }

    public void setFilledSpace(int filledSpace) {
        this.filledSpace = filledSpace;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
