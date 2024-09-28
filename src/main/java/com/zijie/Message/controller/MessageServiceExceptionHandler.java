package com.zijie.Message.controller;

import com.zijie.Message.exception.MessageServiceException;
import com.zijie.Message.response.BaseResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MessageServiceExceptionHandler {

    @ExceptionHandler(MessageServiceException.class)
    @ResponseBody
    protected BaseResponse handleServiceException(MessageServiceException ex) {
        BaseResponse baseResponse = new BaseResponse(ex.getError().getCode(), ex.getError().getMessage());
        return baseResponse;
    }

}
