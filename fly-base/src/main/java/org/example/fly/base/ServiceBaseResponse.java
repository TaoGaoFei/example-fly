package org.example.fly.base;

import com.sun.prism.shader.Solid_RadialGradient_REFLECT_AlphaTest_Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName ServiceBaseResponse
 * @Author moon
 * @Date 2021/12/6
 * @Version V1.0
 **/
public class ServiceBaseResponse implements Serializable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBaseResponse.class);
    private static final long serialVersionUID = -8119907062719154286L;


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

    public ServiceBaseResponse() {
    }

    public ServiceBaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBaseResponse that = (ServiceBaseResponse) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(msg, that.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg);
    }



}
