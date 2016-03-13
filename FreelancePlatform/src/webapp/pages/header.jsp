<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" >
</head>
<body>
<sec:authentication var="principal" property="principal" />
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/"><i class="fa fa-home"></i>
      </a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="/createtask"> <i class="fa fa-plus"></i> Добавить задание</a></li>

<sec:authorize access="isAuthenticated()"> <li><a href="/myaccount">Привет, <i class="fa fa-user"></i> ${principal.username}!</a> </li> </sec:authorize>

        <sec:authorize access="!isAuthenticated()"> <li> <a href="/login">
          <i class="fa fa-user-plus"></i> Регистрация</a> </li> </sec:authorize>

        <%--<li><a href="/myaccount"><sec:authorize access="isAuthenticated()">--%>
          <%--<p>Привет,  <sec:authentication property="principal.username" /> !</p>--%>
        <%--</sec:authorize> </a></li>--%>
      </ul>
    </div>
  </div>
</div>
<br><br><br>
</body>
</html>
