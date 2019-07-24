<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-19
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1>success</h1>

    <c:forEach items="${accounts}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
