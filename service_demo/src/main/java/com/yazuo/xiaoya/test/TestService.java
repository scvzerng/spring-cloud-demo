package com.yazuo.xiaoya.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yazuo.xiaoya.utils.JSONUtils;

/**
 * Created by scvzerng on 2017/9/3.
 */
public class TestService {
    public static void main(String[] args) {
        JSONArray array = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("key","value");
        array.add(json);
        System.out.println(JSONUtils.perttyFormat(array));
    }
}
