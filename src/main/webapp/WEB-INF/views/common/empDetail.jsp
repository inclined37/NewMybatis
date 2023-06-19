<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Detail</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

h1 {
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ccc;
    text-align: center;
}

th {
    background-color: #f2f2f2;
}
thead th {
    background-color: #f2f2f2;
    border-bottom: 2px solid #ccc;
    padding: 10px;
    font-weight: bold;
}

form {
    margin-top: 20px;
}

.form-group {
    margin-bottom: 10px;
}

.form-group label {
    display: block;
    font-weight: bold;
}

.form-group input[type="text"],
.form-group input[type="date"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.form-group button {
    padding: 8px 20px;
    background-color: #4CAF50;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

.form-group button:hover {
    background-color: #45a049;
}

</style>
</head>
<body>
    <div class="container">
        <h1>Employee Detail</h1>
        
        <table>
            <tr>
                <th>EmpNo</th>
                <th>EmpName</th>
                <th>Job</th>
                <th>Manager</th>
                <th>Hire Date</th>
                <th>Salary</th>
                <th>Commission</th>
                <th>DeptNo</th>
            </tr>
            <tr>
                <td>${employee.empNo}</td>
                <td>${employee.empName}</td>
                <td>${employee.job}</td>
                <td>${employee.manager}</td>
                <td>${employee.hireDate}</td>
                <td>${employee.salary}</td>
                <td>${employee.commission}</td>
                <td>${employee.deptNo}</td>
            </tr>
        </table>
        
        <form action="/common/update" method="post">
            <input type="hidden" name="empNo" value="${employee.empNo}">
            <div class="form-group">
                <label for="empName">Employee Name:</label>
                <input type="text" id="empName" name="empName" value="${employee.empName}" required>
            </div>
            <div class="form-group">
                <label for="job">Job:</label>
                <input type="text" id="job" name="job" value="${employee.job}" required>
            </div>
            <div class="form-group">
                <label for="manager">Manager:</label>
                <input type="text" id="manager" name="manager" value="${employee.manager}">
            </div>
            <div class="form-group">
                <label for="hireDate">Hire Date:</label>
                <input type="date" id="hireDate" name="hireDate" value="${employee.hireDate}" required>
            </div>
            <div class="form-group">
                <label for="salary">Salary:</label>
                <input type="text" id="salary" name="salary" value="${employee.salary}" required>
            </div>
            <div class="form-group">
                <label for="commission">Commission:</label>
                <input type="text" id="commission" name="commission" value="${employee.commission}">
            </div>
            <div class="form-group">
                <label for="deptNo">DeptNo:</label>
                <input type="text" id="deptNo" name="deptNo" value="${employee.deptNo}" required>
            </div>
            <div class="form-group">
                <button type="submit">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
