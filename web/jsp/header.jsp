<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/30
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrapValidator.css">

    <link rel="stylesheet" href="../css/header.css">

</head>
<body>
<header>
    <div class="logo"><h4><a href="#">易物网 </a></h4></div>
    <div class="nav">
        <ul class="nav-list">
            <li><a href="/home.do">首页</a></li>
            <c:if test="${sessionScope.user!=null}">

                <li><a href="/exchange.do">发布旧物</a></li>
            </c:if>            <c:if test="${sessionScope.user!=null}">
                <c:if test="${empty(user.imgPath)}">
                    <li>
                        <a  href="/user.do"><c:out value="${sessionScope.user.username}"/></a>
                        <ul>
                            <li><a>编辑个人资料</a></li>
                            <li><a href="/user/exit.do">登出</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${!empty(user.imgPath)}">
                    <li>
                        <a class="inner-img" href="/user.do">
                            <img src="${sessionScope.user.imgPath}"  alt="null">
                            <ul>
                                <li><a href="/user.do">编辑个人资料</a></li>
                                <li><a href="/user/exit.do">登出</a></li>
                            </ul>
                        </a>
                    </li>
                </c:if>
            </c:if>
            <c:if test="${sessionScope.user==null}">
                <li><a href="/register.do">注册</a></li>
                <li><a href="/login.do">登录</a></li>
            </c:if>

        </ul>
    </div>
</header>
</body>
</html>
