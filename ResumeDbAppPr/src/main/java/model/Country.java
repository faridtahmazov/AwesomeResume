package model;

public class Country {
    private int id;
    private String country;
    private String nationality;


    public Country(){

    }

    public Country(int id, String country, String nationality){
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
    public String toString() {
        return "\nCountry: " + country +
                "\nNationality: " + nationality;
    }
}
