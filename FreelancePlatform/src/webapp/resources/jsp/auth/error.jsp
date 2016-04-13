<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Исправьте ошибки</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/css/background.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
  <div id="signupbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title"><b>Исправьте следующие ошибки: </b></div>
      </div>
      <div class="panel-body" >
        <form id="signupform" class="form-horizontal" role="form" action="/user" method="post" >

          <div class="form-group">
            <form:label	for="user.email" path="user.email" cssErrorClass="error" class="col-md-3 control-label">E-mail</form:label>
            <div class="col-md-9">
              <form:input path="user.email" class="form-control"  placeholder="Введите ваш e-mail" />
            </div>
            <br>
            <br>
            <div>
              <form:errors path="user.email" />
            </div>
          </div>

          <div class="form-group">
            <form:label	for="user.login" path="user.login" cssErrorClass="error" class="col-md-3 control-label">Логин</form:label>
            <div class="col-md-9">
              <form:input path="user.login" class="form-control"  placeholder="придумайте логин" />
            </div>
            <br>
            <br>
            <div>
              <form:errors path="user.login" />
            </div>
          </div>

          <div class="form-group">
            <form:label	for="user.password" path="user.password" cssErrorClass="error" class="col-md-3 control-label">Пароль</form:label>
            <div class="col-md-9">
              <form:input path="user.password" class="form-control"  placeholder="введите пароль" />
            </div>
            <br>
            <br>
            <div>
              <form:errors path="user.password" />
            </div>
          </div>

          <div class="form-group">
            <label for="InputMessage" class="col-md-3 control-label">О себе</label>
            <div class="input-group">
              <textarea name="about" id="InputMessage" class="form-control" rows="5" cols="48" maxlength="300"  placeholder="Ваши навыки, профессиональные достижения, образование..." ></textarea>
            </div>
            <br>
            <br>
            <div class="form-group">
              <!-- Button -->
              <div class="col-md-offset-3 col-md-9">
                <button id="btn-signup" type="submit" class="btn btn-info">Зарегистрироваться <i class="fa fa-user-plus"></i></button>
              </div>
            </div>


            <div class="col-md-12 control">
              <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                Уже есть аккаунт?
                <a href="#" onClick="$('#signupbox').hide(); $('#loginbox').show()">
                  <b>Вход на сайт</b> <i class="fa fa-sign-in"></i>
                </a>
              </div>
            </div>

          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
