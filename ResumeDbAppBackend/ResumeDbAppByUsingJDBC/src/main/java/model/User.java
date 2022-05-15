package model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDescription;
    private String address;
    private Date birthdate;
    
    private Country nationality;
    private Country country;


    public User(){
    }

    public User(int id){
        this.id = id;
    }

    public User(int id, String name, String surname, String email, String phone, 
            String profileDescription, String address, Date birthdate, Country country, Country nationality){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDescription = profileDescription;
        this.address = address;
        this.birthdate = birthdate;
        this.country = country;
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

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
  
    
    @Override
    public String toString() {
        return "\nUser Id: " + id +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nEmail: " + email +
                "\nPhone: " + phone +
                "\nBirthdate: " + birthdate;
    }
}
