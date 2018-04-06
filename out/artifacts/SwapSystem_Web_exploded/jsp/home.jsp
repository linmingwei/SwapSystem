<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>爱分享</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrapValidator.css">

    <link rel="stylesheet" href="../css/index.css">

</head>
<body>
<header>
    <div class="logo"><h4><a href="#">易物网 </a></h4></div>
    <div class="nav">
        <ul class="nav-list">
            <li><a href="/home.do">首页</a></li>
            <c:if test="${sessionScope.user!=null}">

            <li><a href="/exchange.do">发布旧物</a></li>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <c:if test="${empty(sessionScope.user.imgPath)}">
                    <li>
                        <%--<img src="../img/upload/152G4N20-9.jpg" alt="">--%>
                        <a  href="/user.do"><c:out value="${sessionScope.user.username}"/></a>
                        <ul>
                            <li><a>编辑个人资料</a></li>
                            <li><a href="/user/exit.do">登出</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${!empty(sessionScope.user.imgPath)}">
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
<div class="container">
    <div class="jumbotron">
        <h2>ishare</h2>
        <div class="jumtitle">汇聚全球好物，互享精品</div>

    </div>
    <div class="searchbar">
        <form action="/stuff/search.do">
            <div class="form-group">
                <label for="searchbar">旧物</label>
                <input type="text" id="searchbar" name="searchbar" class="form-control" placeholder="请输入想要的物品" >
            </div>
            <button   class="btn btn-primary" id="searchBtn">搜索</button>
        </form>
    </div>
    <div class="row ">
        <h2 class="page-header">热门好物</h2>
        <div class="items">
            <c:forEach var="stuffcard" items="${sessionScope.stuffcards}" >
                <%--<c:if test="${stuffcard.username}!=${sessionScope.user.username}">--%>
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
                                    <%--<c:set var="uid" value="${stuffcard.uid}" scope="request"/>--%>
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
                <%--</c:if>--%>

            </c:forEach>
            <a href="/oldstuff.do" class="btn btn-primary">查看更多精选好物</a>

        </div>
    </div>
</div>
<footer>
    <div class="container">
        <div class="col-md-3 text-center">
            <h4>24小时中文客服</h4>
            <h4>+86 10086</h4>
        </div>
        <div class="col-md-3 text-center">
            <h4>ishare</h4>
            <ul>
                <li>帮助</li>
                <li>政策</li>
                <li>条款</li>
                <li>隐私政策</li>

            </ul>
        </div>
        <div class="col-md-3 text-center">
            <h4>发现</h4>
            <ul>
                <li>信任与安全</li>
                <li>网站地图</li>
            </ul>
        </div>
        <div class="col-md-3 text-center">
            <h4>旧物交换</h4>
            <ul>
                <li>意义</li>
                <li>安全</li>
            </ul>
        </div>
        <div class="col-md-12 text-center">
            <div>沪ICP备1600228号-4 • VERSION 1.2.1</div>
            <div>ISHARE.COM © 2017-2018</div>
        </div>
    </div>
</footer>


<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrapValidator.js"></script>
<script src="../js/validator.js"></script>


</body>
</html>
