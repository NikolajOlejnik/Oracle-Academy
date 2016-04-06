<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Вход на сайт</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/css/background.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
  <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info" >
      <div class="panel-heading">
        <div class="panel-title"><b>Вход на сайт</b>
        </div>
      </div>

      <div style="padding-top:30px" class="panel-body" >

        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>

        <form id="loginform" class="form-horizontal" role="form" action="/login" method="post">

          <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="логин">
          </div>

          <div style="margin-bottom: 25px" class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="login-password" type="password" class="form-control" name="password" placeholder="пароль">
          </div>

          <div style="margin-top:10px" class="form-group">
            <!-- Button -->

            <div class="col-sm-12 controls">
              <button id="btn-login" type="submit" class="btn btn-success">Войти <i class="fa fa-sign-in"></i></button>
            </div>
          </div>


          <div class="form-group">
            <div class="col-md-12 control">
              <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                Ещё нет аккаунта?
                <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                  <b>Регистрация</b> <i class="fa fa-user-plus"></i>
                </a>
              </div>
            </div>
          </div>
        </form>



      </div>
    </div>
  </div>
  <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title"><b>Регистрация</b></div>
      </div>
      <div class="panel-body" >
        <form id="signupform" class="form-horizontal" role="form" action="/registration" method="post" commandName="userForm">

          <div class="form-group">
            <label for="email" class="col-md-3 control-label">E-mail</label>
            <div class="col-md-9">
              <input type="email" class="form-control" name="email" placeholder="ваша электронная почта">
            </div>
          </div>

          <div class="form-group">
            <label for="login" class="col-md-3 control-label">Логин</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="login" placeholder="придумайте логин">
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-md-3 control-label">Пароль</label>
            <div class="col-md-9">
              <input type="password" class="form-control" name="password" placeholder="придумайте пароль">
            </div>
          </div>
          <div class="form-group">
            <label for="name" class="col-md-3 control-label">Ваше имя</label>
            <div class="col-md-9">
              <input type="text" class="form-control" name="name" placeholder="ваше имя">
            </div>
          </div>

          <div class="form-group">
            <label for="InputMessage" class="col-md-3 control-label">О себе</label>
            <div class="input-group">
              <textarea name="about" id="InputMessage" class="form-control" rows="5" cols="48" maxlength="300"  placeholder="Ваши навыки, профессиональные достижения, образование..." ></textarea>
            </div>
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
