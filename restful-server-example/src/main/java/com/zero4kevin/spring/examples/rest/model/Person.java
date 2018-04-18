package com.zero4kevin.spring.examples.rest.model;

import org.springframework.stereotype.Component;

/**
 * Created by xi1zhang on 2018/4/18.
 */
@Component
public class Person {
    String name;
    int age;
    String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}