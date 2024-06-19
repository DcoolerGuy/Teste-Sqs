package com.example.testesqs.sqs.controller;

import com.example.testesqs.sqs.core.MessageSender;
import com.example.testesqs.sqs.model.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producer")
public class SqsMessageController {

    @Autowired
    private MessageSender messageSender;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody Mensagem message){
        messageSender.send(message.toString());
        return ResponseEntity.ok().build();
    }
}
