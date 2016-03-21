<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Проверить статус заявок</title>
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
    <div class="col-md-10 col-md-offset-1">
      <div class="panel panel-default panel-table">
        <div class="panel-heading">
          <div class="row">
            <div class="col col-xs-6">
              <h3 class="panel-title">Ваши заявки:</h3>
            </div>
          </div>
        </div>
        <div class="panel-body">
          <table class="table table-striped table-bordered table-list">
            <thead>
            <tr>
              <th>Добавлена</th>
              <th>Комментарий</th>
              <th>Статус</th>
              <th>Действия</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <c:forEach items="${requestlist}" var="request">
              <td >${request.dateAdded}</td>
              <td>${request.comment}</td>
              <td>${request.status}</td>
                <td>Перейти на страницу задания</td>

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