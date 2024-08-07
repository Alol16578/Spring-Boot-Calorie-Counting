<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
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
        <h1>Login</h1>
        <form action="/login" method="post">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username">
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div>
                <button type="submit">Login</button>
            </div>
            <c:if test="${not empty error}">
                <div>
                    <p class="error">${error}</p>
                </div>
            </c:if>
        </form>
    </div>
</body>
</html>