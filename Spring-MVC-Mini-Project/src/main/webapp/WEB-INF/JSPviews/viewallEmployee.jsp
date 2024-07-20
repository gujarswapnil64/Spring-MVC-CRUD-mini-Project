<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<div style="overflow-x:auto;">
     <table id="tablecss" align="center" border="10" >
  
    <tr align="center">
      <!--<th scope="col">Emp. ID</th>  -->
      <th scope="col">Emp. Name</th>
      <th scope="col">Emp. Email</th>
      <th scope="col">Emp. Contact</th>
      <th scope="col">Emp Department</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  <c:forEach var="e" items="${emplist}">
<!--  e.name,e.email,e.contact,d.name,e.eid ,dept id  -->
   <tr align="center">
   <!-- <td>${e[4]}</td> -->
     <td>${e[0]}</td>
     <td>${e[1]}</td>
     <td>${e[2]}</td>
      <td>${e[3]}</td>
      <td><a href="empupdateform?empid=${e[4]}&empname=${e[0]}&empemail=${e[1]}&empcontact=${e[2]}&deptid=${e[5]}&name=${e[3]}">Update</a></td>
     <td><a href="empdel?empid=${e[4]}">Delete</a></td>
    </tr>
 
   
    </c:forEach>
 
</table>
</div>
</body>
</html>