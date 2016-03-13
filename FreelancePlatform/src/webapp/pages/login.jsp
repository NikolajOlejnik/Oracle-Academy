<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>Вход на сайт</title>

  <!-- Bootstrap core CSS -->
  <link href="../resources/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom style for this page -->
  <link href="../resources/css/signin.css" rel="stylesheet">

</head>
<body>
<div class="container">
  <form class="form-signin" role="form" action='/login'  method="post">
    <h2 class="form-signin-heading">Войдите, чтобы продолжить</h2>
    <label for="inputLogin" class="sr-only">Логин</label>
    <input type="text" id="inputLogin" class="form-control" placeholder="логин" required autofocus name="j_username">
    <label for="inputPassword" class="sr-only">Пароль</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="пароль" required name="j_password">
    <button class="btn btn-lg btn-primary btn-block" type="submit" value="login">Войти</button>
  </form>
</div>
</body>
</html>
