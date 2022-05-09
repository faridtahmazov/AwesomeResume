<%--
  Created by IntelliJ IDEA.
  User: Farid
  Date: 3/8/2022
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateUser</title>
</head>
<body>
<%@ page import="model.User" %>
<%@ page import="dao.UserDao" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="daoInter.UserDaoInter" %>
<%@ page import="model.Context" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="daoInter.EmpDaoInter" %>
<%@ page import="model.EmployedHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="controller.UserDetailsController" %>
<%@ page import="daoInter.CountryDaoInter" %>
<%@ page import="model.Country" %>
<%--
  Created by IntelliJ IDEA.
  User: Farid
  Date: 3/6/2022
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link type="text/css" rel="stylesheet" href="../assets/css/userDetails.css">
    <script type="text/javascript" src="../assets/js/skillsControl.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

</head>
<body>
<form action="<%=request.getContextPath()%>/users/update" method="post">
<div class="container bootdey flex-grow-1 container-p-y">
    <div class="media align-items-center py-3 mb-3">
        <%--        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="d-block ui-w-100 rounded-circle">--%>
        <div class="media-body ml-4">
            <%
                Integer id = UserDetailsController.id;
                UserDaoInter userDaoInter = Context.getInstanceUserDao();
                User user = userDaoInter.getById(id);

                EmpDaoInter empDaoInter = Context.getInstanceEmployedHistoryDao();
                List<EmployedHistory> employedHistories = empDaoInter.getAllEmployedHistoryByUserId(user);
                EmployedHistory employedHistory = employedHistories.get(0);

            %>
            <h4 class="font-weight-bold mb-0"><%=user.getName() + " " + user.getSurname()%>
                <div class="text-muted mb-2" style="font-size: 16px;">ID: <%=user.getId()%></div>
                <table>
                        <tr>
                            <input type="submit" name="saveBtn" class="btn btn-primary" style="height: 40px; width: 80px; border-radius: 15px" value="Save">
                        </tr>
                    &nbsp;
                    <tr>
                        <button type="button" class="btn btn-dark" style="height: 40px; width: 80px; border-radius: 15px">
                            <a href="<%=request.getContextPath()%>/users/details" style="text-decoration: none; color: #fff; ">Cancel</a>
                        </button>
                    </tr>
                </table>
        </div>
    </div>
<%
    if (request.getParameter("saveBtn")!=null){%>
        <div class="alert alert-success" role="alert">
            Saved is successfully!
        </div>
    <%}%>


    <div class="card mb-4">
        <div class="card-body">
            <h6 class="mt-4 mb-3">Personal info</h6>
            <table class="table user-view-table m-0">
                <tbody>
                <tr>
                    <td>Name:</td>
                    <td>
                        <div class="form-group">
                            <input type="text" name="name" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter name" value="<%=user.getName()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Surname:</td>
                    <td>
                        <div class="form-group">
                            <input type="text"  name="surname" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter surname" value="<%=user.getSurname()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Desciption: </td>
                    <td>
                        <div class="form-group">
                            <textarea class="form-control" rows="3" name="profDesc" placeholder="Enter Profile desciption"><%=user.getProfileDescription()%>
                            </textarea>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>Birthday:</td>
                    <td>
                        <div class="form-group">
                            <input type="date"  name="birthdate" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter Birthdate" value="<%=user.getBirthdate()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Country:</td>
                    <td>
                        <div class="form-group">
                            <select class="form-select" aria-label="Default select example" name="country">
                                <option selected="selected" value="<%=user.getCountry().getId()%>"><%=user.getCountry().country%></option>
                                <%
                                    CountryDaoInter countryDaoInter = Context.getInstanceCountryDao();
                                    List<Country> countries = countryDaoInter.getAllCountry();
                                    List<Country> nationalities = countryDaoInter.getAllNationality();

                                    for (Country country: countries) {
                                        if (!user.getCountry().country.equalsIgnoreCase(country.country)){%>
                                            <option value=<%=country.getId()%>><%=country.country%></option>
                                    <%}
                                    }%>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Nationality:</td>
                    <td>
                        <div class="form-group">
                            <select class="form-select" aria-label="Default select example" name="nationality">
                                <option selected value="<%=user.getNationality().getId()%>"><%=user.getNationality()%></option>
                                <%
                                  for (Country nationality: nationalities) {
                                        if (!user.getNationality().nationality.equalsIgnoreCase(nationality.country)){%>
                                            <option value="<%=nationality.getId()%>"><%=nationality.country%></option>
                                <%}}%>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td>
                        <div class="form-group">
                            <input type="text"  name="address" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter Address" value="<%=user.getAddress()%>">
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <hr class="border-light m-0">
        <hr class="border-light m-0">


            <div class="card-body">
                <table class="table user-view-table m-0">
                    <tbody>
                    <tr>
                        <td>Header:</td>
                        <td>
                            <div class="form-group">
                                <input type="text"  name="header" class="form-control"
                                       aria-describedby="emailHelp" placeholder="Enter Header" value="<%=employedHistory.getHeader()%>">
                            </div>
                        </td>

                    <tr>
                        <td>Desciption: </td>
                        <td>
                            <div class="form-group">
                            <textarea class="form-control" rows="3" name="jobDesc" placeholder="Enter Job desciption"><%=employedHistory.getJobDescription()%>
                            </textarea>
                            </div>
                        </td>
                    </tr>
                    </tr>
                    <tr>
                        <td>Begin date:</td>
                        <td>
                            <div class="form-group">
                                <input type="date"  name="beginDate" class="form-control"
                                       aria-describedby="emailHelp" placeholder="Enter Begin Date" value="<%=employedHistory.getBeginDate()%>">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>EndDate:</td>
                        <td>
                            <div class="form-group">
                                <input type="date"  name="endDate" class="form-control"
                                       aria-describedby="emailHelp" placeholder="Enter End Date" value="<%=employedHistory.getEndDate()%>">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Role:</td>
                        <td>Owner</td>
                    </tr>
                    <tr>
                        <td>Status:</td>
                        <td>Active</td>
                    </tr>
                    </tbody>
                </table>
                <hr class="border-light m-0">

                <div class="table-responsive" id="skillSection">
                    <table class="table card-table m-0" id="skillsTable">
                        <tbody>
                        <tr>
                            <th>Skills</th>
                            <th>Power</th>
                        </tr>
                        <%  UserDao userDao = new UserDao();
                            PreparedStatement data = userDao.getSkillsByUserID(id);

                            ResultSet resultSet = data.getResultSet();
                            if (resultSet.next() == false){%>
                                <p>Unexpected Error!</p>
                        <%}else{
                            Integer point=0;
                            do{
                                String skill = resultSet.getString("skill_name");
                                Integer power = resultSet.getInt("power");
                                point++;
                        %>
                        <tr>
                            <td>
                                <input type="text" class="form-control" id="formGroupExampleInput" name="skill" value="<%=skill%>"></td>
                            </td>
                            <td>
                                <div class="container">
                                        <div class="form-group">
                                            <input type="range" class="form-range" id="formControlRange" min="0" max="10"
                                                   step="1" onInput="$('#rangeval${count}').html($(this).val())" value="<%=power%>"/>
                                        </div>
                                </div>
                            </td>
                            <td><span id="rangeval${count}" style="font: bold 18px 'arial'" name="power"><%=power%></span></td>
                            ${count+=1}
                            <%
                                }while(resultSet.next());
                            }
                            %>
                        </tr>
                        </tbody>
                    </table>

                    <table class="table card-table m-0">
                        <tr>
                            <td>
                                <input type="button" onclick="addRow()" name="addBtn" class="btn btn-outline-primary" value="Add New Skill"/>
                            </td>
                        </tr>
                    </table>

                </div>
            </div>
            <hr class="border-light m-0">
            <hr class="border-light m-0">

            <h6 class="mt-4 mb-3">&nbsp;&nbsp;&nbsp;Contacts</h6>

            <table class="table user-view-table m-0">
                <tbody>
                <tr>
                    <td>Phone:</td>
                    <td>
                        <div class="form-group">
                            <input type="phone"  name="phone" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter phone number" value="<%=user.getPhone()%>">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <div class="form-group">
                            <input type="email"  name="email" class="form-control"
                                   aria-describedby="emailHelp" placeholder="Enter Email" value="<%=user.getEmail()%>">
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</form>
</body>
</html>

</body>
</html>
