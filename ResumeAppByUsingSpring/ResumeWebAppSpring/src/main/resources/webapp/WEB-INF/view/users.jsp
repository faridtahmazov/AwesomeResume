<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="daoInter.UserDaoInter" %>
<%@ page import="model.Context" %>
<%@ page import="model.User" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="connection.ConnectToMysql" %>
<%@ page import="dao.UserDao" %>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
        <link rel="stylesheet" href="assets/css/icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    </head>

    <body>
    <form action="users" method="post">
        <div class="input-group rounded">
                <input name="search" style="margin: 20px 10px 10px 20px;" type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <span class="input-group-text border-0" id="search-addon">
                    <i class="fas fa-search"></i>
                </span>
        </div>
    </form>
        <hr>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Upd/Del</th>
                </tr>
                </thead>

                <%  UserDao userDao = new UserDao();
                    PreparedStatement data = null;
                    String query = request.getParameter("search");
                    if (query==null || query.trim().equals("")){
                        data = userDao.printAll();
                    }else{
                        data = userDao.searchBy(query);
                    }

                    ResultSet resultSet = data.getResultSet();
                    if (resultSet.next() == false){%>
                        <tbody>
                        <tr>
                            <th scope="row" name="id">null</th>
                            <td>null</td>
                            <td>null</td>
                            <td>null</td>
                            <td>
                                <a><img src="images/view.png" width="28" height="28"></a>
                                <a><img src="images/trash.png" width="28" height="28"></a>
                            </td>
                        </tr>
                    <%}else{
                        do{%>
                            <tbody>
                            <tr>
                                <form action="users/details" method="post">
                                    <%Integer id = resultSet.getInt("id");%>
                                    <input type="hidden" name="id" value="<%=id%>"/>
                                    <th scope="row"><%=id%></th>
                                    <td><%=resultSet.getString("name")%></td>
                                    <td><%=resultSet.getString("surname")%></td>
                                    <td><%=resultSet.getString("email")%></td>
                                    <td>
                                        <button class="icon"><a><img src="img/view.png" width="28" height="28"></a></button>
                                        <button class="icon"><a><img src="img/trash.png" width="28" height="28"></a></button>
                                    </td>
                                </form>

                            </tr>
                        <%}while(resultSet.next());
                    }
                %>
                </tbody>
            </table>
    </body>
</html>