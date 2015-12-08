package com.gokhanabi.dao;

/**
 * Created by Masraf2 on 12/8/2015.
 */
public class ControllerLog {

    private String method;
    private Long duration;
    private String customLog;
    private String timeStamp;

    @Override
    public String toString() {
        return "ControllerLog{" +
                "method='" + method + '\'' +
                ", duration=" + duration +
                ", customLog='" + customLog + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ControllerLog)) return false;

        ControllerLog that = (ControllerLog) o;

        if (!method.equals(that.method)) return false;
        if (!duration.equals(that.duration)) return false;
        if (customLog != null ? !customLog.equals(that.customLog) : that.customLog != null) return false;
        return timeStamp.equals(that.timeStamp);

    }

    @Override
    public int hashCode() {
        int result = method.hashCode();
        result = 31 * result + duration.hashCode();
        result = 31 * result + (customLog != null ? customLog.hashCode() : 0);
        result = 31 * result + timeStamp.hashCode();
        return result;
    }

    public ControllerLog() {
    }

    public String getCustomLog() {
        return customLog;
    }

    public void setCustomLog(String customLog) {
        this.customLog = customLog;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getDuration() {

        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
