package com.company.resumewebapp.controller;

import com.company.model.User;
import com.company.resumewebapp.form.SearchByUserForm;
import com.company.resumewebapp.service.DummyService;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@ModelAttribute("search") SearchByUserForm search){
        List<User> users;
        if (search.getQuery()==null || search.getQuery().trim().equals("")){
            users = userService.findUsers();
        }else{
            users = userService.findLikeUserName(search.getQuery());
        }
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(){
        return "logout";
    }

    @Autowired
    private DummyService dummyService;

    @RequestMapping(method = {RequestMethod.GET}, value="/foo") //
    public String foo(){
        System.out.println("Foo in Controller");
        dummyService.foo();

        return "users";
    }

    @ModelAttribute("search")
    public SearchByUserForm getEmptySearchByUserForm(){
        return new SearchByUserForm();
    }
}
