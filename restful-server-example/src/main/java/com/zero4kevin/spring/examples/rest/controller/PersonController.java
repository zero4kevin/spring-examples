package com.zero4kevin.spring.examples.rest.controller;

import com.zero4kevin.spring.examples.rest.model.Person;
import com.zero4kevin.spring.examples.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xi1zhang on 2018/4/18.
 */
@Controller
@RequestMapping(value="/rest")
public class PersonController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody Person getUserInformation(@PathVariable String name){
        return userService.query(name).get(0);
    }

    @RequestMapping(value ="{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable String name){
        userService.delete(name);
    }

    @RequestMapping(method =RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@PathVariable Person username){
        userService.create(username);
    }

}
