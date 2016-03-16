<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Задания пользователя ${user.name}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
  <div class="row">

    <br>

    <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default panel-table">
        <div class="panel-heading">
          <div class="row">
            <div class="col col-xs-6">
              <h3 class="panel-title">Все задания пользователя <b>${user.name}</b></h3>
            </div>
          </div>
        </div>
        <div class="panel-body">
          <table class="table table-striped table-bordered table-list">
            <thead>
            <tr>
              <sec:authentication var="principal" property="principal" />
              <sec:authorize access="isAuthenticated()">
              <c:if test="${user.login == principal.username}">
                <th><em class="fa fa-cog"></em></th>
              </c:if>
              </sec:authorize>
              <th>Добавлено</th>
              <th>Описание</th>
              <th>Статус</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <c:forEach items="${taskList}" var="task">
                <sec:authentication var="principal" property="principal" />
                <sec:authorize access="isAuthenticated()">
                <c:if test="${user.login == principal.username}">
              <td align="center">

                <a class="btn btn-default" ><em class="fa fa-pencil"></em></a>
                <a class="btn btn-danger" href="/delete/${user.id}" method="GET"><em class="fa fa-trash"></em></a>

              </td>
                </c:if>
                </sec:authorize>
              <td><fmt:formatDate pattern="yyyy-MM-dd H:m" value="${task.dateAdded}"/></td>
              <td>${task.title}</td>
              <td>
                <a href="/task/${task.id}" method="GET">

              <c:if test="${task.status}">
                 <b>Задание всё ещё актуально <i class="fa fa-caret-square-o-right"></i>
                 </b>.
                </c:if>
                <c:if test="$!{task.status}">
                Задание закрыто <i class="fa fa-times"></i>

                </c:if>
                  </a>
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