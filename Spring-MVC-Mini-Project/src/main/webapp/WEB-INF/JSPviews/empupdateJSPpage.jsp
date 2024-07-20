<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Updated here..</title>
</head>
<body>
   <jsp:include page="index.jsp"></jsp:include>
<div class="container">
    <form class="form" name="frm" action="empudetails" method="post">
        <div class="form_front">
            <div class="form_details">Update Details...</div>
              <input type="hidden" name="empid" value="${empid}" class="einput" required >
              <input type="text" name="empname" value="${empname}" class="einput" required >
              <input type="text" name="empemail" value="${empemail}" class="einput" required >
              <input type="text" name="empcontact" value="${empcontact}" class="einput" required maxlength="10">
              <select class="einput"  name="deptid"><!-- store thashe ename dept ni id -->
              <option class="einput">${deptname}</option>
              <c:forEach var="d" items="${dept}">
                <option value="${d.getDeptid()}">${d.getName()}</option>
              </c:forEach>
              </select>
              <input type="submit" class="ebtn" value="Update Employee">
        </div>        
    </form>
</div>
   
</body>
</html>