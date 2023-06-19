<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

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
</style>

</head>
<body>
	<h1>Main Page</h1>
	<button type="button" onclick="window.location='insert'">사원등록</button>
	<table>
		<thead>
			<tr>
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Manager</th>
				<th>Hire Date</th>
				<th>Salary</th>
				<th>Commission</th>
				<th>DeptNo</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.sal}</td>
					<td>${emp.comm}</td>
					<td>${emp.deptno}</td>
<%-- 					<td><input type="text" value="${emp.empno}" readOnly></td>
					<td><input type="text" value="${emp.ename}" readOnly></td>
					<td><input type="text" value="${emp.job}" readOnly></td>
					<td><input type="text" value="${emp.mgr}" readOnly></td>
					<td><input type="text" value="${emp.hiredate}" readOnly></td>
					<td><input type="text" value="${emp.sal}" readOnly></td>
					<td><input type="text" value="${emp.comm}" readOnly></td>
					<td><input type="text" value="${emp.deptno}" readOnly></td>
 --%>
					<td><button class="delete">X</button></td>
					<td><button class="detail">수정</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
<script>
	$(document).ready(function() {
		$(".delete").click(function() {
			var empNo = $(this).closest("tr").find("td:first").text();
			console.log("삭제버튼 클릭");
			console.log(empNo);
			$.ajax({
				url : "/MybatisProject/api/delete",
				type : "POST",
				data : {
					empNo : empNo
				},
				success : function(response) {
					console.log("사원 삭제 완료");
					location.reload();
				},
				error : function(xhr, status, error) {
					console.error("사원 삭제 실패: " + error);
				}
			});
		});


		$(".detail").click(function() {
			  var empno = $(this).closest("tr").find("td:first").text();
			  console.log("수정 버튼 클릭");
			  window.location.href = "/MybatisProject/common/empDetail?empno=" + empno;
		});
	});
</script>
</html>