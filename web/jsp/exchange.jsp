<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/23
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布页面</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../easyUpload.js/easy-upload.css">
    <link rel="stylesheet" href="../css/exchange.css">

</head>
<body>
<jsp:include page="../jsp/header.jsp"/>
<div class="container ">
    <h3>请输入物品信息</h3>
    <form  id="stuffForm" method=""  action="" >
        <input type="hidden" id="uid" name="uid" value="${sessionScope.user.uid}">
        <input type="hidden" id="sid" name="sid" value="${sessionScope.maxId+1}">
        <div class="col-md-6">
            <div class="form-group">
                <label for="name">物品名称</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="cid">分类</label>
                <div class="category row">
                    <div class="col-md-6">
                        <select class="form-control" id="first"  onchange="firstSel()">
                            <c:forEach var="category" items="${sessionScope.categoryList}">
                            <option value="${category.name}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <select class="form-control" id="cid" name="cid">
                        </select>
                    </div>

                </div>
            </div>
            <div class="form-group">
                <label for="buyDate">购买日期</label>
                <input type="date" class="form-control" id="buyDate" name="buyDate">
            </div>
            <div class="form-group">
                <label for="willing">想换物品</label>
                <input type="text" class="form-control" id="willing" name="willing">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label for="originalPrice">原价</label>
                <input type="text" class="form-control" id="originalPrice" name="originalPrice">
            </div>
            <div class="form-group">
                <label for="oldness">新旧程度</label>
                <input type="text" class="form-control" id="oldness" name="oldness">
            </div>
            <div class="form-group">
                <label for="price">系统估价<a id="pricing" class="small">（点击自动估价）</a></label>
                <input type="text" class="form-control" id="price" name="price">
            </div>
            <div class="form-group">
                <label for="otherInfo">其他</label>
                <input type="text" class="form-control" id="otherInfo" name="otherInfo">
            </div>
        </div>
        <div class="col-md-12">
            <div class="form-group">
                <label for="description">详细描述</label>
                <textarea class="form-control" rows="3" id="description" name="description"></textarea>

            </div>
        </div>
        <div class="col-md-12">
            <div id="easyContainer">

            </div>
        </div>
        <div class="col-md-12">
            <button id="finalsub"   class=" btn btn-primary center-block" >提交</button>
        </div>

    </form>
</div>

<!--引入js文件-->
<script src="../bootstrap/js/jquery-3.2.1.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../easyUpload.js/vendor/jquery.cookie-1.4.1.min.js"></script>
<script src="../easyUpload.js/easyUpload.js"></script>
<script type="text/javascript">
    /*图片上传插件*/
    $(function () {
        $('#easyContainer').easyUpload({
            allowFileTypes: '*.jpg;*.doc;*.pdf;*.png',//允许上传文件类型，格式';*.doc;*.pdf'
            allowFileSize: 100000,//允许上传文件大小(KB)
            selectText: '选择文件',//选择文件按钮文案
            multi: true,//是否允许多文件上传
            multiNum: 5,//多文件上传时允许的文件数
            showNote: true,//是否展示文件上传说明
            note: '提示：最多上传5个文件，支持格式为doc、pdf、jpg',//文件上传说明
            showPreview: true,//是否显示文件预览
            url: '/upload/stuffImg.do',//上传文件地址
            fileName: 'file',//文件filename配置参数
            formParam: {
                "sid":$('#sid').val()
//                token: $.cookie('token_cookie')//不需要验证token时可以去掉
            },//文件filename以外的配置参数，格式：{key1:value1,key2:value2}
            timeout: 30000,//请求超时时间
            successFunc: function(res) {
//                if(res.result=true){

                console.log('成功回调', res);
//                }
            },//上传成功回调函数
            errorFunc: function(res) {
//                if(res.result=false) {

                console.log('失败回调', res);
//                }
            },//上传失败回调函数
            deleteFunc: function(res) {
                console.log('删除回调', res);
            }//删除文件回调函数
        });

    })
</script>
<script>
    /*二级菜单联动脚本*/
    $(function () {
        var pname=$('#first').val();
        $.post({
            url:'/category/findChild.do',
            data:{'pname':pname},
            dataType:"json",
            success:function (data) {
//                        alert(data.childs);
                var option;
                $.each(data.childs,function (i,n) {
                    option += "<option value='"+n.id+"'>"+n.name+"</option>"
                });
                $("#cid").html(option);//将循环拼接的字符串插入第二个下拉列表
                $("#cid").show();//把第二个下拉列表展示
            }

        });
    })
    function firstSel() {
            var pname=$('#first').val();
//            alert(pname);
            if(pname!=null && ""!= pname&& -1!= pname){
                $.post({
                    url:'/category/findChild.do',
                    data:{'pname':pname},
                    dataType:"json",
                    success:function (data) {
//                        alert(data.childs);
                        var option;
                        $.each(data.childs,function (i,n) {
                            option += "<option value=''>"+n.name+"</option>"
                        });
                        $("#cid").html(option);//将循环拼接的字符串插入第二个下拉列表
                        $("#cid").show();//把第二个下拉列表展示
                    }

                });

            }else {
                $('#second').hide();
            }
        }
</script>
<script>
    /*表单提交*/
    $(function () {
        $('#finalsub').click(function (e) {
            e.preventDefault();
//            var formData=$('#stuffForm').serialize();
            console.log($('#name').val());
            $.post({
                url:'/stuff/add.do',
                data:{
                    'name':$('#name').val(),
                    'cid':$('#cid').val(),
                    'uid':$('#uid').val(),
                    'originalPrice':$('#originalPrice').val(),
                    'price':$('#price').val(),
                    'description':$('#description').val(),
                    'oldness':$('#oldness').val(),
                    'buyDate':$('#buyDate').val(),
                    'otherInfo':$('#otherInfo').val(),
                    'willing':$('#willing').val(),
                    'sid':$('#sid').val()


                },
                success:function (data) {
                    if(data.result=true) {
                        alert("添加成功")
                        window.location.href="/home.do";
                    }else {
                        alert("添加失败")
                    }

                }

            });
        });

    })
</script>
</body>
</html>
