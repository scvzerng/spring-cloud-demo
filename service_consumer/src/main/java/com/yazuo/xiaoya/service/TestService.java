package com.yazuo.xiaoya.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by scvzerng on 2017/9/4.
 */
@FeignClient("SPRING-CLOUD-DEMO-SERVICE-PROVIDER")
public interface TestService {
    @RequestMapping(method = RequestMethod.GET,value = "/")
    JSONObject getTestInfo();
}
