package com.zlm.springcomment.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "comment")
public class CommentListener {
    @RabbitHandler
    public void msg(){

    }
}
