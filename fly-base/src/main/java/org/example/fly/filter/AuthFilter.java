package org.example.fly.filter;

import io.swagger.annotations.ApiOperation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName AuthFilter
 * @Author moon
 * @Date 2022/4/26
 * @Version V1.0
 **/
@ApiOperation(value = "权限过滤器")
public class AuthFilter implements MappingFilter {

    @Override
    public String[] addUrlPatterns() {
        return new String[]{"/*"};
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 执行过滤方法
        chain.doFilter(request,response);
    }
}
