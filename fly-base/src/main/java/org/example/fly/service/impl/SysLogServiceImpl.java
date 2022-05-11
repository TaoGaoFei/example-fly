package org.example.fly.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.fly.entity.SysLog;
import org.example.fly.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysLogServiceImpl
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@Slf4j
@Service
public class SysLogServiceImpl implements SysLogService {

    @Override
    public boolean print(SysLog sysLog) {
        log.info(sysLog.getParams());
        return true;
    }

}
