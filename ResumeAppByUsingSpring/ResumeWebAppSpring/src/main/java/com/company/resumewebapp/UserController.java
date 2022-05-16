package com.company.resumewebapp;

import com.company.model.User;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "id", required = false) Integer userId){

        User user = userService.findUserById(userId);
        List<User> users = new ArrayList<>();
        users.add(user);

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);

        return mv;
    }
}
