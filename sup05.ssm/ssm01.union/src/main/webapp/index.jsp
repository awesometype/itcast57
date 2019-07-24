<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-19
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>index</h1>
<a href="account/findAll" >查找所有</a>

<form action="account/insert" method="post">
    <input name="name" type="text"/>
    <input name="money" type="text"/>
    <input name="submit" type="submit">
</form>

</body>
</html>
