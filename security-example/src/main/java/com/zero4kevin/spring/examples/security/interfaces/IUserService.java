package com.zero4kevin.spring.examples.security.interfaces;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import com.zero4kevin.spring.examples.security.DTO.UserDTO;
import com.zero4kevin.spring.examples.security.exceptions.EmailExistsException;

/**
 * Created by xi1zhang on 2018/2/14.
 */
public interface IUserService {
    MyUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;
}
