<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrapValidator.css">
    <link rel="stylesheet" href="../css/login.css">

</head>
<body>
<div class="login-nav">
    <div class="logo"><h4><a href="#">易物网 </a></h4></div>
    <div class="nav">
        <ul class="nav-list">
            <li><a href="/home.do">首页</a></li>
            <li><a href="/exchange.do">发布旧物</a></li>
            <li><a href="/register.do">注册</a></li>
            <li><a href="/login.do">登录</a></li>
        </ul>
    </div>
</div>
<h1 class="text-center">登录</h1>
<div class="login-body center-block">
    <div class="panel">
        <form id="loginForm" class="form-horizontal">
            <div class="form-group">

                <input type="text" class="form-control" placeholder="用户名" name="username" id="username">
            </div>
            <div class="form-group">

                <input type="password" class="form-control" placeholder="密码" name="password" id="password">
            </div>
            <div class="form-group">

                <p><a href="/register.do">没有用户？注册一个</a></p>
                <input type="checkbox">   <span>记住我</span>
            </div>
            <button id="submitBtn" class="btn btn-primary">登录</button>
        </form>
    </div>

</div>

<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrapValidator.js"></script>
<%--用户登录表单提交脚本--%>
<script>
    $(function (e) {
        $('#submitBtn').click(function (e) {
            e.preventDefault();
            $.ajax({
                url:'/user/check.do',
                type:'post',
                data:$('#loginForm').serialize(),
//                contentType:"application/json",
                dataType:"json",
                success:function (data) {
                    if(data.valide==true){
                        alert("登录成功！");
                        window.location.href="/home.do";
                    }else {
                        alert("用户名或密码错误，请重新登录");

                    }

                }

            })
        });
    })
</script>

</body>
</html>
