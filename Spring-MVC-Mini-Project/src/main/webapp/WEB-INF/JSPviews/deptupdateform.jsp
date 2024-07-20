<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
 <!-- 
 <h1>dept id:>${deptid}</h1>
 <h1>dept name:>${dname}</h1>
  -->
<div class="card">
    <span class="card__title">Department_NAME</span>
    <div class="card__form">
    <form name="frm" action="Dupdate" method="post">
        <input name="deptid" type="hidden" value="${deptid}">
        <input name="name" value="${dname}" type="text">
       <input type="submit" value="Change Here..." name="s">
       </form>
    </div>
</div>

 
</body>
</html>