package controller;

import daoInter.EmpDaoInter;
import daoInter.SkillDaoInter;
import daoInter.UserDaoInter;
import daoInter.UserSkillDaoInter;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDetailsController", urlPatterns = {"/users/details"})
public class UserDetailsController extends HttpServlet {
    public static Integer id;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher( "../view/userDetails.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if ((id=Integer.parseInt(request.getParameter("id"))) != null){
            id = Integer.parseInt(request.getParameter("id"));
        }

        System.out.println("Selected id: " + id);
        request.getRequestDispatcher("../view/userDetails.jsp").forward(request, response);

    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
