package com.zero4kevin.spring.webflow;

import java.io.Serializable;

/**
 * Created by kevin on 1/5/18.
 */
public class Person implements Serializable{
    private String familyName;
    private String givenName;
    private String details;

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
