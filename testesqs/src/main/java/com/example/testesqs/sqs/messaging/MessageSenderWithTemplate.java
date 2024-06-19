package com.example.testesqs.sqs.messaging;

import com.example.testesqs.sqs.core.MessageSender;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class MessageSenderWithTemplate implements MessageSender {
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${aws.queue.name}")
    private String queueName;

     /*
        As mensagens são criadas usando a classe auxiliar do MessageBuilder.
        O MessageBuilder fornece dois métodos de fábrica para criar mensagens de uma mensagem
        existente ou com um objeto Payload.
      */

    @Override
    public void send(String messagePayload) {
        Message<String> msg = MessageBuilder.withPayload(messagePayload)
                .setHeader("TransactionId", "123")
                .setHeaderIfAbsent("country", "BR")
                .build();

        queueMessagingTemplate.convertAndSend(queueName, msg);
    }
}
