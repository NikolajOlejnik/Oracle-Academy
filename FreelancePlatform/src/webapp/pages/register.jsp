<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
  <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css" />

  <script type="text/javascript" src="../resources/js/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

  <title>Register page</title>

</head>
<body>
<div class="container">

  <div class="page-header">
    <h1>Registration form <small>A Bootstrap template showing a registration form with standard fields</small></h1>
  </div>

  <!-- Registration form - START -->
  <div class="container">
    <div class="row">
      <form role="form" action="add" method="get" commandName="userForm">
        <div class="col-lg-6">
          <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Обязательные поля</strong></div>
          <div class="form-group">
            <label for="InputLogin">Введите логин</label>
            <div class="input-group">
              <input type="text" class="form-control" name="login" id="InputLogin" placeholder="Введите логин" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>
          <div class="form-group">
            <label for="InputPassword">Придумайте пароль</label>
            <div class="input-group">
              <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Введите пароль" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>
          <div class="form-group">
            <label for="InputName">Введите ваше имя</label>
            <div class="input-group">
              <input type="text" class="form-control" name="name" id="InputName" placeholder="Введите ваше имя" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>
          <div class="form-group">
            <label for="InputEmail">Введите ваш e-mail</label>
            <div class="input-group">
              <input type="email" class="form-control" id="InputEmail" name="email" placeholder="Enter Email" required>
              <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
          </div>

          <div class="form-group">
            <label for="InputMessage">Введите немного информации о себе</label>
            <div class="input-group">
              <textarea name="about" id="InputMessage" class="form-control" rows="5" ></textarea>
            </div>
          </div>
          <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
        </div>
      </form>
      <div class="col-lg-5 col-md-push-1">
        <div class="col-md-12">
          <div class="alert alert-success">
            <strong><span class="glyphicon glyphicon-ok"></span> Успешно!</strong>
          </div>
          <div class="alert alert-danger">
            <span class="glyphicon glyphicon-remove"></span><strong> Ошибка! Проверьте правильность заполнения всех полей. </strong>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Registration form - END -->

</div>

</body>
</html>
