
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TahmazovFarid
 */
public class DateTest {
    public static void main(String[] args) {
        String birthdateStr = "2003-07-11";
        Date birthdate = strConvertDate(birthdateStr);
        
        System.out.println(birthdate);
    }
    
    public static Date strConvertDate(String birthdateStr){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = (Date) sdf.parse(birthdateStr);
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        java.sql.Date birthdate = new java.sql.Date(date.getTime());
        
        return birthdate;
    }
}
