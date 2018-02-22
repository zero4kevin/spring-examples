package com.zero4kevin.spring.examples.security.mvc;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import com.zero4kevin.spring.examples.security.DTO.UserDTO;
import com.zero4kevin.spring.examples.security.MyUserService;
import com.zero4kevin.spring.examples.security.exceptions.EmailExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by kevin on 2/3/18.
 */
@Controller
public class Controllers {
    @RequestMapping("/")
    public String startPage() {
        return "home";
    }

    @RequestMapping("/member")
    public String memberPage() {
        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO accountDto,
            BindingResult result, WebRequest request, Errors errors) {
        MyUser registered = new MyUser();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("successRegister", "user", accountDto);
        }
    }



    private MyUser createUserAccount(UserDTO accountDto, BindingResult result) {
        try {
            return new MyUserService().registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
    }
}
