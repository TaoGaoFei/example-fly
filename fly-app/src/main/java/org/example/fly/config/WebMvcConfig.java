package org.example.fly.config;

import org.example.fly.interceptors.SimpleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebMvcConfig
 * @Author moon
 * @Date 2021/11/19
 * @Version V1.0
 **/
@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截的类
        registry.addInterceptor(new SimpleInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("user/login","user/toLogin","js/**");
    }

    /**
     * 页面跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 冲定向跳转
        registry.addRedirectViewController("/","/login");
    }

    /**
     * 静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResoureHandler: 指的是对外暴露的访问路径
        // addResourceLocations: 指的是内部文件放置的目录
        registry.addResourceHandler("/my/**")
                .addResourceLocations("classpath:/my/*");
    }

    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");

    }
}
