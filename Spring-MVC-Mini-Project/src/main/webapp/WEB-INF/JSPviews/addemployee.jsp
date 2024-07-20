<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
  
<div class="container">
    <form class="form" name="frm" action="saveemp" method="post">
        <div class="form_front">
        <h3>${msg}</h3>
            <div class="form_details">Employee Details...</div>
              <input type="text" name="empname" class="einput" required placeholder="Ex.Swapnil Gujar">
              <input type="text" name="empemail" class="einput" required placeholder="Ex.gujarswapnil@gmail.com">
              <input type="text" name="empcontact" class="einput" required placeholder="Ex.7262954525" maxlength="10">
              <select class="einput" name="deptid"><!-- store thashe ename dept ni id -->
              <option class="einput">Select Dept</option>
              <c:forEach var="d" items="${dept}">
                <option value="${d.getDeptid()}">${d.getName()}</option>
              </c:forEach>
              </select>
              <input type="submit" class="ebtn" value="Add Employee">
        </div>        
    </form>
</div>
   
</body>
</html>