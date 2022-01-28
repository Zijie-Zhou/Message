package com.zijie.Message.exception;
import com.zijie.Message.enums.Error;

public class MessageServiceException extends Exception {


    private Error error;

    public MessageServiceException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public Error getError() {
        return this.error;
    }

}
