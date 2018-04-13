package com.zero4kevin.spring.examples.soap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by xi1zhang on 2018/4/11.
 */

@Component("helloWorld")
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello() {
        return "Hello";
    }
}
