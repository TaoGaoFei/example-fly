package org.example.fly.controller;

import org.example.fly.annotation.SysLog;
import org.example.fly.base.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysLogController
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @SysLog("日志模块")
    @GetMapping("/test")
    public String test(@RequestParam String name){
        return name;
    }

}
