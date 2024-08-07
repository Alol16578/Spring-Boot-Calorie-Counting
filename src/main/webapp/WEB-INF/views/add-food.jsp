<!-- src/main/webapp/WEB-INF/views/register.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Food Agregation</title>
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
        <h2>Food Aggregation</h2>
        <c:if test="${param.success != null}">
            <p>Registration successful!</p>
        </c:if>
        <form:form method="post" modelAttribute="food">
            <label for="name">Food Name:</label>
            <form:input path="name" id="name"/>
            <form:errors path="name" class="error"/>
            <br/>

            <label for="calories">Calories:</label>
            <form:input type="number" path="calories" id="calories"/>
            <form:errors path="calories" class="error"/>
            <br/>

            <input type="submit" value="Add Food"/>
        </form:form>
    </div>
</body>
</html>
