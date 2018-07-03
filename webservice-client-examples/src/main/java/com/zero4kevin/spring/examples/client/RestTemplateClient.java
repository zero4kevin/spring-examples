package com.zero4kevin.spring.examples.client;

import com.zero4kevin.spring.examples.client.model.Person;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by xi1zhang on 2018/6/13.
 */
public class RestTemplateClient implements RestfulClient {
    public Object get(URI uri) {
        return new RestTemplate().getForObject(uri,Person.class);
    }

    public Object get(String uri) {
        try {
            return get(new URIBuilder(uri).build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int post(URI uri, Object request) {
        new RestTemplate().postForObject(uri, (Person)request, Void.TYPE);
        return 201;
    }

    public int post(String uri, Object request) {
        try {
            return post(new URIBuilder(uri).build(), request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return 9527;
    }

}
