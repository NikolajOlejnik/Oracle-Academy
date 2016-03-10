<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css"/>

</head>
<body>



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
                            <th><em class="fa fa-cog"></em></th>
                            <th class="hidden-xs">ID</th>
                            <th>Логин</th>
                            <th>Имя пользователя</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach items="${usersList}" var="user">
                            <td align="center">
                                <a class="btn btn-default" ><em class="fa fa-pencil"></em></a>
                                <a class="btn btn-danger" href="/delete/${user.id}" method="GET"><em class="fa fa-trash"></em></a>
                            </td>
                            <td class="hidden-xs">${user.id}</td>
                            <td>${user.login}</td>
                            <td>${user.name}</td>
                        </tr>
                        </tbody>
                        </c:forEach>
                    </table>

                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col col-xs-4">Page 1 of 5
                        </div>
                        <div class="col col-xs-8">
                            <ul class="pagination hidden-xs pull-right">
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                            </ul>
                            <ul class="pagination visible-xs pull-right">
                                <li><a href="#">«</a></li>
                                <li><a href="#">»</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<%--<table border="1" width="100%" cellpadding="5">--%>
<%--<tr>--%>
<%--<th>id</th>--%>
<%--<th>login</th>--%>
<%--<th>name</th>--%>
<%--<th>actions</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${usersList}" var="user">--%>
<%--<tr>--%>
<%--<td>${user.id}</td>--%>
<%--<td>${user.login}</td>--%>
<%--<td>${user.name}</td>--%>
<%--<td>--%>
<%--<form action="/delete/${user.id}" method="GET">--%>
<%--<button type="submit">delete</button>--%>
<%--</form><form action="/edit?id=${user.id}" method="GET">--%>
<%--<button type="submit">edit</button>--%>
<%--</form>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

</body>
</html>