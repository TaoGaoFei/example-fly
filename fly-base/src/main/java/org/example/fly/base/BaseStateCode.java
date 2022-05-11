package org.example.fly.base;

/**
 * @ClassName BaseStateCode
 * @Author moon
 * @Date 2021/12/6
 * @Version V1.0
 **/
public enum BaseStateCode {

    // 基础状态码
    成功("0000","操作成功！"),
    失败("9999","操作失败！"),
    异常("1024","服务器异常！");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    BaseStateCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
