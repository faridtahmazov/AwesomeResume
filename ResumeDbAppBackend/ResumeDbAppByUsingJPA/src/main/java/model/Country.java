package model;

import javax.persistence.*;

@Embeddable
public class Country {
    private String country;

    private String nationality;

    public Country() {
    }

    public Country(String country, String nationality) {
        this.country = country;
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", country='" + country + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
