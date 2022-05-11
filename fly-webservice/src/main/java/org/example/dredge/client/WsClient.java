package org.example.dredge.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.example.dredge.code.IKmReviewWebserviceService;
import org.example.dredge.code.IKmReviewWebserviceServiceService;
import org.example.dredge.code.KmReviewParamterForm;

/**
 * @ClassName WsClient
 * @Author moon
 * @Date 2021/7/2
 * @Version V1.0
 **/
public class WsClient {


    private static final String WSDL_URL = "http://oa.newhopegroup.com:8090/sys/webservice/kmReviewWebserviceService?wsdl";

    private static IKmReviewWebserviceService wsClient;

    public static void main(String[] args) {

        try {
            // 1. 创建WebService客户端代理工厂
            JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
            // 2. 判断是否抛出异常
            factoryBean.getOutInterceptors().add(new LoggingInInterceptor());
            // 3. 注册WebService接口
            factoryBean.setServiceClass(IKmReviewWebserviceServiceService.class);
            // 4. 配置WebService地址
            factoryBean.setAddress(WSDL_URL);
            Object o = factoryBean.create();
            if (o != null){
                // 获取接口对象
                wsClient = (IKmReviewWebserviceService) o ;
                KmReviewParamterForm form = new KmReviewParamterForm();
                // 传入的信息


                String s = wsClient.addReview(form);
                System.out.println(s);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
