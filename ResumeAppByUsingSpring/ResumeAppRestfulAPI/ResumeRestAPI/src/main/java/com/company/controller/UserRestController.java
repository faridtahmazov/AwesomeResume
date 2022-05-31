package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.model.LoginUser;
import com.company.model.User;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class UserRestController {

    @Autowired
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(){
        List<User> users = userService.findUsers();
        List<UserDTO> userDtos = new ArrayList<>();
        for (int i=0; i<users.size(); i++){
            User user = users.get(i);
            System.out.println("Skills: " + user.getSkills());
            userDtos.add(new UserDTO(user));
        }
        return ResponseEntity.ok(ResponseDTO.of(userDtos));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id){
        User user = userService.findUserById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        User user = userService.findUserById(id);
        userService.removeUser(user);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Delete is Successfully!"));
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());

//        List<SkillDTO> skillDTOS = userDTO.getSkills();
//        System.out.println("Skill DTO: " + skillDTOS);

        LoginUser loginUser = new LoginUser();
        loginUser.setPassword(userDTO.getPassword());
        user.setLoginUsers(loginUser);

        userService.saveUser(user);

        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(user.getUserId());
        userDTO1.setName(user.getName());
        userDTO1.setSurname(user.getSurname());
        userDTO1.setPassword(user.getLoginUsers().getPassword());
//        userDTO1.setSkills(skillDTOS);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Added is Successfully!"));
    }

}
