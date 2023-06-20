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
            text-align: center;
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

        .form-group {
            margin-bottom: 20px;
            text-align: center;
        }

        .form-group label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
            text-align: right;
            margin-right: 20px;
        }

        .form-group input {
            width: 300px;
            padding: 5px;
            font-size: 16px;
        }

        .form-group button {
            margin-top: 10px;
            padding: 10px 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employee Detail</h1>

        <form action="/MybatisProject/common/update" method="post">
            <div class="form-group">
                <label for="empNo">EMPNO:</label>
                <input type="text" id="empNo" name="empno" value="${employee.empno}" readonly>
            </div>
            <div class="form-group">
                <label for="empName">ENAME:</label>
                <input type="text" id="empName" name="ename" value="${employee.ename}">
            </div>
            <div class="form-group">
                <label for="job">JOB:</label>
                <input type="text" id="job" name="job" value="${employee.job}">
            </div>
            <div class="form-group">
                <label for="mgr">MGR:</label>
                <input type="text" id="mgr" name="mgr" value="${employee.mgr}">
            </div>
            <div class="form-group">
                <label for="hireDate">HIREDATE:</label>
                <input type="text" id="hireDate" name="hiredate" value="${employee.hiredate}">
            </div>
            <div class="form-group">
                <label for="sal">SAL:</label>
                <input type="text" id="sal" name="sal" value="${employee.sal}">
            </div>
            <div class="form-group">
                <label for="comm">COMM:</label>
                <input type="text" id="comm" name="comm" value="${employee.comm}">
            </div>
            <div class="form-group">
                <label for="deptNo">DEPTNO:</label>
                <input type="text" id="deptNo" name="deptno" value="${employee.deptno}">
            </div>

            <div class="form-group">
                <button type="submit">Update</button>
                <button type="button" onclick="location.href='/MybatisProject/common/main'">Back to Main</button>
            </div>
            
            <div class="form-group">
            	<button type="button" onclick="window.location='pdfview?empno=${employee.empno}'">PDF 파일로 보기</button>

            	<button type="button" onclick="window.location='empToExcel?empno=${employee.empno}'">Excel 파일로 보기</button>

            </div>
        </form>
    </div>
</body>
</html>