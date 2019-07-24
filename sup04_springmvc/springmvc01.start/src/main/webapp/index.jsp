<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-13
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<h3>r入门程序</h3>
<a href="hello/sayHello">入门程序</a>
<br/>

<h3>简单参数绑定</h3>
<a href="param/simpleParam?name=vini&age=18">简单参数绑定</a>
<br/>

<h3>javaBean参数绑定</h3>
<form action="param/beanParam" method="post">
    用户名: <input type="text" name="username" /><br/>
    金额: <input type="text" name="money" /><br/>
    用户名: <input type="text" name="user.name" /><br/>
    性别: <input type="text" name="user.sex" /><br/>
    年龄: <input type="text" name="user.age" /><br/>

    <input type="submit" value="submmit"/>
</form>
<br/>

<h3>集合参数绑定</h3>
<form action="param/beanParam" method="post">
    用户名: <input type="text" name="username" /><br/>
    金额: <input type="text" name="money" /><br/>
    <br/>

    用户名: <input type="text" name="user.name" /><br/>
    性别: <input type="text" name="user.sex" /><br/>
    年龄: <input type="text" name="user.age" /><br/>
    <br/>

    用户名: <input type="text" name="users[0].name" /><br/>
    性别: <input type="text" name="users[0].sex" /><br/>
    年龄: <input type="text" name="users[0].age" /><br/>
    <br/>

    用户名: <input type="text" name="userMap['hello'].name" /><br/>
    性别: <input type="text" name="userMap['hello'].sex" /><br/>
    年龄: <input type="text" name="userMap['hello'].age" /><br/>

    <input type="submit" value="submmit"/>
</form>
<br/>

<h3>自定义类型转换器</h3>
<form action="param/beanParam" method="post">
    用户名: <input type="text" name="username" /><br/>
    金额: <input type="text" name="money" /><br/>
    创建日期: <input type="text" name="createTime" /><br/>

    <input type="submit" value="submmit"/>
</form>
<br/>

</body>
</html>
