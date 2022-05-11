package org.example.fly.event;

import org.example.fly.event.handler.UserEventRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PublishEventController
 * @Description: TODO
 * @Author moon
 * @Date 2021/5/28
 * @Version V1.0
 **/
@RestController
@RequestMapping("/event")
public class PublishEventController {

    @Autowired
    private UserEventRegister register;

    @GetMapping("/registerUser")
    public void register(){
        register.register();
    }

}
