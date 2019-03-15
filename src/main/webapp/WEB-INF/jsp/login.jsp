<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <h1>欢迎登录</h1>
        <form action="/loginUser" method="post">
            <input type = "text" name = "username"><br>
            <input type = "text" name ="password"><br>
            <button type="submit" value = "提交">提交</button>
        </form>
    </div>
</body>
</html>
