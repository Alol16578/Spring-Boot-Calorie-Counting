<!-- src/main/webapp/WEB-INF/views/register.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <header class="navbar">
        <div class="navbar-left">
            <a href="/home">Home</a>
            <a href="/login">Login</a>
            <a href="/register">Register</a>
        </div>
        <div class="navbar-right">
            <a href="/logout">Logout</a>
        </div>
    </header>
    <div class="container">
        <h2>User Registration</h2>
        <c:if test="${param.success != null}">
            <p>Registration successful!</p>
        </c:if>
        <form:form method="post" modelAttribute="user">
            <label for="username">Username:</label>
            <form:input path="username" id="username"/>
            <form:errors path="username" class="error"/>
            <br/>

            <label for="password">Password:</label>
            <form:password path="password" id="password"/>
            <form:errors path="password" class="error"/>
            <br/>

            <label for="email">Email:</label>
            <form:input path="email" id="email"/>
            <form:errors path="email" class="error"/>
            <br/>

            <input type="submit" value="Register"/>
        </form:form>
    </div>
</body>
</html>
