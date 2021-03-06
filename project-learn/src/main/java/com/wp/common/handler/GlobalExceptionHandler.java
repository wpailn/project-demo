package com.wp.common.handler;

import com.wp.exception.AuthorityException;
import com.wp.exception.NullDataException;
import com.wp.pojo.dto.HandlerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HandlerResult> exceptionHandler(Exception e){
        HandlerResult handlerResult;
        if(e instanceof AuthorityException){
            handlerResult = ((AuthorityException) e).getHandlerResult();
        }
        if(e instanceof NullDataException){
            handlerResult = ((NullDataException) e).getHandlerResult();
        }
        if(e instanceof BindException){
            handlerResult = HandlerResult.failed(Objects.requireNonNull(((BindException) e).getBindingResult().getFieldError()).getDefaultMessage());
        }
        handlerResult = HandlerResult.failed(e.getMessage());
        log.error("异常信息======>{}",e.getMessage(),e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerResult);
    }
}
