package org.example.dredge.code;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.14
 * 2021-07-02T17:02:06.244+08:00
 * Generated source version: 3.2.14
 *
 */
@WebService(targetNamespace = "http://webservice.review.km.kmss.landray.com/", name = "IKmReviewWebserviceService")
@XmlSeeAlso({ObjectFactory.class})
public interface IKmReviewWebserviceService {

    @WebMethod
    @RequestWrapper(localName = "addReview", targetNamespace = "http://webservice.review.km.kmss.landray.com/", className = "org.example.dredge.code.AddReview")
    @ResponseWrapper(localName = "addReviewResponse", targetNamespace = "http://webservice.review.km.kmss.landray.com/", className = "org.example.dredge.code.AddReviewResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String addReview(
        @WebParam(name = "arg0", targetNamespace = "")
        KmReviewParamterForm arg0
    ) throws Exception_Exception;
}
