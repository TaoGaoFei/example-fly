package org.example.fly.service;

import org.example.fly.entity.SysLog;

/**
 * @ClassName SysLogService
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
public interface SysLogService {
    /**
     * 打印
     * @param sysLog
     * @return
     */
     boolean print(SysLog sysLog);
}
