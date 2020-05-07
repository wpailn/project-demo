package com.wp.common.handler;

import com.wp.exception.NullDataException;
import com.wp.pojo.dto.HandlerResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HandlerResult> exceptionHandler(Exception e){
        log.error("异常信息======>");
        e.printStackTrace();
        HandlerResult handlerResult;
        if(e instanceof NullDataException){
            handlerResult = ((NullDataException) e).getHandlerResult();
        }else {
            handlerResult = new HandlerResult<>(false,500,e.getMessage(),null);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(handlerResult);
    }
}