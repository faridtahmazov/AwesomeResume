package model;

import java.sql.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Date birthdate;
    private Country nationality;
    private List<UserSkill> skills;


    public User(){
    }

    public User(int id){
        this.id = id;
    }

    public User(int id, String name, String surname, String email, String phone, Date birthdate, Country nationality){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nUser Id: " + id +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nBirthdate: " + birthdate + "\n" + nationality;
    }
}
