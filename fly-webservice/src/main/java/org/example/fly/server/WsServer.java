package org.example.fly.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @ClassName WsServer
 * @Author moon
 * @Date 2021/6/23
 * @Version V1.0
 **/
@WebService
public interface WsServer {

    @WebMethod
    String sayHello(String name);

}
