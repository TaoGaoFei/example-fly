package org.example.fly.base;

import java.util.Objects;

/**
 * @ClassName ServiceResponse
 * @Author moon
 * @Date 2021/12/6
 * @Version V1.0
 **/
public class ServiceResponse<T> extends ServiceBaseResponse{

    private static final long serialVersionUID = -8119907062719154286L;
    private T body;

    public ServiceResponse() {
        this.setCode(BaseStateCode.成功.getCode());
        this.setMsg(BaseStateCode.成功.getMsg());
    }

    public ServiceResponse(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public void setError(String msg){
        this.setCode(BaseStateCode.异常.getCode());
        this.setError(msg);
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceResponse<?> that = (ServiceResponse<?>) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), body);
    }
}
