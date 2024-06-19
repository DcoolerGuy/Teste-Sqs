package com.example.testesqs.sqs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Mensagem {
    private String name;
    private String content;
}
