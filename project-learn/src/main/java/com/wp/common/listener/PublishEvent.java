package com.wp.common.listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class PublishEvent extends ApplicationEvent {

    private String methodName;

    public PublishEvent(Object source) {
        super(source);
    }

    public PublishEvent(Object source, String methodName) {
        super(source);
        this.methodName = methodName;
    }
}
