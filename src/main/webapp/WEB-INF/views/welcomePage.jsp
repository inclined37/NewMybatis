<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Welcome Page</title>
</head>
<body>
   <h1 style="font-size: 100px;">${welcomeMessage}</h1>
   <button type="button" onclick="window.location='common/main'">메인으로</button>
</body>
</html>