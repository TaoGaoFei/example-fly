package org.example.fly.event.handler;

import org.example.fly.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserEventListener
 * @Description: TODO
 * @Author moon
 * @Date 2021/5/28
 * @Version V1.0
 **/
@Component
public class UserEventListener {

    /**
     *
     * 处理事件
     * condition使用的是SpEL表达式
     */
    @EventListener(condition = "#user != null")
    public void handleEvent(User user){
        System.out.println(user.getUserName());
        System.out.println(user.getPassWord());
    }

}
