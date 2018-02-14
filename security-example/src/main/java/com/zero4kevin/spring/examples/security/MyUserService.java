package com.zero4kevin.spring.examples.security;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import com.zero4kevin.spring.examples.security.DTO.UserDTO;
import com.zero4kevin.spring.examples.security.exceptions.EmailExistsException;
import com.zero4kevin.spring.examples.security.interfaces.IUserService;

import java.util.Arrays;

/**
 * Created by xi1zhang on 2018/2/14.
 */
public class MyUserService implements IUserService {
    @AutoWired
    MyUserDao myUserDao;

    public MyUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {

        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException("There is an account with that email address:"  + accountDto.getEmail());
        }
        MyUser user = new MyUser();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setRoles(Arrays.asList("ROLE_USER"));
        return myUserDao.save(user);
    }
    private boolean emailExist(String email) {
        MyUser user = MyUserDao.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
    }
}
