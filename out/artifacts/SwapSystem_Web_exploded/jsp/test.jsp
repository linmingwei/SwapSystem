<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linmi
  Date: 2018/3/28
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="nihao"></c:out>
<%
String url=request.getRequestURI();

%>
<%=url%>
<c:out value="${requestScope.getRequest}">

</c:out>
<form action="/upload/test.do" enctype="multipart/form-data" method="post">
<input type="file" name="file" value="upload"/>
    <input type="submit" value="提交"/>
</form>
<img src="" alt="null">

</body>
</html>
