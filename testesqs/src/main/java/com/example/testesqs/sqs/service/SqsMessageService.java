package com.example.testesqs.sqs.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service

public class SqsMessageService {
    @Value("${sqsFila}")
    private String queueName;

    private final QueueMessagingTemplate queueMessagingTemplate;

    @Autowired
    public SqsMessageService(String queueName, AmazonSQSAsync amazonSQSAsync){
        this.queueMessagingTemplate = new QueueMessagingTemplate(amazonSQSAsync);
    }

    public void sendMessage(String message){
        this.queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(message).build());
    }
}
