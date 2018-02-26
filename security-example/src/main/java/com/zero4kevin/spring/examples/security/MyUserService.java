package com.zero4kevin.spring.examples.security;

import com.zero4kevin.spring.examples.security.DAO.MemberDao;
import com.zero4kevin.spring.examples.security.DTO.MyUser;
import com.zero4kevin.spring.examples.security.DTO.UserDTO;
import com.zero4kevin.spring.examples.security.exceptions.EmailExistsException;
import com.zero4kevin.spring.examples.security.interfaces.IUserService;
import com.zero4kevin.spring.examples.security.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by xi1zhang on 2018/2/14.
 * The class provides service to create users, remove users and so on
 */
@Component
public class MyUserService {

    private static UserDao  myUserDao;

    @Autowired
    public MyUserService(UserDao userDao){
        System.out.println("setting my dao");
        MyUserService.myUserDao=userDao;
    }

    @Transactional
     public static MyUser registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {
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
    private static boolean emailExist(String email) {
        MyUser user = myUserDao.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
