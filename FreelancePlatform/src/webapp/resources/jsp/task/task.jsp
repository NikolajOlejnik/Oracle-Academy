<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>${task.title}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">
        .panel-shadow {
            box-shadow: rgba(0, 0, 0, 0.3) 7px 7px 7px;
        }

        .panel-white {
            border: 1px solid #dddddd;
        }

        .post .post-heading {
            height: 95px;
            padding: 20px 15px;
        }

        .post .post-heading .avatar {
            width: 60px;
            height: 60px;
            display: block;
            margin-right: 15px;
        }

        .post .post-heading .meta .title {
            margin-bottom: 0;
        }

        .post .post-heading .meta .title a {
            color: black;
        }

        .post .post-heading .meta .title a:hover {
            color: #aaaaaa;
        }

        .post .post-heading .meta .time {
            margin-top: 8px;
            color: #999;
        }

        .post .post-description {
            padding: 15px;
        }

        .post .post-description p {
            font-size: 14px;
        }

        .post .post-footer {
            border-top: 1px solid #ddd;
            padding: 15px;
        }

        .post .post-footer .input-group-addon a {
            color: #454545;
        }

        .post .post-footer .comments-list {
            padding: 0;
            margin-top: 20px;
            list-style-type: none;
        }

        .post .post-footer .comments-list .comment {
            display: block;
            width: 100%;
            margin: 20px 0;
        }

        .post .post-footer .comments-list .comment .avatar {
            width: 35px;
            height: 35px;
        }

        .post .post-footer .comments-list .comment .comment-heading {
            display: block;
            width: 100%;
        }

        .post .post-footer .comments-list .comment .comment-heading .user {
            font-size: 14px;
            font-weight: bold;
            display: inline;
            margin-top: 0;
            margin-right: 10px;
        }

        .post .post-footer .comments-list .comment .comment-heading .time {
            font-size: 12px;
            color: #aaa;
            margin-top: 0;
            display: inline;
        }

        .post .post-footer .comments-list .comment .comment-body {
            margin-left: 50px;
        }

        .post .post-footer .comments-list .comment > .comments-list {
            margin-left: 50px;
        }

        .red {
            color: red;
        }

        .form-area {
            background-color: #FAFAFA;
            padding: 10px 40px 60px;
            margin: 10px 0 60px;
            border: 1px solid GREY;
        }

    </style>
    <script type="text/javascript">

        $(document).ready(function () {
            $('#characterLeft').text('140 символов осталось');
            $('#message').keydown(function () {
                var max = 140;
                var len = $(this).val().length;
                if (len >= max) {
                    $('#characterLeft').text('Вы достигли лимита');
                    $('#characterLeft').addClass('red');
                    $('#btnSubmit').addClass('disabled');
                }
                else {
                    var ch = max - len;
                    $('#characterLeft').text(ch + ' символов осталось ');
                    $('#btnSubmit').removeClass('disabled');
                    $('#characterLeft').removeClass('red');
                }
            });
        });
        $(document).ready(function () {
            $(".btn-primary").click(function () {
                $(".collapse").toggle("slow");
            });
        });

    </script>
</head>
<body>
<jsp:include page="../header.jsp"/>
<sec:authentication var="principal" property="principal"/>
<%--<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">--%>
<div class="container">
    <div class="col-sm-8">
        <div class="panel panel-white post panel-shadow">
            <div class="post-heading">
                <div class="pull-left image">
                    <img src="../resources/images/father.jpeg" class="img-circle avatar"
                         alt="user profile image">
                </div>
                <div class="pull-left meta">
                    <div class="title h5">
                        <a href="/users/${task.user.id}"><b>${task.user.name}</b></a>
                        предложил работу:
                    </div>
                    <h6 class="text-muted time"><i class="fa fa-clock-o"></i>
                        <fmt:formatDate pattern="yyyy-MM-dd H:m" value="${task.dateAdded}"/></h6>
                    <h6 class="text-muted time"><i class="fa fa-money"></i> ${task.price}</h6>
                </div>
                <div class="post-edit pull-right">
                </div>
            </div>
            <div class="post-description">
                ${task.description}
            </div>
            <div class="post-footer">
                <sec:authorize access="!isAuthenticated()"> Если хотите оставить заявку - <a href="/login">
                    войдите <i class="fa fa-sign-in"></i>
                    или зарегистрируйтесь <i class="fa fa-user-plus"></i></a> <br> <br> </sec:authorize>
                <c:if test="${task.requestList.isEmpty()}">
                    Заявок пока нет...
                    <br>
                </c:if>
                <c:if test="${!task.requestList.isEmpty()}">
                    <b> Претенденты: </b>
                    <ul class="comments-list">
                        <tr>
                            <c:forEach items="${task.requestList}" var="request">
                                <li class="comment panel-shadow panel-white">

                                    <a class="pull-left" href="/users/${request.user.id}">
                                        <img class="avatar" src="../resources/images/anonymous.png"
                                             alt="avatar">
                                    </a>

                                    <div class="comment-body">
                                        <sec:authorize access="isAuthenticated()">
                                            <c:if test="${task.user.login == principal.username && task.status}">
                                                <a action="tasks/${task.id}/accept/${request.id}" class="btn btn-success pull-right">Принять запрос
                                                    <em class="fa fa-check-square-o"></em></a>
                                            </c:if>
                                        </sec:authorize>

                                        <div class="comment-heading">
                                            <div class="title h4"><a
                                                    href="/users/${request.user.id}"> ${request.user.name} </a></div>
                                            <h5 class="time"><fmt:formatDate pattern="yyyy-MM-dd H:mm"
                                                                             value="${request.dateAdded}"/></h5>

                                        </div>
                                        <p>${request.comment}
                                        </p>
                                    </div>
                                </li>
                            </c:forEach>
                        </tr>
                    </ul>
                </c:if>

                <sec:authorize access="isAuthenticated()">
                    <c:if test="${task.user.login != principal.username && task.status}">
                        <button type="button" class="btn btn-primary">Оставить заявку <i
                                class="fa fa-caret-square-o-down"></i>
                        </button>
                        <div class="collapse">
                            <div class="form-area">
                                <form role="form" action="/tasks/${task.id}/request" method="post" >
                                    <br style="clear:both">
                                    <div class="form-group">
                                        <textarea class="form-control" name="comment" type="textarea" id="message"
                                                  placeholder="Оставьте комментарий к заявке" maxlength="140"
                                                  rows="7"></textarea>
                                        <span class="help-block"><p id="characterLeft" class="help-block ">Вы достигли
                                            лимита</p></span>
                                    </div>
                                    <button id="btn-login" type="submit" class="btn btn-success">Отправить запрос <i
                                            class="fa fa-sign-in"></i></button>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </sec:authorize>
            </div>
        </div>
    </div>
</div>

</body>
</html>
