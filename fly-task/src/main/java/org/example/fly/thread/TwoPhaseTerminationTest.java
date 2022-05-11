package org.example.fly.thread;

/**
 * @ClassName TwoPhaseTerminationTest
 * @Author moon
 * @Date 2021/11/7
 * @Version V1.0
 **/
public class TwoPhaseTerminationTest {

    /**
     * 执行监控单元
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        // 主线在等待  监控线程正常执行
        Thread.sleep(5000); 
        twoPhaseTermination.end();

    }
}
