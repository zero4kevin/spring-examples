package com.zero4kevin.spring.examples.security.exceptions;

/**
 * Created by xi1zhang on 2018/2/14.
 */
public class EmailExistsException extends Exception {
    public EmailExistsException(String s){
        super(s);
    }

    public EmailExistsException(String s, Throwable cause){
        super(s, cause);
    }
}
