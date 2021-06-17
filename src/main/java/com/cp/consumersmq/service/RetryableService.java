package com.cp.consumersmq.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/06/17
 */
@Service
public class RetryableService {

    @Retryable(value = {Exception.class },maxAttempts = 2,backoff = @Backoff(delay = 2000,multiplier = 3))
    public void test() throws Exception {//如果有返回参数,recover方法失效
        System.out.println("失败是成功之母");
        throw new Exception("ppp");
        //return "ppp";
    }

    @Recover
    public void recover(Exception e) {
        System.out.println("失败了");
    }
}
