<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/4/6
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<table border="1">
<form method="post" action="${website}/student/list">
  <tr>
    <th>序号</th>
    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>年级</th>
    <th>班级</th>
    <th>专业</th>
    <th>生日</th>
    <th>是/不是好学生</th>
    <th>操作</th>
  </tr>
  <c:forEach var="studentList" items="${list}" varStatus="status">
    <tr>
      <td>${status.index+1}</td>
      <td>${studentList.studentNum}</td>
      <td>${studentList.studentName}</td>
      <td>${studentList.sex}</td>
      <td>${studentList.grade}</td>
      <td>${studentList.classNum}</td>
      <td>${studentList.college}</td>
      <td>${studentList.birthday}</td>
      <td>${studentList.goodStudent}</td>
      <td><a href="${website}student/delete/${studentList.id}" /> delete </td>
      <td><a href="${website}student/change/${studentList.id}" />  update </td>
    </tr>
  </c:forEach>
</form>
  <td><a href="${website}student/query" />query </td>
  <a href="/student/new" > insert </a>
</table>
</body>
</html>
