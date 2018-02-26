package com.zero4kevin.spring.examples.security.interfaces;

import com.zero4kevin.spring.examples.security.DTO.MyUser;

/**
 * Created by xi1zhang on 2018/2/27.
 */
public interface UserDao {
    public MyUser save(MyUser myUser);
    public MyUser findByEmail(String email);
}
