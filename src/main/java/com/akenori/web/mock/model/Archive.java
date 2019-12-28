package com.akenori.web.mock.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.Date;

public class Archive {

    @JsonProperty("isVideo")
    public boolean isVideo;
    @JsonProperty("preview")
    public String preview;
    @JsonProperty("file")
    public String file;
    @JsonProperty("track")
    public String track;
    @JsonProperty("size")
    public long size;
    @JsonProperty("emergency")
    private boolean emergency;
    @JsonProperty("time")
    public long time;

    // Custom fields
    private String name;
    private long duration;
    private String localFilePath;
    private boolean hasLocalFile;

    public Archive(boolean isVideo, String preview, String file, String track, long size, boolean emergency, long time) {
        this.isVideo = isVideo;
        this.preview = preview;
        this.file = file;
        this.track = track;
        this.size = size;
        this.emergency = emergency;
        this.time = time;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        if (this.emergency == emergency) {
            return;
        }

        this.emergency = emergency;
        this.name = null;

        if (this.emergency) {
            file = file.replace("/video/", "/video/Emergency/");
        } else {
            file = file.replace("/video/Emergency/", "/video/");
        }
    }

    public String getName() {
        if (name != null) {
            return name;
        }

        if (!file.contains("/emergency/")) {
            name = file.substring(file.indexOf("/video/") + 7, file.length());
        } else {
            name = file.substring(file.indexOf("/emergency/") + 11, file.length());
        }

        return name;
    }

    public String getRemoteFilePath() {
        return file;
    }

    public void setLocalFilePath(final String localFilePath) {
        this.localFilePath = localFilePath;
    }

    public String getLocalFilePath() {
        return localFilePath;
    }

    public boolean hasLocalFile() {
        return hasLocalFile;
    }

    public void setHasLocalFile(final boolean hasLocalFile) {
        this.hasLocalFile = hasLocalFile;
    }

    public long getDuration() {
        if (!hasLocalFile || !isVideo || duration > 0) {
            return duration;
        }

        return 60;
    }

    public Date getDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time * 1000L);
        return c.getTime();
    }

    public int compare(Archive o1, Archive o2) {
        return o1.getDate().compareTo(o2.getDate());
    }

}
