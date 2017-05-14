<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/13
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request对象实现请求转发</title>
</head>
<body>
    使用普通方式取出存储在request对象中的数据：
    <h3 style="color: red;"><%=request.getAttribute("message")%></h3>
    使用EL表达式取出存储在request对象中的数据：
    <h3 style="color: red;">${data}</h3>

</body>
</html>
