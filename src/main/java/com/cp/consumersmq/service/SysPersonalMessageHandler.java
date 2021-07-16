package com.cp.consumersmq.service;

import com.alibaba.fastjson.JSON;
import com.cp.consumersmq.bean.SysPersonalInfo;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>
 *会员订单T逍客直营和零售上报mq消息处理
 * </p>
 *
 * @author yang
 * @since 2021/06/04
 */
@Component
@EnableBinding(Processor.class)
public class SysPersonalMessageHandler {
    private static Logger log = LoggerFactory.getLogger(SysPersonalMessageHandler.class);

    @StreamListener(value = Processor.INPUT,condition = "headers['payload_simple_name']=='SysPersonalInfoVO2'")
    public void sysPersonalMessageListnner(@Payload SysPersonalInfo sysPersonalInfo ) {
        log.info("会员订单T逍客mq信息: {}", JSON.toJSONString(sysPersonalInfo));

    }
    @StreamListener(value = Processor.INPUT,condition = "headers['payload_simple_name']=='SysPersonalInfoVO3'")
    public void sysPersonalMessageListnner3(Message<String> message ) {
        log.info("会员订单T逍客mq信息: {}", JSON.toJSONString(message));

    }
    /**
     * 配置文件需要开启消息确认为手动模式
     */
    @StreamListener(value = Processor.INPUT,condition = "headers['payload_simple_name']=='SysPersonalInfoVO'")
    public void sysPersonalMessageListnner2(@Payload SysPersonalInfo sysPersonalInfo , @Header(AmqpHeaders.CHANNEL) Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) Long DELIVERY_TAG) throws IOException, InterruptedException {

        log.info("会员订单T逍客mq信息: {}", JSON.toJSONString(sysPersonalInfo));

        channel.basicAck(DELIVERY_TAG,false);
        //channel.basicNack(DELIVERY_TAG,false,false);

    }
    //@StreamListener("errorChannel")
    //public void error(Message<?> message) {
    //    ErrorMessage errorMessage = (ErrorMessage) message;
    //    System.err.println("Handling ERROR: " + errorMessage);
    //}

}
