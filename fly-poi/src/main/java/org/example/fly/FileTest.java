package org.example.fly;

import java.io.File;

/**
 * @ClassName FileTest
 * @Author moon
 * @Date 2021/5/26
 * @Version V1.0
 **/
public class FileTest {

    public static void main(String[] args) {
        // 执行方法
        test01();
    }

    /**
     * 获取相对路径
     */
    private static void test02(){
        String property = System.getProperty("user.dir");
        String paths = property + "/fly-poi/src/main/resources/temp/2.xlsx";
        File file = new File(paths);
        if (file.exists()){
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }

    /**
     * 获取相对路径
     */
    private static void test01(){
        String path = FileTest.class.getClassLoader().getResource("temp/2.xlsx").getPath();
        System.out.println(path);
        File file = new File(path);
        if (file.exists()){
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }
    }
}
