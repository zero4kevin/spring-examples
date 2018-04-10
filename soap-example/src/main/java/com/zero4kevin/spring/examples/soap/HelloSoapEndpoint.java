package com.zero4kevin.spring.examples.soap;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by kevin on 4/7/18.
 */
@WebService(serviceName = "helloservice")
public class HelloSoapEndpoint extends SpringBeanAutowiringSupport {

    @WebMethod
    public String sayHello(){
        return "hello!";
    }

}
