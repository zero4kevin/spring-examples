package com.zero4kevin.spring.examples.client;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by xi1zhang on 2018/4/24.
 */
@Component
public class HttpClientApacheRestfulClient implements RestfulClient {
    private CloseableHttpClient httpClient;

    public HttpClientApacheRestfulClient() {
        httpClient= HttpClients.createDefault();
    }

    public HttpResponse get(URI uri) {
        HttpGet httpGet=new HttpGet(uri);
        HttpResponse response;
        try {
            response=httpClient.execute(httpGet);
            return response;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public HttpResponse get(String url) {
        URI uri;
        try {
            uri=new URIBuilder(url).build();
        }catch (URISyntaxException e){
            return null;
        }
        return get(uri);
    }

    public int post(URI uri, Object entity) {
        HttpPost httpPost=new HttpPost(uri);
        httpPost.setEntity((HttpEntity) entity);
        int returnCode=0;
        try {
            HttpResponse response=httpClient.execute(httpPost);
            returnCode=response.getStatusLine().getStatusCode();
//            BufferedInputStream inputStream=new BufferedInputStream(response.getEntity().getContent());
//            int i;
//            while((i=inputStream.available())!=0){
//                System.out.println((char)i);
//            }
        } catch (IOException e) {

        }
        return returnCode;
    }


    public int post(String url, Object entity) {
        URI uri;
        try {
            uri=new URIBuilder(url).build();
        }catch (URISyntaxException e){
            return 401;
        }
        return post(uri,entity);
    }
}
