package controller;

import daoInter.CountryDaoInter;
import daoInter.EmpDaoInter;
import daoInter.UserDaoInter;
import daoInter.UserSkillDaoInter;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "UserUpdateController", urlPatterns = {"/users/update"})
public class UserUpdateController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../view/updateUser.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost started!");

        System.out.println("-----------------");
        System.out.println("UpdateUser: " + updateUser(request, response));
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("UpdateEmp: " + updateEmp(request, response));
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("UpdateSkill: " + updateSkills(request, response));
        System.out.println("-----------------");

        response.sendRedirect(request.getContextPath() + "/users/update");
    }
//    @Override
//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//        doPost(request, response);
//    }

    private boolean updateUser(HttpServletRequest request, HttpServletResponse response){
        Integer id = UserDetailsController.id;
        System.out.println("Id: " + id);

        String name = request.getParameter("name");
        System.out.println("Name: " + name);

        String surname = request.getParameter("surname");
        System.out.println("Surname: " + surname);

        String email = request.getParameter("email");
        System.out.println("Email: " + email);

        String phone = request.getParameter("phone");
        System.out.println("Phone: " + phone);

        String profDesc = request.getParameter("profDesc");
        System.out.print("Desc: " + profDesc);

        String address = request.getParameter("address");
        System.out.println("address: " + address);

        String birthdateStr = request.getParameter("birthdate");
        System.out.println("Birthdate(Str): " + birthdateStr);

        java.sql.Date birthdate = strConvertDate(birthdateStr);
        System.out.println("Birthdate: " + birthdate);

        Integer nationalityId = Integer.parseInt(request.getParameter("nationality"));
        System.out.println("NationalityId: " + nationalityId);

        Integer countryId = Integer.parseInt(request.getParameter("country"));
        System.out.println("CountryId: " + countryId);

        CountryDaoInter countryDaoInter = Context.getInstanceCountryDao();
        Country nationality = countryDaoInter.getAllNationality().get(nationalityId-1);
        System.out.println("Nationality: " + nationality);

        Country country = countryDaoInter.getAllCountry().get(countryId-1);
        System.out.println("Country: " + country);

        User user = Context.getInstanceUserDao().getById(id);

        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setProfileDescription(profDesc);
        user.setAddress(address);
        user.setBirthdate(birthdate);
        user.setNationality(nationality);
        user.setCountry(country);

        UserDaoInter userDaoInter = Context.getInstanceUserDao();
        return userDaoInter.update(user);
    }

    private boolean updateSkills(HttpServletRequest request, HttpServletResponse response){
        Integer id = UserDetailsController.id;
        String skillName = request.getParameter("skill");
        System.out.println("Skill name: " + skillName);

        Integer power = Integer.parseInt(request.getParameter("power"));
        System.out.println("Power: " + power);

        User user = Context.getInstanceUserDao().getById(id);

        Skill skill = new Skill(null, skillName);
        System.out.println("Skill: " + skill);

        UserSkill userSkill = new UserSkill(null, user, skill, power);
        System.out.println("User Skill: " + userSkill);

        UserSkillDaoInter userSkillDaoInter = Context.getInstanceUserSkillDao();

        return userSkillDaoInter.addUserSkill(userSkill);
    }

    private boolean updateEmp(HttpServletRequest request, HttpServletResponse response){
        Integer id = UserDetailsController.id;
        String header = request.getParameter("header");
        System.out.println("Header: " + header);

        String jobDesc = request.getParameter("jobDesc");
        System.out.println("Job Desc: " + jobDesc);

        String beginDateStr = request.getParameter("beginDate");
        System.out.println("Begin Date Str: " + beginDateStr);
        java.sql.Date beginDate = strConvertDate(beginDateStr);
        System.out.println("Begin Date: " + beginDate);

        String endDateStr  = request.getParameter("endDate");
        System.out.println("End Date Str: " + endDateStr);

        java.sql.Date endDate = strConvertDate(beginDateStr);
        System.out.println("End Date: " + endDate);

        User user = Context.getInstanceUserDao().getById(id);

        EmployedHistory employedHistory = Context.getInstanceEmployedHistoryDao().getAllEmployedHistoryByUserId(user).get(0);

        employedHistory.setHeader(header);
        employedHistory.setJobDescription(jobDesc);
        employedHistory.setBeginDate(beginDate);
        employedHistory.setEndDate(endDate);

        EmpDaoInter empDaoInter = Context.getInstanceEmployedHistoryDao();

        return empDaoInter.updateEmployedHistory(employedHistory);
    }

    private Date strConvertDate(String birthdateStr){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date date = null;
        try {
            date = sdf.parse(birthdateStr);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        java.sql.Date birthdate = new java.sql.Date(date.getTime());

        return birthdate;
    }

}
