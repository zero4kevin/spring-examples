package com.zero4kevin.spring.examples.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import java.net.URI;

/**
 * Created by xi1zhang on 2018/4/13.
 */
public interface RestfulClient {
    public Object get(URI uri);

    public Object get(String uri);

    public int post(URI uri, Object request);

    public int post(String uri, Object request);
}
