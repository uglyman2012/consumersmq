package com.cp.consumersmq.config;


import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/06/02
 */
@Configuration
public class RabbitMQConfig {

    //相当于<Bean id="connectionFactory"></Bean>
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("10.68.244.130:5672");
        connectionFactory.setUsername("test");
        connectionFactory.setPassword("123456");
        //connectionFactory.setVirtualHost("/vhost_cp");
        return connectionFactory;
    }
    //@Bean
    //public CachingConnectionFactory rabbitConnectionFactory() {
    //    CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
    //    connectionFactory.setUsername(username);
    //    connectionFactory.setPassword(password);
    //    connectionFactory.setPort(port);
    //    return connectionFactory;
    //}

    //形参名称要与bean的方法名保持一致
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //使用单独的发送连接，避免生产者由于各种原因阻塞而导致消费者同样阻塞
        rabbitTemplate.setUsePublisherConnection(true);
        return rabbitTemplate;
    }
}
