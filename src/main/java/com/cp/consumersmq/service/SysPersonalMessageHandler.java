package com.cp.consumersmq.service;

import com.alibaba.fastjson.JSON;
import com.cp.consumersmq.bean.SysPersonalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

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

    @StreamListener(value = Processor.INPUT,condition = "headers['payload_simple_name']=='SysPersonalInfoVO'")
    public void sysPersonalMessageListnner(@Payload SysPersonalInfo sysPersonalInfo) {
        log.info("会员订单T逍客mq信息: {}", JSON.toJSONString(sysPersonalInfo));
        int a=9/0;
    }

}
