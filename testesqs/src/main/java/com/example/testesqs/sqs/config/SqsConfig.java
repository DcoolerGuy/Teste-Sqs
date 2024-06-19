package com.example.testesqs.sqs.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {
    @Value("${aws.queue.endpoint")
    private String endpoint;

    @Value("${aws.region.static}")
    private String region;

    @Value("${aws.queue.name}")
    private String queueName;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync){
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

    @Bean
    public AmazonSQSAsync amazonSQS(){
        AmazonSQSAsync amazonSQSAsync = AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withEndpointConfiguration(new AwsClientBuilder.
                        EndpointConfiguration(
                                endpoint, region
                )).build();

        /*
         * Criando uma fila com o nome especificado na variavel aws.queue.name do arquivo de propriedades
         * no localstack
         */

        CreateQueueResult queue = amazonSQSAsync.createQueue(queueName);

        return amazonSQSAsync;
    }
}
