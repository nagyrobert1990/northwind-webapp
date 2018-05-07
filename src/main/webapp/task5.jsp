<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<body>
<a href="index.jsp">Back to main</a><br>
<form action="task5" method="get">
    <h1>Filter: (Get the cheaper products than a given price)</h1>
    <br><input type="text" name="filter"><br>
    <input type="submit" value="Filter">
</form>
<h1>Result:</h1>
<table>
    <thead>
    <tr>
        <th>Company</th>
        <th>Product</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="model" items="${result}">
        <tr>
            <td>${model.company}</td>
            <td>${model.product}</td>
            <td>${model.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>