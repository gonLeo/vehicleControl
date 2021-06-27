package com.teste.vehicleControl.dto.commons;

public class ErrorDto {
    private boolean success;
    private int satus;
    private String message;
    private long timestamp;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getSatus() {
        return satus;
    }
    public void setSatus(int satus) {
        this.satus = satus;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    

    
}
