<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>他人资料</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/other.css">

</head>
<body>
<jsp:include page="../jsp/header.jsp"/>

<div class="container">

    <div class="user-img ">
        <img src="${requestScope.other.imgPath}" class="center-block" alt="null">
    </div>
    <p class="text-muted text-center h4">用户名：${requestScope.other.username} </p>
    <p class="text-muted text-center h4"><a href="#">私信</a> </p>
    <h2 class="page-header">他的发布</h2>
    <div class="row">
        <c:forEach var="stuff" items="${other.stuffList}">
            <div class="col-md-6">
                <div class="stuff">
                    <a href="#" class="text-hide">
                        <c:forEach items="${stuff.imgList}" var="img" begin="0" end="0">

                        <img src="${img.path}" alt="null">
                        </c:forEach>
                    </a>
                    <h4 class="text-center">${stuff.name}<span class="label label-primary pull-right">在售</span></h4>

                </div>

            </div>
        </c:forEach>
        <nav aria-label="...">
            <ul class="pager">
                <li><a href="#">Previous</a></li>
                <li><a href="#">Next</a></li>
            </ul>
        </nav>
    </div>

</div>
<jsp:include page="../jsp/footer.jsp"/>

<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
