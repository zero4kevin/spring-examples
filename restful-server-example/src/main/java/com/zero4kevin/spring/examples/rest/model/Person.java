package com.zero4kevin.spring.examples.rest.model;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xi1zhang on 2018/4/18.
 */
@Component
@XmlRootElement(name ="person")
public class Person {
    String name;
    int age;
    String sex;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    @XmlElement
    public void setSex(String sex) {
        this.sex = sex;
    }
}
