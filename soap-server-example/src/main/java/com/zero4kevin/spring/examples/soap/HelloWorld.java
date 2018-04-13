package com.zero4kevin.spring.examples.soap;

import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by xi1zhang on 2018/4/11.
 */
@Service
@SOAPBinding(style= SOAPBinding.Style.DOCUMENT)
public interface HelloWorld {
    public String sayHello();
}
