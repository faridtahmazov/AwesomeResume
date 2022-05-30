package com.company.dto;

import com.company.model.Skill;
import com.company.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private List<SkillDTO> skills;

    public UserDTO() {
    }

    public UserDTO(User user){
        this.id = user.getUserId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.password = user.getLoginUsers().getPassword();

        List<SkillDTO> skillDTOS = new ArrayList<>();

        if (user.getSkills()==null){
            List<Skill> skills = user.getSkills();
            System.out.println("Skill: " + skills);
            for (int i=0; i<skills.size(); i++){
                Skill skill = skills.get(i);
                skillDTOS.add(new SkillDTO(skill));
            }

            this.skills = skillDTOS;
        }else{
            System.out.println("user.getSkills() = null");
            System.out.println("User: " + user);
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
