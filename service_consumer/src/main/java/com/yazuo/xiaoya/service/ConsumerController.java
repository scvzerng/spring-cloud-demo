package com.yazuo.xiaoya.service;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * Created by scvzerng on 2017/9/4.
 */
@RestController
@RefreshScope
public class ConsumerController {
    @Value("${test}")
    private String test;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Resource
    TestService testService;
    @GetMapping
    @HystrixCommand(fallbackMethod = "errorTest")
    public JSONObject test(){
        return testService.getTestInfo();
    }
    @GetMapping("/props/{key}")
    public String getProps(@PathVariable String key){
        return test;
    }
    public JSONObject errorTest(){
        JSONObject json = new JSONObject();
        json.put("status","error");
        return json;
    }
}
