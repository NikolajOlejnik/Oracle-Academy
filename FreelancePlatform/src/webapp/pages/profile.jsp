<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Профиль пользователя ${user.name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><b>${user.name}</b></h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"><img alt="User Pic"
                                                                            src="/resources/images/anonymous.png"
                                                                            class="img-circle img-responsive"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>${user.about}</td>
                                </tr>
                                <tr>
                                    <td>Связь: ${user.email}</td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="/user/${user.id}/tasklist" class="btn btn-primary btn-sm">Размещённые заказы</a>
                            <a href="#" class="btn btn-primary btn-sm">Выполненные работы</a>
                        </div>
                    </div>
                </div>
                <div class="panel-footer">
                    <a class="btn btn-warning btn-sm" href="/edit/user/${user.id}" >
                            <i class="fa fa-pencil"></i>
                        Редактировать профиль
                    </a>
                    <a class="btn btn-danger btn-sm" href="/delete/user/${user.id}" >
                            <i class="fa fa-ban"></i>
                        Забанить
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
