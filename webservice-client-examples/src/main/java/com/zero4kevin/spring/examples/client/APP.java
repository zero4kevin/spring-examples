package com.zero4kevin.spring.examples.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xi1zhang on 2018/4/13.
 */
public class APP {
    public static void main(String[] args){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("com/zero4kevin/spring/examples/client/applicationContext.xml");
        RestfulClient client=(RestfulClient) applicationContext.getBean("client");
        System.out.println(client.action());
    }
}
