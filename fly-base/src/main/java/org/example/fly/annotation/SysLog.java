package org.example.fly.annotation;

import java.lang.annotation.*;

/**
 * 定义系统日志注解
 * @ClassName SysLog
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@Target(ElementType.METHOD)  // 方法上
@Retention(RetentionPolicy.RUNTIME)  // 运行时
@Documented
public @interface SysLog {
    String value() default "";
}
