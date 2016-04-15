<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<sec:authentication var="principal" property="principal"/>
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><i class="fa fa-home"></i>
            </a>
        </div>
        <ul class="nav navbar-nav">

            <li><a href="/users/tasks">Мои задания <i class="fa fa-file-text-o"></i></a></li>

            <li><a href="/tasks">Добавить задание <i class="fa fa-plus"></i></a></li>

            <li><a href="/users/requests">Проверить статус заявок <i class="fa fa-calendar-check-o"></i></a></li>


            <sec:authorize access="isAuthenticated()">
                <li><a href="/users/profile">Привет, <i class="fa fa-user"></i> ${principal.username}!</a></li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/admin">Панель администратора <i class="fa fa-cog"></i> </a></li>
                </sec:authorize>
                <li><a href="/logout">Выйти <i class="fa fa-sign-out"></i></a></li>
            </sec:authorize>

            <sec:authorize access="!isAuthenticated()">
                <li><a href="/login">
                    Вход <i class="fa fa-sign-in"></i>
                    / Регистрация <i class="fa fa-user-plus"></i></a></li>
            </sec:authorize>


        </ul>
    </div>
</div>
<br><br><br>
</body>
</html>
