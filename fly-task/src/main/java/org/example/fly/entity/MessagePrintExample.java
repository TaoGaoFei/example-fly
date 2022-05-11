package org.example.fly.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessagePrintExample
 * @Author moon
 * @Date 2021/5/7
 * @Version V1.0
 **/
@Data
@Component
public class MessagePrintExample {

    /**
     * 内部类
     */
    @Data
    private class MessagePrintTask implements Runnable {
        private String name;

        public MessagePrintTask(String name) {
            this.name = name;
        }

        // 实现线程方法
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + name);
        }
    }

    public MessagePrintExample() {
    }

    @Autowired
    private TaskExecutor taskExecutor;

    public void printMessage(){
        for (int i = 0;i < 25;i++){
            // 执行一个线程任务
            taskExecutor.execute(new MessagePrintTask("张三在此"+i));
        }
    }
}
