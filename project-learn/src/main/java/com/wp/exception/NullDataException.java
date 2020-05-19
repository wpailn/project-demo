package com.wp.exception;

import com.wp.pojo.dto.HandlerResult;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NullDataException extends BaseException {
    private HandlerResult<String> handlerResult;

    public NullDataException(HandlerResult<String> handlerResult) {
        super(handlerResult.getMsg());
        this.handlerResult = handlerResult;
    }
}
