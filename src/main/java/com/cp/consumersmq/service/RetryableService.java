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

    @Retryable(value = {Exception.class },maxAttempts = 6,backoff = @Backoff(delay = 2000,multiplier = 3))
    public String test() throws Exception {
        System.out.println("失败是成功之母");
        throw new Exception("ppp");
        //return "ppp";
    }

    @Recover
    public String recover(Exception e) {//返回参数必须一致,否则失效
        System.out.println("失败了");
        return "666";
    }
}
