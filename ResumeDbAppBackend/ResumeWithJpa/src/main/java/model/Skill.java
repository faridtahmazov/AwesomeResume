package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;

    @Column(name = "skill")
    private String skill;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Skill() {
    }

    public Skill(String skill) {
        this.skill = skill;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId=" + skillId +
                ", skill='" + skill + '\'' +
                '}';
    }
}
