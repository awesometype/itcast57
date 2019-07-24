<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-14
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>@RequestParams 测试</h3>
<a href="anno/requestParamsTest?name=vini">简单参数绑定</a>
<br/>

<h3>@RequestBody 测试</h3>
<form action="anno/testResponseBody" method="post">
    用户名: <input type="text" name="username" /><br/>
    金额: <input type="text" name="money" /><br/>
    <input type="submit" value="submmit"/>
</form>
<br/>

<h3>@PathVariable 测试</h3>
<a href="anno/testPathVariable/vini/mima">简单参数绑定</a>
<br/>

<h3>@RequestHeader 测试</h3>
<a href="anno/testRequestHeader">简单参数绑定</a>
<br/>

<h3>@CookieValue 测试</h3>
<a href="anno/testCookieValue">简单参数绑定</a>
<br/>

<h3>@ModelAttribute测试</h3>
<form action="anno/testModelAttribute1" method="post">
    用户名: <input type="text" name="username" /><br/>
    <input type="submit" value="submmit"/>
</form>
<br/>

<h3>@ModelAttribute测试2</h3>
<form action="anno/testModelAttribute2" method="post">
    用户名: <input type="text" name="username" /><br/>
    <input type="submit" value="submmit"/>
</form>
<br/>

</body>
</html>
