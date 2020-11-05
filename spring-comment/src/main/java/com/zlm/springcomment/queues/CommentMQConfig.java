package com.zlm.springcomment.queues;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentMQConfig {
    @Bean
    public Queue create(){
        return new Queue("Comment");
    }
}
