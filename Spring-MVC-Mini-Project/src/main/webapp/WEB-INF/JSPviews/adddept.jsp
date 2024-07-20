<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department here</title>
</head>
<body>
<jsp:include page="index.jsp"/>

<form name="frm" action="deptsave" method="post">
    <div id="adddeptUL">
       <input placeholder="DeptName" class="input" name="name" required type="text">
       <input type="submit" value="Submit" name="s" class="button" /><br>
       
         <h4 style='margin-left:20px;'>${msg}</h4> 
    </div>
</form>
</body>
</html>