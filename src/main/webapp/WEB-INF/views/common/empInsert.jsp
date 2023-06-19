<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Employee</title>
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
        <h1>Insert Employee</h1>
        <form action="insert" method="post">
            <label for="empno">EmpNo:</label>
            <input type="text" name="empno" id="empno" placeholder="EmpNo" required>
            
            <label for="ename">EmpName:</label>
            <input type="text" name="ename" id="ename" placeholder="EmpName" required>
            
            <label for="job">Job:</label>
            <input type="text" name="job" id="job" placeholder="Job" required>
            
            <label for="mgr">Manager:</label>
            <input type="text" name="mgr" id="mgr" placeholder="Manager" required>
            
            <label for="hiredate">Hire Date:</label>
            <input type="date" name="hiredate" id="hiredate" required>
            
            <label for="sal">Salary:</label>
            <input type="text" name="sal" id="sal" placeholder="Salary" required>
            
            <label for="comm">Commission:</label>
            <input type="text" name="comm" id="comm" placeholder="Commission" required>
            
            <label for="deptno">DeptNo:</label>
            <input type="text" name="deptno" id="deptno" placeholder="DeptNo" required>
            
            <input type="submit" value="Add Employee">
        </form>
    </div>
</body>
</html>
