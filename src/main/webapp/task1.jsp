<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Northwind WebApp</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="index.jsp">Back to main</a><br>
<form action="task1" method="get">
    <h1>Filter: (Get products by supplier name)</h1>
    <br><input type="text" name="filter"><br>
    <input type="submit" value="Filter">
</form>
<h1>Result:</h1>
<table>
    <thead>
    <tr>
        <th>Product</th>
        <th>Company</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="model" items="${result}">
        <tr>
            <td>${model.company}</td>
            <td>${model.product}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>