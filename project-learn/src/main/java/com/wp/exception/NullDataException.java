package com.wp.exception;

import com.wp.pojo.dto.HandlerResult;

public class NullDataException extends BaseException {

    private HandlerResult<String> handlerResult;

    public NullDataException() {
        super();
    }

    public NullDataException(HandlerResult<String> handlerResult) {
        super(handlerResult.getMsg());
        this.handlerResult = handlerResult;
    }

    public HandlerResult getHandlerResult() {
        return handlerResult;
    }

    public void setHandlerResult(HandlerResult<String> handlerResult) {
        this.handlerResult = handlerResult;
    }
}
