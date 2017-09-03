package com.yazuo.xiaoya.test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by scvzerng on 2017/9/3.
 */
@RestController
public class MyController {
    @GetMapping
    public JSONObject sayHello(){
        JSONObject json = new JSONObject();
        json.put("key","value");
        return json;
    }
}
