package com.company.dto;

import com.company.model.Skill;

public class SkillDTO {
    private Integer id;
    private String skill;

    public SkillDTO(){}

    public SkillDTO(Skill skill){
        this.id = skill.getSkillId();
        this.skill = skill.getSkill();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                '}';
    }
}
