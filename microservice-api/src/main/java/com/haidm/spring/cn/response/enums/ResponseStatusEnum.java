package com.haidm.spring.cn.response.enums;

/**
 * @ClassName ResponseStatusEnum
 * @Description 状态码枚举类
 * @Author sh-manhd
 * @Date 2019/5/30 10:37
 * @Version 1.0
 **/
public enum  ResponseStatusEnum {

    SYSTEMEXCEPTION("10001","系统异常，请联系管理员"),
    PARAMERROR("10002","参数错误，请检查"),
    PARAMEMPTY("10003","参数为空，请检查"),
    NODATA("10004","未查询到数据"),
    SUCCESS("10005","成功"),
    ERROR("10006","未知错误，请联系管理员"),
    FAIL("10008","失败");


    private String respCode;
    private String respMsg;

    ResponseStatusEnum(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

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
}
