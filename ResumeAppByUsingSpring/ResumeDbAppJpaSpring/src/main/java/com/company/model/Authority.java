package com.company.model;

import com.company.model.util.AuthUtil;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Integer authId;

    @Column(name = "auth_name")
    private String authName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "group_role", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "authority")
    private List<User> users;

    public Authority(){}

    public Authority(String authName){
        this.authName = authName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "authId=" + authId +
                ", authName='" + authName + '\'' +
                '}';
    }
}
