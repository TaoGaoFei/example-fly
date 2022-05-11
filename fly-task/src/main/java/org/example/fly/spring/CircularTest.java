package org.example.fly.spring;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 循环依赖的问题
 * @ClassName CircularTest
 * @Author moon
 * @Date 2022/3/3
 * @Version V1.0
 **/
public class CircularTest {

    /**
     * // 实例化对象的时候
     *         // 1. 开始实例化Circular1
     *         // 2. 创建Circular2属性
     *         // 3. 实例化Circular2
     *         // 4. 创建Circular1属性
     *
     *  解决问题
     *  1. 在创建创建A对象后，将对象提前暴露
     *  2. 然后在创建B对象时，就可以获取暴露后的A对象
     *  3. 完成B的创建后
     *  4. A对象赋值对象B的创建
     *  5  完成A的创建
     *
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        answer();
    }

    private final static Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 解决问题
     */
    public static void answer() throws InstantiationException, IllegalAccessException {
        System.out.println(getBean(Circular1.class).getCircular2());
        System.out.println(getBean(Circular2.class).getCircular1());
    }

    /**
     * 样例1
     */
    static class Circular1{
        // 里面的属性包含其他对象
        private Circular2 circular2;

        private Circular2 getCircular2(){
            return circular2;
        }

        private void setCircular2(Circular2 circular2){
            this.circular2 = circular2;
        }
    }

    /**
     * 样例2
     */
    static class Circular2{
        private Circular1 circular1;

        public Circular1 getCircular1() {
            return circular1;
        }
        public void setCircular1(Circular1 circular1) {
            this.circular1 = circular1;
        }
    }

    /**
     * 正常的流程
     * @param beanClass
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static <T> T getBeanNormal(Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        // 1. 获取对象示例
        Object obj = beanClass.newInstance();
        // 2. 完成属相填充
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        // 遍历处理
        for (Field field : declaredFields) {
            // 获取成员变量 对应类的对象
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            field.set(obj,getBeanNormal(fieldClass));
        }
        return (T) obj;
    }

    /**
     * 提前暴露解决
     * @param beanClass
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static <T> T getBean(Class<T> beanClass) throws IllegalAccessException, InstantiationException {
        String beanName = beanClass.getSimpleName().toUpperCase();
        // 根据名称去找是否存在半成品的对象地址
        if (singletonObjects.containsKey(beanName)){
            return (T) singletonObjects.get(beanName);
        }
        Object object = beanClass.newInstance();
        // 还没有创建完就把这个对象存储在singleton里面
        singletonObjects.put(beanName,object);
        // 属性填充来补充对象
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> fieldClass = declaredField.getType();
            String filedBeanName = fieldClass.getSimpleName().toUpperCase();
            // 如果有直接获取 没有就重新调用将未创建完的对象进行暴露
            declaredField.set(object,singletonObjects.containsKey(filedBeanName)? singletonObjects.get(filedBeanName) : getBean(fieldClass));
        }
        return (T) object;
    }


}
