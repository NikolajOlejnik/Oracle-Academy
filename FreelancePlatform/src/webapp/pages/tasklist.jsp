<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Актуальные задания</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">

        <p></p>

        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title"><b>Актуальные задания:</b></h3>

                        </div>

                        <div class="col col-xs-6 text-right">
                            <form class="navbar-form navbar-right" role="search" action="/search" method="get" commandName="request">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="поиск">
                                </div>
                                <button type="submit" class="form-control btn btn-default  "><span class="glyphicon glyphicon-search"></span></button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>
                            <th>Задание</th>
                            <th>Добавлено</th>
                            <th>Оплата</th>
                            <th>Подробности</th>
                            <th>Готовы выполнить?</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach items="${taskList}" var="task">
                            <td>${task.title}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd H:m" value="${task.dateAdded}"/></td>
                            <td>${task.price}</td>
                            <td width="400">
                                <button type="button" class="btn btn-info center-block" data-toggle="collapse" data-target="#${task.id}" >
                                    Посмотреть
                                </button>
                                <div id="${task.id}" class="collapse">
                                        ${task.description}
                                </div>
                            </td>
                            <td><a href="/task/${task.id}" method="GET" class="btn btn-success center-block"><em class="fa fa-check"></em></a>
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