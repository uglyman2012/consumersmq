package com.cp.consumersmq.mqconfig;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/06/18
 */
@Configuration
public class MqListener {
    @Bean
    public Queue queue001() {
        return new Queue("queue001", true); //队列持久
    }
    @Bean
    public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        //添加多个队列进行监听
        container.setQueues(queue001());
        //container.setQueueNames("queue001");
        //当前消费者数量
        container.setConcurrentConsumers(1);
        //最大消费者数量
        container.setMaxConcurrentConsumers(5);
        //设置重回队列，一般设置false
        container.setDefaultRequeueRejected(false);
        //设置自动签收机制
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //设置listener外露
        container.setExposeListenerChannel(true);
        //消费端标签生成策略
        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
            @Override
            public String createConsumerTag(String queue) {
                //每个消费端都有自己独立的标签
                return queue + "_" + UUID.randomUUID().toString();
            }
        });

        //消息监听
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                String msg = new String(message.getBody());
                System.err.println("----------消费者: " + msg);
            }
        });
        return container;
    }
}
