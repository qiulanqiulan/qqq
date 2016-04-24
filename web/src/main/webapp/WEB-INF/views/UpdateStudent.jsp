<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/4/11
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<form action="${website}student/update/${id}" method="post">
  学号<input name="studentNum" type="text"  /><br>
  姓名<input name="studentName" type="text"/><br>
  性别<input name="sex" type="text"/><br>
  年级<input name="grade" type="text"/><br>
  班级<input name="classNum" type="text"/><br>
  college<input name="college" type="text"/><br>
  生日<input name="birthday" type="text"/><br>
  是/不是好学生学号<input name="goodStudent" type="text"/><br>
  <input type="submit" value="修改"/><br>
</form>
</body>
</html>
