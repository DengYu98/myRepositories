package com.dy;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT),
        value = @Queue(value = "${mq.config.queue.push}",autoDelete = "true")
))
public class PushReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("Push........receiver: "+msg);
    }
}
