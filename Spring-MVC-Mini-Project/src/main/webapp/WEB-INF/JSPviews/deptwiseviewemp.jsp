<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/JS/deptwisesearchemp.js" />"  type="text/javascript"> </script>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<div style="overflow-x:auto;">
     <select style="margin-left:450px" class="einput" onchange="deptwise(this.value)"  name="deptid">
     <option class="einput">Select Department</option>
     <c:forEach var="e" items="${dept}">
       <option class="einput" value="${e.getDeptid()}">${e.getName()}</option>
     </c:forEach>
     </select>
     <div id="deptemp">
     </div>
 </div>
</body>
</html>