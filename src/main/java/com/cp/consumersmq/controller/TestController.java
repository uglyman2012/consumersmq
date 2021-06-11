package com.cp.consumersmq.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping("/test1")
    @ApiOperation("test1测试")
    public String test1() {
        return "success";
    }
}
