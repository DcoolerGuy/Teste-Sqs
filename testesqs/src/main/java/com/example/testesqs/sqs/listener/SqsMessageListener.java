package com.example.testesqs.sqs.listener;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SqsMessageListener {

    @SqsListener("${sqsFila}")
    public void queueListener(String message){
        try {
            log.info(message);
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
