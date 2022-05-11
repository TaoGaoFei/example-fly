package org.example.fly;

import org.example.fly.server.impl.WsServerImpl;

import javax.xml.ws.Endpoint;

/**
 * @ClassName WsPublish
 * @Description: TODO
 * @Author moon
 * @Date 2021/6/23
 * @Version V1.0
 **/
public class WsPublish {

    public static void main(String[] args) {

        // 定义webservice的发布地址
        String address = "http://127.0.0.1:8788/webservice";
        Endpoint.publish(address,new WsServerImpl());
        System.out.println("发布webService成功");

    }

}
