
package org.example.fly.code;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WsServerImpl", targetNamespace = "http://impl.server.fly.example.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsServerImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://impl.server.fly.example.org/", className = "org.example.fly.code.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://impl.server.fly.example.org/", className = "org.example.fly.code.SayHelloResponse")
    @Action(input = "http://impl.server.fly.example.org/WsServerImpl/sayHelloRequest", output = "http://impl.server.fly.example.org/WsServerImpl/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
