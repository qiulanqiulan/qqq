<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/4/22
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
  <body>
    <table border="1">
      <form method="post" action="${website}/student/query">
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
        <c:forEach items="${stdList}" var="std">
          <tr>
            <td>${std.studentNum}</td>
            <td>${std.studentName}</td>
            <td>${std.sex}</td>
            <td>${std.grade}</td>
            <td>${std.classNum}</td>
            <td>${std.college}</td>
            <td>${std.birthday}</td>
            <td>${std.goodStudent}</td>
          </tr>
        </c:forEach>
      </form>
    </table>
  </body>
</html>
