<%--
  Created by IntelliJ IDEA.
  User: ws
  Date: 2017/5/13
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" language="java" import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>在Form中使用验证码</title>
    <script type="text/javascript">
        /*刷新验证码
         * 在末尾加Math.random()的作用：
         如果两次请求地址一样，服务器只会处理第一次请求，第二次请求返回内容和第一次一样。或者说如果地址相同，第一次请求时，将自动缓存，导致第二次不会重复请求了。Math.random()是调用javascript语法中的数学函数，能够产生随机数。
         末尾加Math.random()使每次请求地址不相同，服务器每次都去做不同的响应。也可以使用new date()时间戳的形式作为参数传递。
         */
        function changeImg(obj, createTypeFlag) {
            console.log('1');
            document.getElementById(obj.id).src = "/DrawImageServlet?createTypeFlag="
                + createTypeFlag + "&" + Math.random();
        }
    </script>
</head>
<body>
    <form action="/CheckCodeServlet" method="post">
        数字字母混合验证码：<input type="text" name="validateCode"/>
        <img alt="验证码看不清，换一张" src="/DrawImageServlet" id="validateCodeImg1" onclick="changeImg(this, 'nl')">
        <br>
        中文验证码：<input type="text" name="validateCode"/>
        <img alt="验证码看不清，换一张" src="/DrawImageServlet?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this, 'ch')">
        <input type="submit" value="提交">
    </form>
</body>
</html>
