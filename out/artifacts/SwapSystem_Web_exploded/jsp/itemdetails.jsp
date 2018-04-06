<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>物品查看</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/itemdetails.css">

</head>
<body>
<header>
    <div class="logo"><h4><a href="#">易物网 </a></h4></div>
    <div class="nav">
        <ul class="nav-list">
            <li><a href="/home.do">首页</a></li>
            <li><a href="/exchange.do">发布旧物</a></li>
            <c:if test="${sessionScope.user!=null}">
                <c:if test="${empty(sessionScope.user.imgPath)}">
                    <li>
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
<div class="details-body">
    <div class="container">
        <div class="details-img">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators 指示器 -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <c:forEach var="x" begin="1" end="${fn:length(requestScope.stuff.imgList)}">

                    <li data-target="#carousel-example-generic" data-slide-to="x"></li>
                    </c:forEach>
                    <%--<li data-target="#carousel-example-generic" data-slide-to="2"></li>--%>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${requestScope.stuff.imgList.get(0).path}" alt="...">
                    </div>
                    <c:forEach var="img" items="${requestScope.stuff.imgList}" begin="1" end="${fn:length(requestScope.stuff.imgList)}">

                    <div class="item">
                        <img src="${img.path}" alt="...">
                    </div>
                    </c:forEach>
                    <%--<div class="item">--%>
                        <%--<img src="../img/cover.jpg" alt="...">--%>
                    <%--</div>--%>

                </div>

                <!-- Controls 控制按钮 -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-md-12">
            <ul class="pull-left">
                <li><a href="#">参数</a></li>
                <li><span>·</span></li>
                <li><a href="#">详情</a></li>
                <li><span>·</span></li>
                <li><a href="#">评论</a></li>
            </ul>

        </div>
        <div class="col-md-12">
            <div class="param">
                <div class="item-title">参数</div>
                <table class="table">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <td>物品名称：</td>
                        <td>${requestScope.stuff.name}</td>
                    </tr>
                    <tr>
                        <td>购入时间：</td>
                        <td>${requestScope.stuff.buyDate}</td>
                    </tr>
                    <tr>
                        <td>原价：</td>
                        <td>${requestScope.stuff.originalPrice}</td>
                    </tr>
                    <tr>
                        <td>新旧程度：</td>
                        <td>${requestScope.stuff.oldness}</td>
                    </tr>
                    <tr>
                        <td>想换物品：</td>
                        <td>${requestScope.stuff.willing}</td>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
        <div class="col-md-12">
            <div class="item-title">详情</div>
            <div class="owner">
                <a class="text-hide" href="${(sessionScope.user.username)==(requestScope.user.username)?"/user.do":"/other_info.do"}">
                   <img src="${requestScope.user.imgPath}" alt="null">
                </a>

                <span>物主：${requestScope.user.username}<a href="#" id="sixin">私信他</a></span>
            </div>
            <dl class="dl-horizontal">
                <dt>描述</dt>
                <dd>${requestScope.stuff.description}</dd>
            </dl>
            <div class="comment">
                <div class="item-title">评论</div>
                <div class="text-center">
                    <span class="glyphicon glyphicon-comment"></span>
                    <p>还没有人评论...</p>
                </div>
            </div>
        </div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="col-md-3 text-center">
            <h4>24小时中文客服</h4>
            <h4>+86   10086</h4>
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

</body>
</html>
