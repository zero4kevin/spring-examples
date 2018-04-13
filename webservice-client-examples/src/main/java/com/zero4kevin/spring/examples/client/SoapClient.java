package com.zero4kevin.spring.examples.client;

import com.zero4kevin.spring.examples.soap.HelloWorld;
import org.springframework.stereotype.Component;

/**
 * Created by xi1zhang on 2018/4/13.
 */
@Component
public class SoapClient implements Client {
    private HelloWorld  helloService;

    public void setHelloService(HelloWorld helloService) {
        this.helloService = helloService;
    }

    public String action() {
        return helloService.sayHello();
    }

}
