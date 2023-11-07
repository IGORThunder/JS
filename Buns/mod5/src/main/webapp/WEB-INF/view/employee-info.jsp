<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!Doctype html>
<html>
<body>

<h2>Employee Info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="employee">
  <form:hidden path="id"/>
  <form:input class="form-input"
              path="name"
              placeholder=" Name"/>
  <form:errors path="name"/>
  <br>

  <form:input class="form-input"
              path="surname"
              placeholder=" Surname"/>
  <form:errors path="surname"/>
  <br>

  <form:input class="form-input"
              path="department"
              placeholder=" Department"/>
  <form:errors path="department"/>
  <br>

  <form:input class="form-input"
              path="salary"
              placeholder=" Salary"/>
  <form:errors path="salary"/>
  <br>

  <input type="submit" value="OK">
</form:form>

</body>
</html>
