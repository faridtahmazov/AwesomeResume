<%--
  Created by IntelliJ IDEA.
  User: Farid
  Date: 5/19/2022
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="login_background">

<form action="logout" method="POST">
    <div class="col-4 container login_fix_">

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

        <button type="submit" class="btn btn-primary">Logout</button>
    </div>
</form>

</body>
</html>
