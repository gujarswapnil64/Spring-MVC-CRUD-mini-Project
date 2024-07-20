<%@page import="models.deptmodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Department here</title>
 
</head>
<body>
<jsp:include page="index.jsp"/>
<div style="overflow-x:auto;">
     <table id="tablecss" align="center" border="10" >
  
    <tr align="center">
      <!-- <th scope="col">Dept ID</th> -->
      <th scope="col">Dept Name</th>
      <th scope="col">Update</th>
      <th scope="col">Delete</th>
    </tr>
  <c:forEach var="d" items="${dept}">
    <tr align="center">
     <!-- <td>${d.getDeptid()}</td> -->
     <td>${d.getName()}</td>
     <td><a href="DUForm?duid=${d.getDeptid()}&dname=${d.getName()}">Update</a></td>
     <td><a href="del?did=${d.getDeptid()}">Delete</a></td>
    </tr>
    </c:forEach>
 
</table>
</div>
</body>
</html>