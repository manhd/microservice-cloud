package com.haidm.spring.cn.request;

/**
 * @ClassName RequestParam
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/22 9:26
 * @Version 1.0
 **/
public class RequestParam<T> {

    private RequestHead reqHead;

    private T reqBody;

    public RequestHead getReqHead() {
        return reqHead;
    }

    public void setReqHead(RequestHead reqHead) {
        this.reqHead = reqHead;
    }

    public T getReqBody() {
        return reqBody;
    }

    public void setReqBody(T reqBody) {
        this.reqBody = reqBody;
    }
}
