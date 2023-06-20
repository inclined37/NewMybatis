<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원추가</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

h1 {
    color: #333;
    text-align: center;
}

form {
    margin-top: 20px;
}

label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="text"],
input[type="date"],
input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: #fff;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
</style>
</head>
<body>
    <div class="container">
        <h1>사원추가</h1>
        <form action="insert" method="post">
            <label for="empno">사원번호 :</label>
            <input type="text" name="empno" id="empno" placeholder="사원번호" required>
            
            <label for="ename">사원이름 :</label>
            <input type="text" name="ename" id="ename" placeholder="사원이름" required>
            
            <label for="job">직업 :</label>
            <input type="text" name="job" id="job" placeholder="직책" required>
            
            <label for="mgr">상사번호 :</label>
            <input type="text" name="mgr" id="mgr" placeholder="상사번호" required>
            
            <label for="hiredate">입사일 :</label>
            <input type="date" name="hiredate" id="입사일" required>
            
            <label for="sal">연봉 :</label>
            <input type="text" name="sal" id="sal" placeholder="연봉" required>
            
            <label for="comm">보너스 :</label>
            <input type="text" name="comm" id="comm" placeholder="보너스" required>
            
            <label for="deptno">부서번호 :</label>
            <input type="text" name="deptno" id="deptno" placeholder="부서번호" required>
            
            <input type="submit" value="사원 추가">
        </form>
    </div>
</body>
</html>
