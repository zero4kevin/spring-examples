package com.zero4kevin.spring.examples.client;

import com.zero4kevin.spring.examples.client.model.Person;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xi1zhang on 2018/4/13.
 */
public class APP {
    private static void httpClientGet(String jsonGetUrl, RestfulClient client) throws IOException {
        HttpResponse response = (HttpResponse) client.get(jsonGetUrl);
        InputStreamReader inputStreamReader = null;
        try {
            if (response != null) {
                inputStreamReader = new InputStreamReader(response.getEntity().getContent());
                int data = inputStreamReader.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = inputStreamReader.read();
                }
            } else {
                throw new HttpException("no response get");
            }
        } catch (IOException e) {
            System.err.println("Exception happens: " + e.getMessage());
        } catch (HttpException e) {
            System.err.println("Exception happens: " + e.getMessage());
        }finally {
            inputStreamReader.close();
        }
    }

    public static UrlEncodedFormEntity generateHttpFormEntity(Person person){
        List<NameValuePair> formparams=new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("name", person.getName()));
        formparams.add(new BasicNameValuePair("age", Integer.toString(person.getAge())));
        formparams.add(new BasicNameValuePair("sex",person.getSex()));
        UrlEncodedFormEntity entity=new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        System.out.println("Generated request :"+entity.toString());
        return entity;
    }

    public static void main(String[] args) throws IOException {
        String jsonGetUrl = "http://localhost:8080/rest-example/rest/test.json";
        String postUrl="http://localhost:8080/rest-example/rest";
        String getUrl = "http://localhost:8080/rest-example/rest/";
        String queryName="kevin1.json";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RestfulClient client = (RestfulClient) applicationContext.getBean("client");
//        httpClientGet(jsonGetUrl, client);
        client = (RestfulClient) applicationContext.getBean("restTemplateClient");
//        Object o=client.get(getUrl+queryName);
//        if( o instanceof Person){
//            System.out.println((Person) o);
//        }

        Person user=new Person();
        user.setName("kevin12");
        user.setSex("male");
        user.setAge(29);
        System.out.println(client.post(postUrl,user));

//        HttpEntity entity=generateHttpFormEntity(user);
//        System.out.println(client.post(postUrl, entity));
    }


}
