package com.haidm.spring.cn.response;

import com.haidm.spring.cn.response.enums.ResponseStatusEnum;

/**
 * @ClassName ResponseParam
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/22 9:36
 * @Version 1.0
 **/
public class ResponseParam<T> {

    private String respCode = ResponseStatusEnum.SUCCESS.getRespCode();

    private String respMsg = ResponseStatusEnum.SUCCESS.getRespMsg();

    private T respInfo;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getRespInfo() {
        return respInfo;
    }

    public void setRespInfo(T respInfo) {
        this.respInfo = respInfo;
    }
}
