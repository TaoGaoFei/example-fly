package org.example.fly.config;

import io.swagger.annotations.ApiOperation;
import org.example.fly.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.event.PaintEvent;

/**
 * @ClassName FilterConfig
 * @Author moon
 * @Date 2022/4/26
 * @Version V1.0
 **/
@Configuration
@ApiOperation(value = "注册过滤器")
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        AuthFilter authFilter = new AuthFilter();
        registrationBean.setFilter(authFilter);
        registrationBean.addUrlPatterns(authFilter.addUrlPatterns());
        registrationBean.setOrder(authFilter.order());
        registrationBean.setName("AuthFilter");
        return registrationBean;
    }

}
