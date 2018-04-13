package com.zero4kevin.spring.examples.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by kevin on 4/7/18.
 */
@WebService(serviceName = "helloService")
public class HelloSoapEndpoint {

    @Autowired
    private HelloWorld helloWorld;

    public HelloSoapEndpoint(){
        helloWorld=new HelloWorldImpl();
    }

    @WebMethod
    public String sayHello(){
        return helloWorld.sayHello();
    }

}
