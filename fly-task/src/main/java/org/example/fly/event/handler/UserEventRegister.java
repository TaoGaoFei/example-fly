package org.example.fly.event.handler;

import org.example.fly.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserEventRegister
 * @Description: TODO
 * @Author moon
 * @Date 2021/5/28
 * @Version V1.0
 **/
@Component
public class UserEventRegister {

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 事件发布
     */
    public void register(){
        User user = new User();
        user.setUserName("张三的传奇一生");
        user.setPassWord("admin1234");
        publisher.publishEvent(user);
    }
}
