<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Профиль пользователя ${user.name}</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid well span6">
  <div class="row-fluid">
    <div class="span2" >
      <img src="../resources/images/user.png"  width="150" height="150" class="img-circle">
    </div>

    <div class="span8">
      <h3>${user.name}</h3>
      <h6>О себе:  ${user.about}</h6>
      <h6>Связь: ${user.email}</h6>
    </div>

    <%--<div class="span2">--%>
      <%--<div class="btn-group">--%>
        <%--<a class="btn dropdown-toggle btn-info" data-toggle="dropdown" href="#">--%>
          <%--Action--%>
          <%--<span class="icon-cog icon-white"></span><span class="caret"></span>--%>
        <%--</a>--%>
        <%--<ul class="dropdown-menu">--%>
          <%--<li><a href="#"><span class="icon-wrench"></span> Modify</a></li>--%>
          <%--<li><a href="#"><span class="icon-trash"></span> Delete</a></li>--%>
        <%--</ul>--%>
      <%--</div>--%>
    <%--</div>--%>
  </div>
</div>
</body>
</html>
