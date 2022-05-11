package org.example.fly.aspect;

import ch.qos.logback.classic.net.SyslogAppender;
import cn.hutool.core.date.DateUtil;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.fly.entity.SysLog;
import org.example.fly.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 系统日志切面
 * @ClassName SysLogAspect
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@Component
@Aspect
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 使用切入点表达式
     * 使用注解进行切面拦截
     * 还可以使用：(execution)
     * 1. 需要拦截的包
     * 2. 需要拦截的类
     * 3. 需要拦截的方法
     */
    @Pointcut("@annotation(org.example.fly.annotation.SysLog)")
    public void logPointCut(){

    }

    /**
     * 环绕通知
     * @return
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point,time);
        }catch (Exception e){
        }
        return proceed;
    }

    /**
     * 保存日志
     * @param point
     * @param time
     */
    private void saveLog(ProceedingJoinPoint point,long time){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        sysLog.setExeuTime(time);
        sysLog.setCreateTime(DateUtil.now());
        // 获取注解上的注释
        org.example.fly.annotation.SysLog annotation = method.getAnnotation(org.example.fly.annotation.SysLog.class);
        if (annotation != null){
            String value = annotation.value();
            sysLog.setRemark(value);
        }
        // 请求上的类名
        String className = point.getTarget().getClass().getName();
        // 方法签名
        String methodName = signature.getName();
        sysLog.setClassName(className);
        sysLog.setMethodName(methodName);
        // 获取参数
        Object[] args = point.getArgs();
        try {
            ArrayList<String> list = new ArrayList<>();
            for (Object arg : args) {
                list.add(new Gson().toJson(arg));
            }
        } catch (Exception e){
            // 异常打印
            sysLogService.print(sysLog);
        }

    }

}
