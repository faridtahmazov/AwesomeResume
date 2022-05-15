package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "profile_desc")
    private String profileDesc;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthdate = new Date();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_skill", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "skillId"))
    private List<Skill> skills = new ArrayList<>();

    @CollectionTable(name = "country", joinColumns = @JoinColumn(name = "userId"))
    @Embedded
    private Country country;

    @OneToMany(mappedBy = "user")
    private List<EmployedHistory> employedHistories;

    public User(String name, String surname, String email, String phone, List<Skill> skills, List<EmployedHistory> employedHistories) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.employedHistories = employedHistories;
    }

    public User() {}

    public User(String name, String surname, String email, String phone, String profileDesc, String address, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.profileDesc = profileDesc;
        this.address = address;
        this.birthdate = birthdate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<EmployedHistory> getEmployedHistories() {
        return employedHistories;
    }

    public void setEmployedHistories(List<EmployedHistory> employedHistories) {
        this.employedHistories = employedHistories;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
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

//    public Country getCountry() {
//        return country;
//    }

//    public void setCountry(Country country) {
//        this.country = country;
//    }

//    public Country getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(Country nationality) {
//        this.nationality = nationality;
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
//                ", country=" + country +
//                ", nationality=" + nationality +
                '}';
    }
}
