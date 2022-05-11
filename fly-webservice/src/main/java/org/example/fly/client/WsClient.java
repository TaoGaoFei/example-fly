package org.example.fly.client;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.Message;
import org.example.fly.code.WsServerImpl;
import org.example.fly.code.WsServerImplService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WsClient
 * @Author moon
 * @Date 2021/6/23
 * @Version V1.0
 **/
public class WsClient {

    private static final String WSDL_URL = "http://127.0.0.1:8788/webservice?wsdl";

    private static WsServerImpl wsClient;

    /**
     * 1. 提供接口文档和地址
     * 2. 通过xml语言进行描述
     * @param args
     */
    public static void main(String[] args) {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        List<Interceptor<? extends Message>> list = new ArrayList<>();
        list.add(new org.apache.cxf.interceptor.LoggingOutInterceptor());
        // 在拦截器设置执行的方法
        factory.setInInterceptors(list);
        factory.setServiceClass(WsServerImpl.class);
        factory.setAddress(WSDL_URL);

        Object obj = factory.create();

        System.out.println(obj == null ? "NULL" : obj.getClass().getName());
        if (obj != null){
            wsClient = (WsServerImpl) obj;
        }
        String msg = wsClient.sayHello("止水");
        System.out.println(msg);

    }


    /**
     * 使用默认的方法
     */
    public void test(){
        WsServerImplService wsServer = new WsServerImplService();
        WsServerImpl wsServerImplPort = wsServer.getWsServerImplPort();
        // 返回的值
        String msg = wsServerImplPort.sayHello("带土");
        System.out.println(msg);
    }
}
