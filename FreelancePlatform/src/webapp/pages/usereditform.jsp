<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Редактировать профиль</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <section class="container">
        <div class="container-page">
            <form role="form" action="/user/${user.id}/update" method="post" commandName="editeduser">
                <div class="col-md-6">
                    <h3 class="dark-grey">Редактировать профиль</h3>

                    <div class="form-group col-lg-12">
                        <input type="hidden" name="id" class="form-control" value="${user.id}" readonly>
                    </div>

                    <div class="form-group col-lg-12">
                        <label>Логин</label>
                        <input type="text" name="login" class="form-control" value="${user.login}" readonly>
                    </div>

                    <div class="form-group col-lg-12">
                        <label>Пароль</label>
                        <input type="password" name="password" class="form-control" value="${user.password}">
                    </div>

                    <div class="form-group col-lg-12">
                        <label>Имя</label>
                        <input type="text" name="name" class="form-control" value="${user.name}">
                    </div>

                    <div class="form-group col-lg-12">
                        <label>E-mail</label>
                        <input type="text" name="email" class="form-control" value="${user.email}">
                    </div>


                    <div class="form-group col-lg-12">
                        <label>О себе</label>
                        <textarea style="resize:vertical" name="about" class="form-control"> ${user.about}</textarea>
                    </div>

                </div>

                <input type="submit" class="btn btn-primary btn-block"/>
            </form>
        </div>
    </section>
</div>
</body>
</html>
