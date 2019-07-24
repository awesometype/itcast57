<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-16
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<h3>传统文件上传</h3>
<form action="upload/commonsUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>springmvc文件上传</h3>
<form action="upload/springmvcFileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="uploadFile" /><br/>
    <input type="submit" value="上传" />
</form>

<h3>springmvc跨服务器文件上传</h3>
<form action="upload/springmvcFileuploadThrowServer" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="uploadFileThrowServer" /><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>
