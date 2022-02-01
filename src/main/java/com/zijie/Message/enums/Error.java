package com.zijie.Message.enums;

public enum Error {
    OK(1000, "successful"),
    USER_ALREADY_EXISTS(2000, "Username is already existing."),
    NICKNAME_ALREADY_EXISTS(2002, "Nickname is already existing."),
    PHONE_ALREADY_EXISTS(2003, "Phone number is already existing."),
    USER_NOT_EXISTS(2004, "Username does not exist."),
    PASSWORD_NOT_RIGHT(2005, "Password is not right."),
    PASSWORD_NOT_MATCH(2001, "Password doesn't matc.h");

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
