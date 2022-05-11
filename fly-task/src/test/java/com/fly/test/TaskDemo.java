package com.fly.test;

import org.example.fly.config.TaskConfig;
import org.example.fly.entity.MessagePrintExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TaskDemo
 * @Author moon
 * @Date 2021/5/7
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TaskConfig.class)
public class TaskDemo {


    @Test
    public void test(){
        MessagePrintExample example = new MessagePrintExample();
        example.printMessage();
    }


}
