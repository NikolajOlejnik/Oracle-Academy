<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Новое задание</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css" />
  <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>


<jsp:include page="header.jsp"/>
<div class="container-fluid">
  <section class="container">
    <div class="container-page">
      <form role="form" action="addtask" method="post" commandName="task">
      <div class="col-md-6">
        <h3 class="dark-grey"> Добавить новое задание </h3>

        <div class="form-group col-lg-12">
          <label>Название задачи</label>
          <input type="text" name="title" class="form-control" >
        </div>

        <div class="form-group col-lg-4">
          <label>Оплата</label>
          <input type="text" name="price" class="form-control">
        </div>

        <div class="form-group col-lg-12">
          <label>Описание</label>
          <textarea style="resize:vertical" name="description" class="form-control"> </textarea>
        </div>

      </div>

      <div class="col-md-6">
        <h3 class="dark-grey">Проверьте правильность заполнения формы</h3>
        <p>
          В поле <b>"Название задачи"</b> опишите краткое и максимально точное описание задания.
        </p>
        <p>
          <b>Пример:</b> Сделать сайт вроде "Фейсбука"
        </p>
        <p>
          В поле <b>"Оплата"</b> укажите сумму, которую вы готовы заплатить за выполнение вашего задания и валюту, в которой будет производиться оплата.
        </p>
        <p>
          <b>Пример:</b> 250 гривен
        </p>
        <p>
          В поле <b>"Описание"</b> подробно опишите поставленную задачу и требования, которые вы выдвигаете к исполнителю.
        </p>
        <p>
          <b>Пример:</b> Нужно немного подредактировать dao-слой учебного проекта. Идеальный исполнитель - Senior Java Developer с 10-летним опытом работы не старше 25 лет, знающий китайский и иврит.
        </p>

        <input type="submit" class="btn btn-primary btn-block"/>
      </div>
      </form>
    </div>
  </section>
</div>
</body>
</html>