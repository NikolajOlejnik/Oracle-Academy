<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>${task.title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css"/>
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
              <h3 class="panel-title"><b>${task.title}</b>
              </h3>
            </div>
            <small class="pull-right">Заказчик: <b> <a href="/user/${taskOwner.id}">${taskOwner.name}</a>  </b> </small>
            <br>
            <small class="pull-right">Добавлено: <b> <fmt:formatDate pattern="yyyy-MM-dd H:m"  value="${task.dateAdded}" /></b> </small>
            <br>
            <small class="pull-right">Оплата: <b> ${task.price} </b> </small>
          </div>
        </div>
        <div class="panel-body">

          ${task.description}

        </div>
        <div class="panel-footer">
          <div class="row">

          </div>
        </div>
      </div>

    </div>
  </div>
</div>

</body>
</html>
