<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Управление пользователями</title>
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

        <p></p>

        <h1>Управление пользователями</h1>

        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Все пользователи:</h3>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>
                            <th>Логин</th>
                            <th>Имя пользователя</th>
                            <th>Управление аккаунтом</th>
                            <th>Права администратора</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach items="${usersList}" var="user">
                            <td>${user.login}</td>
                            <td>${user.name}</td>
                            <td>
                                <a class="btn btn-default" href="/edit/user/${user.id}" >
                                    <span class="fa-stack">
  <i class="fa fa-pencil fa-stack-1x"></i>
</span>Редактировать</a>
                                <a class="btn btn-default" href="/user/${user.id}" method="delete">
                                    <span class="fa-stack">
  <i class="fa fa-user fa-stack-1x"></i>
  <i class="fa fa-ban fa-stack-2x text-danger"></i>
</span>Забанить</a>

                            </td>
                            <td>
                                <c:if test="${user.role == 'ROLE_USER'}">
                                    <a class="btn btn-default" href="/makeadmin/user/${user.id}" >
                                        <span class="fa-stack">
                                            <i class="fa fa-square-o fa-stack-2x"></i>
                                            <i class="fa fa-thumbs-up fa-stack-1x"></i>
                                        </span>
                                        Сделать администратором<br>
                                    </a>
                                </c:if>
                                <c:if test="${user.role == 'ROLE_ADMIN'}">
                                    <a class="btn btn-default" href="/reduce/user/${user.id}">
                                    <span class="fa-stack">
                                            <i class="fa fa-square-o fa-stack-2x text-danger"></i>
                                            <i class="fa fa-thumbs-down fa-stack-1x"></i>
                                    </span>Забрать права администратора<br>
                                    </a>
                                </c:if>

                            </td>
                        </tr>
                        </tbody>
                        </c:forEach>
                    </table>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>