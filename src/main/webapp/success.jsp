
<!--  VIEW -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="packagedto.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<!-- now we want to take user object from that business request and we have to print name from that user object along with successful message -->
<!-- see we filled the userName in form page then form page redirected us to success page, and if we can use some sort of scoping then we can capture that userName and show it here -->
<!-- now availble scopes: request, applicaton, session -->
<!-- request: can't use, coz there are two different requests, one is: login to LoginService, second is: LoginService to success page -->
<!-- application: can't use, coz we will use this application world wide and it will save the userName of that user which used it last time , and of course we don't want someone else's username printed-->
<!-- now perfect option left is session object-->
<h3>Login Successful!</h3>

<%
User user=(User) session.getAttribute("user");
%>

Hello <%= user.getUserName() %>
</body>
</html>