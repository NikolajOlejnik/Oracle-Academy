<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>${task.title}</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css"/>
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

        .panel-white .panel-heading {
            color: #333;
            background-color: #fff;
            border-color: #ddd;
        }

        .panel-white .panel-footer {
            background-color: #fff;
            border-color: #ddd;
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

        .post .post-image .image {
            width: 100%;
            height: auto;
        }

        .post .post-description {
            padding: 15px;
        }

        .post .post-description p {
            font-size: 14px;
        }

        .post .post-description .stats {
            margin-top: 20px;
        }

        .post .post-description .stats .stat-item {
            display: inline-block;
            margin-right: 15px;
        }

        .post .post-description .stats .stat-item .icon {
            margin-right: 8px;
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

        .red{
            color:red;
        }
        .form-area
        {
            background-color: #FAFAFA;
            padding: 10px 40px 60px;
            margin: 10px 0px 60px;
            border: 1px solid GREY;
        }

    </style>
    <script type="text/javascript">

        $(document).ready(function(){
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
        $(document).ready(function(){
            $(".btn-primary").click(function(){
                $(".collapse").toggle("slow");
            });
        });

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
<div class="container">
    <div class="col-sm-8">
        <div class="panel panel-white post panel-shadow">
            <div class="post-heading">
                <div class="pull-left image">
                    <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-circle avatar"
                         alt="user profile image">
                </div>
                <div class="pull-left meta">
                    <div class="title h5">
                        <a href="/user/${taskOwner.id}"><b>${taskOwner.name}</b></a>
                        предложил работу:
                    </div>
                    <h6 class="text-muted time"><i class="fa fa-clock-o"></i>
                        <fmt:formatDate pattern="yyyy-MM-dd H:m" value="${task.dateAdded}"/></h6>
                    <h6 class="text-muted time"><i class="fa fa-money"></i> ${task.price}</h6>
                </div>
            </div>
            <div class="post-description">
                ${task.description}
            </div>
            <div class="post-footer">
                <b> Претенденты: </b>
                    <ul class="comments-list">
                        <tr>
                            <c:forEach items="${requestList}" var="request">
                                <li class="comment panel-shadow panel-white">

                                    <a class="pull-left" href="/user/${request.userId}">
                                        <img class="avatar" src="http://bootdey.com/img/Content/user_1.jpg"
                                             alt="avatar">
                                    </a>

                                    <div class="comment-body">
                                        <a class="btn btn-success pull-right" href="/task/acceptrequest/${task.id}/${request.id}">Принять запрос <em class="fa fa-check-square-o"></em></a>
                                        <div class="comment-heading">
                                            <div class="title h4"><a
                                                    href="/user/${request.userId}"> ${request.userName} </a></div>
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
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication var="principal" property="principal" />
                    <c:if test="${taskOwner.login != principal.username}">
                    <button type="button" class="btn btn-primary">Оставить заявку <i class="fa fa-caret-square-o-down"></i>
                    </button>
                    <div class="collapse">
                            <div class="form-area">
                                <form role="form" action="/sendrequest" method="post" commandName="request">
                                    <br style="clear:both">
                                    <div class="form-group">
                                        <textarea class="form-control" name="comment" type="textarea" id="message" placeholder="Оставьте комментарий к заявке" maxlength="140" rows="7"></textarea>
                                        <input type="hidden" name="taskId" value="${task.id}"/>
                                        <span class="help-block"><p id="characterLeft" class="help-block ">Вы достигли лимита</p></span>
                                    </div>
                                    <button id="btn-login" type="submit" class="btn btn-success">Отправить запрос <i class="fa fa-sign-in"></i></button>
                                </form>
                            </div>
                    </div>
                    </c:if>
                </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
