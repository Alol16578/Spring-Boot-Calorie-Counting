<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
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
        <h1>Welcome</h1>
        <p>Welcome, ${sessionScope.loggedInUser.username}!</p>
        <div class="buttons">
            <a href="/add-food" class="btn">Add new food to registry of foods</a>
            <a href="/add-calories" class="btn">Add Food to Caloric Intake</a>
        </div>
        <div>
            <h2>Daily Caloric Intake</h2>
            <c:if test="${!todayIntakes.isEmpty()}">
                <p>Today's intake is composed of:
                    <ul>
                        <c:forEach var="intake" items="${todayIntakes}">
                            <li>${intake.food.name}: ${intake.food.calories}</li>
                        </c:forEach>
                    </ul>
                    Total Intake for today: <strong>${todayCalories}</strong>
                </p>
            </c:if>
            <c:if test="${todayIntakes.isEmpty()}">
                <p>No Calories registered today</p>
            </c:if>

        </div>
        <div>
            <a href="/add-calories">Add Food to Caloric Intake</a>
        </div>
        <div>
            <h2>History of Caloric Intakes Per Day</h2>
            <c:forEach var="intake" items="${intakes}">
                <p>
                    <span>${intake.date}</span>: 
                    <span>${intake.food.name}</span>
                    <span>${intake.food.calories}</span>
                </p>
            </c:forEach>
        </div>
    </div>
</body>
</html>
