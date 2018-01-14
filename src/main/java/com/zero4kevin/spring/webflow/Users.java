package com.zero4kevin.spring.webflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 1/6/18.
 */
public class Users implements Serializable{
    private static long serialVersionUID=1L;
    private List<Person> users;

    public Users(){
        users=new ArrayList<Person>();
    }

    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }
}
