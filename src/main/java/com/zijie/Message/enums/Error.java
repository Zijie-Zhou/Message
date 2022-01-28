package com.zijie.Message.enums;

public enum Error {
    OK(1000, "successful"),
    USER_ALREADY_EXISTS(2000, "Username is already existing."),
    PASSWORD_NOT_MATCH(2001, "Password doesn't match");
    private int code;
    private String message;

    Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
