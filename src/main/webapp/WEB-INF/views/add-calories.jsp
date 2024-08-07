<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Calories</title>
    <link rel="stylesheet" href="/css/style.css">
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
        <h1>Add Calories</h1>
        <form action="/add-calories" method="post">
            <div>
                <label for="foodId">Select Food:</form:label>
                <select name="foodId">
                    <option value="" label="Select..."/>
                    <c:forEach var="food" items="${foods}">
                        <option value="${food.id}" label="${food.name}"/>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit">Add</button>
            </div>
        </form>
    </div>
</body>
</html>