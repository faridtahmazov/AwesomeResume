package model;

import java.util.Objects;

public class Country {

    private int id;
    private String country;
    private String nationality;

    public Country() {}

    public Country(int id, String country, String nationality) {
        this.id = id;
        this.country = country;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Country other = (Country) obj;
        return Objects.equals(this.country, other.country);
    }


    @Override
    public String toString() {
        if (country==null) {
            country="";
        }else if (nationality==null){
            nationality="";
        }
        return country + " " + nationality;
    }

}
