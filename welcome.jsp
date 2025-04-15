<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= request.getAttribute("username") %>!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>
