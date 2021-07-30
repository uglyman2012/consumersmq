package com.cp.consumersmq.service.mq;

import com.cp.consumersmq.bean.Order;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/07/27
 */
public class MessageDelegate {

    public void handleMessage(String messageBody) {
        System.err.println("默认方法, 消息内容:" + new String(messageBody));
    }
    public void consumeMessage(byte[] messageBody) {
        System.err.println("字节数组方法, 消息内容:" + new String(messageBody));
    }
    public void consumeMessage(String messageBody) {
        System.err.println("字节数组方法1, 消息内容:" + new String(messageBody));
    }
    public void consumeMessage(Map messageBody) {
        System.err.println("字节数组方法2, 消息内容:" + messageBody);
    }
    public void consumeMessage( Order order) {
        System.err.println("order对象, 消息内容3, id: " + order.getId() +
                ", name: " + order.getName() +
                ", content: "+ order.getContent());
    }
}
