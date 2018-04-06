<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/user.css">

</head>
<body>
<jsp:include page="../jsp/header.jsp"/>
<div class="container">
    <div class="user-body">
        <div class="col-md-3">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs " role="tablist">
                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab"
                                                          data-toggle="tab">主页</a></li>
                <li role="presentation"><a href="#infomation" aria-controls="infomation" role="tab"
                                           data-toggle="tab">资料</a></li>
                <li role="presentation"><a href="#stuff" aria-controls="stuff" role="tab" data-toggle="tab">我的旧物</a>
                </li>
                <li role="presentation"><a href="#record" aria-controls="record" role="tab" data-toggle="tab">交易记录</a>
                </li>
                <li role="presentation"><a href="#notification" aria-controls="notification" role="tab" data-toggle="tab">系统通知</a>
                </li>
                <li role="presentation"><a href="#message" aria-controls="message" role="tab" data-toggle="tab">私信</a>
                </li>
            </ul>
        </div>

        <div class="col-md-8">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="user-home">
                        <div class="user-img ">
                            <img src="${sessionScope.user.imgPath}" class="center-block" alt="null">
                            <%--<div id="changeImg">--%>
                                <%--<input type="hidden" value="${sessionScope.user.uid}" id="uid" name="uid">--%>
                            <%--<label  class="btn btn-default" for="file">更换头像--%>
                            <%--</label>--%>
                            <%--<input type="file" id="file" name="file" class="hidden" accept="image/*" onchange="upload()">--%>

                            <%--</div>--%>
                        </div>
                        <p class="text-muted text-center h4">用户名：${sessionScope.user.username}</p>
                        <p id="info-detail" class="text-center h4"><a href="#infomation" aria-controls="infomation" role="tab"
                                                                      data-toggle="tab" class="text-primary">查看详细</a></p>
                        <h2 class="text-center">我的物品</h2>
                        <div class="row">
                            <c:forEach var="stuff" items="${sessionScope.user.stuffList}">

                                <div class="col-md-6">
                                    <div class="stuff">
                                        <a href="#" class="text-hide">
                                            <c:forEach var="img" items="${stuff.imgList}" begin="0" end="0">
                                                <img src="${img.path}" alt="null">
                                            </c:forEach>
                                        </a>
                                        <h4 class="text-center">${stuff.name}<span class="label label-primary pull-right">在售</span></h4>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="infomation">
                    <div class="user-info">
                        <div class="user-img ">
                            <img src="${sessionScope.user.imgPath}" class="center-block" alt="null">
                            <div id="changeImg">
                                <input type="hidden" value="${sessionScope.user.uid}" id="uid" name="uid">
                                <label  class="btn btn-default" for="file">更换头像
                                </label>
                                <input type="file" id="file" name="file" class="hidden" accept="image/*" onchange="upload()">

                            </div>
                        </div>
                        <form action="#" id="updateForm">
                            <input type="hidden" value="${sessionScope.user.uid}" >
                            <div class="form-group">
                                <label for="username">用户名</label>
                                <input type="text" id="username" name="username" class="form-control" value="${sessionScope.user.username}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="text" class="form-control" value="${sessionScope.user.password}" id="password" name="password">
                                <%--<button id="showPassword" class="btn" onclick="show()">显示</button>--%>
                            </div>
                            <div class="form-group">
                                <label for="phone">手机</label>
                                <input type="tel" class="form-control" value="${sessionScope.user.phone}" id="phone" name="phone">
                            </div>
                            <div class="form-group">
                                <label for="email">邮箱</label>
                                <input type="email" class="form-control" value="${sessionScope.user.email}" id="email" name="email"/>

                            </div>
                            <div class="info-button" style="margin: 40px 0 100px 0">
                                <button type="reset" class="btn btn-default col-md-2 col-md-offset-2 ">取消</button>
                                <button  id="updateUser" class="btn btn-primary col-md-2 col-md-offset-4">保存</button>

                            </div>
                        </form>

                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="stuff">
                    <div class="user-stuff">

                        <div class="row">
                            <c:forEach var="stuff" items="${sessionScope.user.stuffList}">

                            <div class="col-md-6">
                                <div class="stuff">
                                    <a href="#" class="text-hide">
                                        <c:forEach var="img" items="${stuff.imgList}" begin="0" end="0">
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


                </div>
                <div role="tabpanel" class="tab-pane" id="record">

                </div>
                <div role="tabpanel" class="tab-pane" id="notification">
                    <div class="alert alert-success" role="alert"><h4 class="text-center">系统通知</h4></div>
                    <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Warning!</strong> 这是系统通知测试！
                    </div>

                </div>
                <div role="tabpanel" class="tab-pane" id="message">
                    <div class="alert alert-info" role="alert"><h4 class="text-center">私信</h4></div>
                    <div class="alert alert-info alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>Warning!</strong> 这是他人通知测试！
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>
<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script>
    /*用户更改头像*/
    function upload() {
        var formData = new FormData();
        formData.append('file', $('#file')[0].files[0]);
        formData.append('uid',$('#uid').val());
        $.ajax({
            url: '/upload/userImg.do',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false
        }).done(function(res) {
            if(res.result=true){
                alert("上传成功");
                window.location.href="/user.do";
            }else {
                alert("上传失败，请重试");
            }
        });

    }
    /*显示密码*/
    /*更改用户信息*/
    $(function () {
        $('#updateUser').click(function () {
            var form=$('#updateForm').serialize();
            $.post({
                url:'/user/update.do',
                data:form,
                success:function (data) {
                    if(data.result=true) {
                        alert("更改成功"+data.result);
                    }else {
                        alert("请重试"+data.result);
                    }
                }
            });

        });
    });

</script>

</body>
</html>
