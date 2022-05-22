package com.company.resumewebapp.controller;

import com.company.model.User;
import com.company.resumewebapp.form.SearchByUserForm;
import com.company.resumewebapp.service.DummyService;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ModelAndView userPage(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); //get the session username
        String username;
        User user = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (username!=null){
            user = userService.findUserByUsername(username);
        }

        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/login")
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
