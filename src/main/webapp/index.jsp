<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="index.js"></script>
        <script src="login.js"></script>
        <script src="logout.js"></script>
        <script src="profile.js"></script>
        <script src="logout.js"></script>

         <title>PA-WebApp</title>
    </head>
    <body>
        <div id="login-content" class="content">
            <h1>Login</h1>
            <form id="login-form" onsubmit="return false;">
                <input type="text" id="customerId">
                <button id="login-button">Login</button>
            </form>
        </div>
        <div id="profile-content" class="hidden content">
            <h1>Profile</h1>
            <p>Company name: <span id="company-name"></span></p>
        </div>
        <div id="logout-content" class="hidden content">
            <button id="logout-button">Logout</button>
        </div>

    </body>
</html>