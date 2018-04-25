package com.zero4kevin.spring.examples.client;

import java.net.URI;

/**
 * Created by xi1zhang on 2018/4/13.
 */
public interface RestfulClient {
    public Object action();

    public Object post(URI uri, Object object);

    public Object post(String uri, Object object);
}
