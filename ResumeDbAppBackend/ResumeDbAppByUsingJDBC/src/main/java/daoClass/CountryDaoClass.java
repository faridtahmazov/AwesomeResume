package daoClass;

import connection.ConnectToMysql;
import daoInter.CountryDaoInter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Country;

public class CountryDaoClass extends ConnectToMysql implements CountryDaoInter{

    @Override
    public List<Country> getAllCountry() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select country.id, country.country from country;");
            
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                String countryStr = rs.getString("country");
                Country country = new Country(id, countryStr, null);
                result.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public List<Country> getAllNationality(){
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select country.id, country.nationality from country;");
            
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                int id = rs.getInt("id");
                String nationalityStr = rs.getString("nationality");
                Country nationality = new Country(id, nationalityStr, null);      
                result.add(nationality);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



}
