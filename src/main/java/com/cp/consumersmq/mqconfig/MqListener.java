package com.cp.consumersmq.mqconfig;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    //@Bean
    //public Queue queue001() {
    //    return new Queue("queue001", true); //队列持久
    //}

    //@Bean
    //public SimpleMessageListenerContainer messageContainer(ConnectionFactory connectionFactory) {
    //
    //    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
    //    //添加多个队列进行监听
    //    container.setQueues(queue001());
    //    //container.setQueueNames("queue001");
    //    //当前消费者数量
    //    container.setConcurrentConsumers(1);
    //    //最大消费者数量
    //    container.setMaxConcurrentConsumers(5);
    //    //设置重回队列，一般设置false
    //    container.setDefaultRequeueRejected(false);
    //    //设置自动签收机制
    //    container.setAcknowledgeMode(AcknowledgeMode.AUTO);
    //    //设置listener外露
    //    container.setExposeListenerChannel(true);
    //    //消费端标签生成策略
    //    container.setConsumerTagStrategy(new ConsumerTagStrategy() {
    //        @Override
    //        public String createConsumerTag(String queue) {
    //            //每个消费端都有自己独立的标签
    //            return queue + "_" + UUID.randomUUID().toString();
    //        }
    //    });
    //
    //    //消息监听
    //    //container.setMessageListener(new ChannelAwareMessageListener() {
    //    //    @Override
    //    //    public void onMessage(Message message, Channel channel) throws Exception {
    //    //        String msg = new String(message.getBody());
    //    //        System.err.println("----------消费者: " + msg);
    //    //    }
    //    //});
    //    MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageDelegate());
    //    messageListenerAdapter.setDefaultListenerMethod("consumeMessage");
    //    //HashMap<String, String> map = new HashMap<>();
    //    //map.put("queue001","consumeMessage3");
    //    //messageListenerAdapter.setQueueOrTagToMethodName(map);
    //    //messageListenerAdapter.setMessageConverter(new TextMessageConverter());
    //    DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();
    //    Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
    //    idClassMapping.put("order", com.cp.consumersmq.bean.Order.class);
    //    javaTypeMapper.setIdClassMapping(idClassMapping);
    //    Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
    //    jackson2JsonMessageConverter.setJavaTypeMapper(javaTypeMapper);
    //
    //    messageListenerAdapter.setMessageConverter(jackson2JsonMessageConverter);
    //    container.setMessageListener(messageListenerAdapter);
    //    return container;
    //}
//    @Bean
//    public SimpleMessageListenerContainer messageContainer2(ConnectionFactory connectionFactory) {
//
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
//        //添加多个队列进行监听
//        container.setQueues(queue001());
//        //container.setQueueNames("queue001");
//        //当前消费者数量
//        container.setConcurrentConsumers(1);
//        //最大消费者数量
//        container.setMaxConcurrentConsumers(5);
//        //设置重回队列，一般设置false
//        container.setDefaultRequeueRejected(false);
//        //设置自动签收机制
//        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        //设置listener外露
//        container.setExposeListenerChannel(true);
//        //消费端标签生成策略
//        container.setConsumerTagStrategy(new ConsumerTagStrategy() {
//            @Override
//            public String createConsumerTag(String queue) {
//                //每个消费端都有自己独立的标签
//                return queue + "_" + UUID.randomUUID().toString();
//            }
//        });
//
//        //消息监听
//        //container.setMessageListener(new ChannelAwareMessageListener() {
//        //    @Override
//        //    public void onMessage(Message message, Channel channel) throws Exception {
//        //        String msg = new String(message.getBody());
//        //        System.err.println("----------消费者: " + msg);
//        //    }
//        //});
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new MessageDelegate());
//        messageListenerAdapter.setDefaultListenerMethod("consumeMessage");
//        //HashMap<String, String> map = new HashMap<>();
//        //map.put("queue001","consumeMessage3");
//        //messageListenerAdapter.setQueueOrTagToMethodName(map);
//        //messageListenerAdapter.setMessageConverter(new TextMessageConverter());
//
//        ContentTypeDelegatingMessageConverter convert = new ContentTypeDelegatingMessageConverter();
//        TextMessageConverter textConvert = new TextMessageConverter();
////text走文本转换器
//        convert.addDelegate("text", textConvert);
////        convert.addDelegate("html/text", textConvert);
////        convert.addDelegate("xml/text", textConvert);
////        convert.addDelegate("text/plain", textConvert);
////json走json转换器
//        DefaultJackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();
//        Map<String, Class<?>> idClassMapping = new HashMap<String, Class<?>>();
//        idClassMapping.put("order", com.cp.consumersmq.bean.Order.class);
//        javaTypeMapper.setIdClassMapping(idClassMapping);
//        Jackson2JsonMessageConverter jsonConvert = new Jackson2JsonMessageConverter();
//        jsonConvert.setJavaTypeMapper(javaTypeMapper);
//        convert.addDelegate("json", jsonConvert);
//        convert.addDelegate("application/json", jsonConvert);
//
//        messageListenerAdapter.setMessageConverter(convert);
//        container.setMessageListener(messageListenerAdapter);
//        return container;
//    }
    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);             //开启手动 ack
        return factory;
    }
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
