package org.example.fly.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName InitThread
 * @Author moon
 * @Date 2021/11/7
 * @Version V1.0
 **/
@Slf4j(topic = "c.InitThread")
public class InitThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test4();
    }

    /**
     * 直接创建线程
     */
    private void test1(){
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t1.setName("t1");
        t1.start();
        log.debug("running");
    }

    /**
     * 线程与任务分离
     */
    private void test2(){
        // 创建任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("running....");
            }
        };
        // 创建线程
        Thread t1 = new Thread(runnable, "t1");
        // 执行线程任务
        t1.start();
    }

    /**
     * 使用Lambda表达式进行创建
     */
    private void test2Plus(){
        // 创建线程
        Thread t1 = new Thread(() -> {
            log.debug("running....");
        }, "t1");
        // 执行线程任务
        t1.start();
    }

    /***
     * 可以返回线程执行结果
     */
    private static void test4() throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // 线程任务
                Thread.sleep(1100);
                // 可返回线程执行结果
                return 10000;
            }
        });

        Thread t2 = new Thread(task, "t2");
        t2.start();
        log.debug("{}",task.get());
    }

    /**
     * 使用Lambda表达式
     */
    private void test54Plus(){
        FutureTask<String> task = new FutureTask<>(()-> {
            log.debug("running...");
            return String.valueOf(100);
        });
        new Thread(task,"t3").start();
    }

}
