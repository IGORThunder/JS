<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<body>

<div class="content">
    <h2>Dear, Employee, you are WELCOME!!!</h2>
    <br><br>

    Your name: ${employee.name}
    <br>
    Your surname: ${employee.surname}
    <br>
    Your salary: ${employee.salary}
    <br>
    Your department: ${employee.department}
    <br>
    Your car: ${employee.car}
    <br>
    Languages:
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
    Phone number: ${employee.phoneNumber}
    <br>
    Email: ${employee.email}
</div>
</body>

</html>