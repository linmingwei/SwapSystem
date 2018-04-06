<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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
            <li><a href="/login/.do">登录</a></li>
        </ul>
    </div>
</div>
<h1 class="text-center">注册</h1>
<div class="login-body center-block">
    <div class="panel">
        <form  class="form-horizontal" id="registerForm">
            <div class="form-group">
                <input type="text" class="form-control" id="username" name="username" placeholder="用户名:不少于六位，不包含特殊字符">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="密码">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="repassword" name="repassword" placeholder="确认密码">
            </div><div class="form-group">
            <input type="tel" class="form-control" id="phone" name="phone" placeholder="手机号">
        </div><div class="form-group">
            <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
        </div>
            <button id="registerBtn" class="btn btn-primary">注册</button>
        </form>
    </div>

</div>
<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrapValidator.js"></script>
<script src="../js/validator.js"></script>
<script>
    /*用户注册表单提交脚本*/
    $(function (e) {
        $('#registerBtn').click(function () {
            var formData=$('#registerForm').serialize();
            $.post({
                url:"/user/adduser.do",
                data:formData,
                dataType:"json",
                success:function (data) {
                    if(data.result=true){
                        alert("注册成功！请登陆");
                        window.location.href="/login.do";
                    }else{
                        alert("注册失败，请重试");
                    }
                }
            })
        });
    })
</script>

</body>
</html>
