package com.wp.exception;

import com.wp.pojo.dto.HandlerResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorityException extends BaseException {
    private HandlerResult<String> handlerResult;

    public AuthorityException(HandlerResult<String> handlerResult) {
        super(handlerResult.getMsg());
        this.handlerResult = handlerResult;
    }
}
