package com.cp.consumersmq.service.mq;

import com.cp.consumersmq.bean.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/07/30
 */
@Component
public class RabbitReceiver {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue003",
                    durable="true"),
            exchange = @Exchange(value = "topic003",
                    durable="true",
                    type= "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    )
    )
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        System.err.println("--------------------------------------");
        System.err.println("消费端Payload1: " + message.getPayload());
        Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK,获取deliveryTag
        //channel.basicAck(deliveryTag, false);
        //int a=9/0;
        channel.basicNack(deliveryTag,false,false);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue004",
                    durable="true"),
            exchange = @Exchange(value = "topic002",
                    durable="true",
                    type= "topic",
                    ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
    )
    )
    @RabbitHandler
    public void onMessage2(Order message, Channel channel, @Header(value =AmqpHeaders.DELIVERY_TAG )Long deliveryTag) throws Exception {
        System.err.println("--------------------------------------");
        System.err.println("消费端Payload2: " + message);
        //Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ACK,获取deliveryTag
        //channel.basicAck(deliveryTag, false);
        channel.basicNack(deliveryTag,false,false);
    }
}
