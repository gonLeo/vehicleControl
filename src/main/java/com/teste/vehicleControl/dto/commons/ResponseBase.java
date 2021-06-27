package com.teste.vehicleControl.dto.commons;

public class ResponseBase<T> {
    private boolean success = true;
    private int status;
    private String message;
    private T data;

    public boolean isSuccess() {
        return success;
    }
    public ResponseBase<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }
    public int getStatus() {
        return status;
    }
    public ResponseBase<T> setStatus(int status) {
        this.status = status;
        return this;
    }
    public String getMessage() {
        return message;
    }
    public ResponseBase<T> setMessage(String message) {
        this.message = message;
        return this;
    }
    public T getData() {
        return data;
    }
    public ResponseBase<T> setData(T data) {
        this.data = data;
        return this;
    }
    
    
    
}
