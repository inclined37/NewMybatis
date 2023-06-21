<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Welcome Page</title>
   <style>
       /* CSS 스타일 추가 */
       body {
           font-family: Arial, sans-serif;
           text-align: center;
           background-color: #f5f5f5;
       }
       button {
           margin: 10px;
           padding: 15px 30px;
           font-size: 20px;
           cursor: pointer;
           border: none;
           border-radius: 5px;
           transition: background-color 0.3s;
           background-color: gray;
       }
       button:hover {
           background-color: #dedede;
       }
       .language-buttons {
           margin-bottom: 50px;
       }
       h1 {
           font-size: 80px;
           color: #333333;
       }
   </style>
</head>
<body>
   <div class="language-buttons">
      <button type="button" onclick="window.location='?lang=ko'">한국어</button>
      <button type="button" onclick="window.location='?lang=en'">English</button>
   </div>

   <h1>${welcomeMessage}</h1>
   <button type="button" onclick="window.location='common/main'">메인으로</button>
</body>
</html>
