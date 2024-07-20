<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/JS/searchingemp.js" />"  type="text/javascript"> </script>
</head>
<body>
<jsp:include page="index.jsp"/>
<input placeholder="Searching..." onkeyup="searchemp(this.value)" class="input" name="name" required type="text">
   <div id="searchdata" id="tablecss">
   <div style="overflow-x:auto;">
     <table id="tablecss" align="center" border="10" >
  
    <tr align="center">
    <!--   <th scope="col">Emp. ID</th> -->
      <th scope="col">Emp. Name</th>
      <th scope="col">Emp. Email</th>
      <th scope="col">Emp. Contact</th>
      <th scope="col">Emp Department</th>
     
    </tr>
  <c:forEach var="e" items="${emplist}">
<!--  e.name,e.email,e.contact,d.name,e.eid ,dept id  -->
    <tr align="center">
   
     <td>${e[0]}</td>
     <td>${e[1]}</td>
     <td>${e[2]}</td>
      <td>${e[3]}</td>

   
    </tr>
    </c:forEach>
 
</table>
</div>
</div>
</body>
</html>