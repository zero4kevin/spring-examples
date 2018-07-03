package com.zero4kevin.spring.examples.client.model;

import java.io.Serializable;

/**
 * Created by xi1zhang on 2018/4/24.
 */
public class Person implements Serializable{
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

    @Override
    public String toString() {
        return "name: " + name+"\n"
                + "age: "+ age+"\n"
                +"sex: "+ sex;
    }
}
