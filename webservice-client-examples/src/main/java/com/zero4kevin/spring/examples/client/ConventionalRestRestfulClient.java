package com.zero4kevin.spring.examples.client;


import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by xi1zhang on 2018/4/24.
 */
public class ConventionalRestRestfulClient implements RestfulClient {
    private String url;
    private CloseableHttpClient httpClient;

    public ConventionalRestRestfulClient(String url) {
        this.url = url;
        httpClient= HttpClients.createDefault();
    }

    public Object action() {
        return null;
    }

    public Object post(URI uri, HttpEntity entity) {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(uri);
        httpPost.setEntity(entity);
        HttpResponse response=httpClient.execute(httpPost);
        return null;
    }


    public Object post(String url, Object object) {
        URI uri;
        try {
            uri=new URIBuilder(url).build();
        }catch (URISyntaxException e){
            return null;
        }
        return post(uri,object);
    }
}
