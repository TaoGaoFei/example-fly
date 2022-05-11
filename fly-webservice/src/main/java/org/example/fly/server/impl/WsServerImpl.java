package org.example.fly.server.impl;

import org.example.fly.server.WsServer;

import javax.jws.WebService;
import javax.sound.midi.Soundbank;

/**
 * @ClassName WsServerImpl
 * @Author moon
 * @Date 2021/6/23
 * @Version V1.0
 **/
@WebService
public class WsServerImpl implements WsServer {

    @Override
    public String sayHello(String name) {
        System.out.println("hello " + name);
        return "Hello " + name;
    }


}
