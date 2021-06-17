package com.cp.consumersmq.controller;


import com.cp.consumersmq.service.RetryableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/06/02
 */
@RestController
@RequestMapping("test")
@Api(tags = "rabbitmq测试")
public class TestController {

    @Autowired
    private RetryableService retryableService;

    @GetMapping("/test2")
    @ApiOperation("test2测试")
    public String test1() throws Exception {
        retryableService.test();
        return "success";
    }
}
