
package org.example.fly.code;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WsServerImplService", targetNamespace = "http://impl.server.fly.example.org/", wsdlLocation = "http://127.0.0.1:8788/webservice?wsdl")
public class WsServerImplService
    extends Service
{

    private final static URL WSSERVERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSSERVERIMPLSERVICE_EXCEPTION;
    private final static QName WSSERVERIMPLSERVICE_QNAME = new QName("http://impl.server.fly.example.org/", "WsServerImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8788/webservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSSERVERIMPLSERVICE_WSDL_LOCATION = url;
        WSSERVERIMPLSERVICE_EXCEPTION = e;
    }

    public WsServerImplService() {
        super(__getWsdlLocation(), WSSERVERIMPLSERVICE_QNAME);
    }

    public WsServerImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSSERVERIMPLSERVICE_QNAME, features);
    }

    public WsServerImplService(URL wsdlLocation) {
        super(wsdlLocation, WSSERVERIMPLSERVICE_QNAME);
    }

    public WsServerImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSSERVERIMPLSERVICE_QNAME, features);
    }

    public WsServerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsServerImpl
     */
    @WebEndpoint(name = "WsServerImplPort")
    public WsServerImpl getWsServerImplPort() {
        return super.getPort(new QName("http://impl.server.fly.example.org/", "WsServerImplPort"), WsServerImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsServerImpl
     */
    @WebEndpoint(name = "WsServerImplPort")
    public WsServerImpl getWsServerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.server.fly.example.org/", "WsServerImplPort"), WsServerImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSSERVERIMPLSERVICE_EXCEPTION!= null) {
            throw WSSERVERIMPLSERVICE_EXCEPTION;
        }
        return WSSERVERIMPLSERVICE_WSDL_LOCATION;
    }

}
