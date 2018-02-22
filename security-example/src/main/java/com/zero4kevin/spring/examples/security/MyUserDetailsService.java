package com.zero4kevin.spring.examples.security;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2/15/18.
 */
public class MyUserDetailsService implements UserDetailsService {
    private MyUserDao myUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUser myUser = myUserDao.findByEmail(email);
        if (null == myUser)
            throw new UsernameNotFoundException("No user found with username: " + email);

        boolean credentialsNotExpired = true;
        return new User(myUser.getEmail(),
                myUser.getPassword().toLowerCase(),
                true,
                true,
                true,
                true,
                getAuthorities(myUser.getRoles())
        );
    }

    private List<GrantedAuthority> getAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
