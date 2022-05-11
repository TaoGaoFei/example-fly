package org.example.fly;

import org.example.fly.annotation.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName SysLogTest
 * @Author moon
 * @Date 2022/3/7
 * @Version V1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysLogTest {

    @SysLog(value = "≤‚ ‘")
    @Test
    public void printTest(){
        System.out.println("sys");
    }
}
