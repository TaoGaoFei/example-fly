package org.example.fly.config;

import org.example.fly.base.ServiceResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 增强型拦截器
 * @ClassName FlyControllerAdvice
 * @Author moon
 * @Date 2021/12/6
 * @Version V1.0
 **/
@ControllerAdvice
public class FlyControllerAdvice {

    @ResponseBody
    @ExceptionHandler({Exception.class})
    public Object validHandler(Exception e){
        String message = e.getMessage();
        ServiceResponse response = new ServiceResponse();
        response.setError(message);
        return response;
    }

}
