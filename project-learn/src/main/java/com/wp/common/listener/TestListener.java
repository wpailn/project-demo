package com.wp.common.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @EventListener
    public void listenTestApi(PublishEvent publishEvent){
        System.out.println(publishEvent.getMethodName());
    }
}
