package com.haidm.spring.cn.request;

import java.io.Serializable;

/**
 * @ClassName RequestHead
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/22 9:25
 * @Version 1.0
 **/
public class RequestHead implements Serializable {

    //请求编码
    private String reqCode;

    //请求时间
    private String reqTime;

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }
}
