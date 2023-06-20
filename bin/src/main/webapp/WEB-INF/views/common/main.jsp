<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 30px 50px 30px;
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
	<br>
    <hr>
    <h1 style="text-align: center; cursor: pointer;" onclick="window.location.href = '/MybatisProject/common/main';">메인페이지</h1>
    <hr>
    <table id="employeeTable">
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
                    <td><button class="delete">X</button></td>
                    <td><button class="detail">수정</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr><br>
	<div style="text-align: center;">
	    <input type="text" id="searchInputTag" name="ename" placeholder="검색어를 입력해주세요" style="font-size: 18px; padding: 10px;">
	    <button type="button" id="searchBtn" style="font-size: 18px; padding: 10px;">검색</button>
	    <button type="button" onclick="window.location='insert'" style="font-size: 18px; padding: 10px;">사원등록</button>
	</div>

</body>
<script>
    $(document).ready(function() {
        $(document).on('click', '.delete', function() {
            var empNo = $(this).closest("tr").find("td:first").text();
            console.log("삭제버튼 클릭");
            console.log(empNo);
            $.ajax({
                url: "/MybatisProject/api/delete",
                type: "POST",
                data: {
                    empNo: empNo
                },
                success: function(response) {
                    console.log("사원 삭제 완료");
                    location.reload();
                },
                error: function(xhr, status, error) {
                    console.error("사원 삭제 실패: " + error);
                }
            });
        });

        $(document).on('click', '.detail', function() {
            var empno = $(this).closest("tr").find("td:first").text();
            console.log("수정 버튼 클릭");
            window.location.href = "/MybatisProject/common/empDetail?empno=" + empno;
        });

        $(document).ready(function() {
            $("#searchBtn").on('click', function() {
                $.ajax({
                    url: "/MybatisProject/api/search",
                    type: "GET",
                    data: {
                        ename: $('#searchInputTag').val()
                    },
                    success: function(response) {
                        console.log(response);
                        console.log("성공");
                        console.log(typeof(response));

                        // 기존의 테이블 내용 삭제
                        $("#employeeTable tbody").empty();

                        if (response.length === 0) {
                            // 검색 결과가 없는 경우
                            var noResultRow = "<tr><td colspan='10'>검색결과가 없습니다.</td></tr>";
                            $("#employeeTable tbody").append(noResultRow);
                        } else {
                            // 검색 결과가 있는 경우
                            $.each(response, function(index, emp) {
                                var empRow = "<tr>" +
                                    "<td>" + emp.empno + "</td>" +
                                    "<td>" + emp.ename + "</td>" +
                                    "<td>" + emp.job + "</td>" +
                                    "<td>" + emp.mgr + "</td>" +
                                    "<td>" + emp.hiredate + "</td>" +
                                    "<td>" + emp.sal + "</td>" +
                                    "<td>" + emp.comm + "</td>" +
                                    "<td>" + emp.deptno + "</td>" +
                                    "<td><button class='delete'>X</button></td>" +
                                    "<td><button class='detail'>수정</button></td>" +
                                    "</tr>";

                                $("#employeeTable tbody").append(empRow);
                            });
                        }
                    },
                    error: function(xhr, status, error) {
                        console.log("실패");
                        console.log(status);
                    }
                });
            });
        });
        
        /*
        // 메인 페이지 제목 클릭 이벤트
        $("h1").click(function() {
            // 페이지 이동
            window.location.href = "/MybatisProject/common/main";
        });
        */
        
    });
</script>
</html>
