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

</body>
</html>
