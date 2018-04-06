<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物品分类</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/oldstuff.css   ">

</head>
<body>
<jsp:include page="../jsp/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-3 ">
            <nav class="cate-nav">
                <ul >
                    <c:forEach var="category" items="${sessionScope.categoryList}">
                        <li>
                            <a href="#">${category.name}</a>
                            <ul >
                                <c:forEach var="childCategory" items="${category.categoryList}">
                                    <li><a href="/stuff/findCid.do?cid=${childCategory.id}">${childCategory.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </nav>
        </div>
        <div class="col-md-9">
            <div class="stuff-filter">
                <div class="shaixuan h4">筛选：</div>
                <!-- Single button -->
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        价格 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">从高到低</a></li>
                        <li><a href="#">从低到高</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        发布时间 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">最早</a></li>
                        <li><a href="#">最晚</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Action <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <成色>            </成色> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">全新</a></li>
                        <li><a href="#">九成新</a></li>
                        <li><a href="#">八成新</a></li>
                    </ul>
                </div>
                <div class="row">
                    <c:forEach var="stuffcard" items="${requestScope.stuffCardList}">
                        <div class="col-md-4">
                            <div class="item">
                                <div class="thumbnail">
                                    <a href="/stuff/findStuff.do?sid=${stuffcard.sid}" class="text-hide">
                                        <img src="${stuffcard.stuffImg}" alt="null">
                                    </a>
                                    <div class="item-body">
                                        <div class="item-title ">
                                            <h3 class="text-overflow">
                                                    ${stuffcard.title}
                                            </h3>

                                        </div>
                                        <div class="clearfix">
                                            <p>想换：</p>
                                            <div class="price pull-right">${stuffcard.willing}</div>

                                        </div>
                                        <div class="clearfix">
                                            <p>价格：</p>
                                            <div class="price pull-right">￥${stuffcard.price}</div>

                                        </div>
                                        <div class="user-head">
                                            <a href="${(sessionScope.user.username)==(stuffcard.username)?"/user.do":(stuffcard.link)}" class="text-hide ">
                                                <img src="${stuffcard.headImg}" alt="null">
                                            </a>
                                            <span class="h4">${stuffcard.username}</span>
                                            <span class="text-muted small text-right ">几分钟前</span>
                                        </div>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <nav aria-label="Page navigation" >
                        <ul class="pagination pagination-lg">
                            <li class="disabled">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="#" >1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>


                </div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="../jsp/footer.jsp"/>

<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
