package com.cp.consumersmq.service.mq;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/07/27
 */
public class MessageDelegate {

    public void handleMessage(byte[] messageBody) {
        System.err.println("默认方法, 消息内容:" + new String(messageBody));
    }
    public void consumeMessage(byte[] messageBody) {
        System.err.println("字节数组方法, 消息内容:" + new String(messageBody));
    }
}
