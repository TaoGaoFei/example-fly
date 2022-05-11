package org.example.fly.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @// TODO: 两阶段终止模式优雅的停止线程任务
 * @ClassName TwoPhaseTermination
 * @Author moon
 * @Date 2021/11/7
 * @Version V1.0
 **/
@Slf4j(topic = "c.TwoPhaseTermination")
public class TwoPhaseTermination {


    /**
     * 一个监控线程
     */
    private Thread monitor;

    /**
     * 启动监控线程
     */
    public void start(){

        monitor = new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    log.debug("料理后事，再见");
                    break;
                }
                try {
                    Thread.sleep(2000);
                    log.debug("监控任务执行中");
                } catch (InterruptedException e) {
                    monitor.interrupt();
                    // 打断时异常
                    e.printStackTrace();
                }
            }
        });

        // 执行线程方法
        monitor.start();

    }

    /**
     * 停止监控线程
     */
    public void end(){

        // 设置打断标记
        monitor.interrupt();
    }


}
