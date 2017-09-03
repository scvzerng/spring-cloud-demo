package com.yazuo.xiaoya.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Collection;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

/**
 *
 * Created by scvzerng on 2017/9/3.
 */
public class JSONUtils {
    public  static <T>  String perttyFormat(T t){
        return t instanceof Collection? JSONArray.toJSONString(t,PrettyFormat):JSON.toJSONString(t, PrettyFormat);
    }
}
