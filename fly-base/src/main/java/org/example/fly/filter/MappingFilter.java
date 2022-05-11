package org.example.fly.filter;

import io.swagger.annotations.ApiOperation;

import javax.servlet.Filter;

/**
 * @ClassName MappingFilter
 * @Author moon
 * @Date 2022/4/26
 * @Version V1.0
 **/
@ApiOperation(value = "映射过滤器（封装Filter）")
public interface MappingFilter extends Filter {

    String[] addUrlPatterns();

    int order();

}
