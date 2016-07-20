package com.pro.foru.net;


import com.alibaba.fastjson.JSON;

/**
 * Created by hjy on 16/6/22.
 */
public class BaseResponse {
    public JSON data;
    public String code;
    public String msg;

    public <T> T getData(Class<T> type) {
        return JSON.parseObject(data.toJSONString(), type);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
