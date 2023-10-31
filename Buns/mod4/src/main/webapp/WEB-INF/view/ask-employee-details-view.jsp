<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>

<body>

<div class="content">
    <h3>Dear, Employee, Please enter your details</h3>
    <br><br>

    <form:form action="showDetails" modelAttribute="employee">
        Name: <form:input path="name"/>
        <div class="error">
            <form:errors path="name"/>
        </div>
        <br>

        Surname: <form:input path="surname"/>
        <div class="error">
            <form:errors path="surname"/>
        </div>
        <br>

        Salary: <form:input path="salary"/>
        <div class="error">
            <form:errors path="salary"/>
        </div>
        <br>

        Department: <form:select path="department">
            <form:options items="${employee.departments}"/>
        </form:select>
        <br><br>

        Which car do you want?
        <form:radiobuttons path="car" items="${employee.cars}"/>
        <br><br>

        Foreign Language(s):<br>
        <ul>
            <c:forEach var="lang" items="${employee.languagesAsList}">
                <form:checkbox path="languages" value="${lang}"/>${lang}<br>
            </c:forEach>
        </ul>

        Phone Number: <form:input path="phoneNumber"/>
        <div class="error">
            <form:errors path="phoneNumber"/>
        </div>
        <br>

        Email: <form:input path="email"/>
        <div class="error">
            <form:errors path="email"/>
        </div>
        <br>

        <input type="submit" value="ok">
    </form:form>
</div>
</body>

</html>