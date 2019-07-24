<%--
  Created by IntelliJ IDEA.
  User: wenbronk
  Date: 2019-07-14
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>

<body>
<div>
    <a href="hi/testReturningString">测试返回String 类型的</a>
    <br/>

    <a href="hi/testReturingStringWithModel">测试返回String类型的带参数绑定</a>
    <br/>

    <a href="hi/testReturingVoidByRequest">测试无返回值的request跳转</a>
    <br/>

    <a href="hi/testReturingStringWithModel">测试无返回值的response跳转</a>
    <br/>

    <a href="hi/testModelAndView">测试modelAndView 对象</a>
    <br/>

    <a href="hi/testKeyWordForword">测试关键字进行forword</a>
    <br/>

    <a href="hi/testKeyWordRedirect">测试关键字进行forword</a>
    <br/>

    <button id="testAjax">hello</button>

</div>
</body>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script>
    $(function() {
        $("#testAjax").click(function () {
            $.ajax({
                url: "hi/testAjax",
                contentType: "application/json;charset=UTF-8",
                data: '{' +
                    '"username": "vini", ' +
                    '"age": 30}',
                dataType: "json",
                type: "post",
                success: function (data) {
                    alert(data.username + ": " + data.age)
                }
            })
        })
    })
</script>
</html>
