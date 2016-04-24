<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/4/22
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询学生</title>
</head>
<body>
  <form method="post" action="${website}student/id/${id}">
    根据id查询学生<input name="id" type="text" />
    <input type="submit" value="查询"/>
  </form>
</body>
</html>
