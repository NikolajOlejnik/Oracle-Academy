<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Freelance platform</title>

    <%--<style type="text/css">--%>
    <%--body {--%>
    <%--margin-top: 2%--%>
    <%--}--%>
    <%--</style>--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var activeSystemClass = $('.list-group-item.active');
            $('#system-search').keyup(function () {
                var that = this;
                var tableBody = $('.table-list-search tbody');
                var tableRowsClass = $('.table-list-search tbody tr');
                $('.search-sf').remove();
                tableRowsClass.each(function (i, val) {
                    var rowText = $(val).text().toLowerCase();
                    var inputText = $(that).val().toLowerCase();
                    if (inputText != '') {
                        $('.search-query-sf').remove();
                        tableBody.prepend('<tr class="search-query-sf"><td colspan="6"><strong>Ищем: "'
                        + $(that).val()
                        + '"</strong></td></tr>');
                    }
                    else {
                        $('.search-query-sf').remove();
                    }
                    if (rowText.indexOf(inputText) == -1) {
                        tableRowsClass.eq(i).hide();

                    }
                    else {
                        $('.search-sf').remove();
                        tableRowsClass.eq(i).show();
                    }
                });
                if (tableRowsClass.children(':visible').length == 0) {
                    tableBody.append('<tr class="search-sf"><td class="text-muted" colspan="6">Ничего не найдено :-( </td></tr>');
                }
            });
        });
    </script>

</head>

<body>
<jsp:include page="header.jsp"/>

<div class="container">


    <div class="row">

        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title"><b>Актуальные задания:</b></h3>

                        </div>

                        <div class="col col-xs-6 text-right">
                            <form class="navbar-form navbar-right" action="#" method="get">
                                <div class="input-group">
                                    <input class="form-control" id="system-search" name="q" placeholder="поиск"
                                           required>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="panel-body">

                    <table class="table table-list-search table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Добавлено</th>
                            <th>Задание</th>
                            <th>Оплата</th>
                            <th>Готовы выполнить?</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <c:forEach items="${taskList}" var="task">
                            <td width="150"><fmt:formatDate pattern="yyyy-MM-dd H:m" value="${task.dateAdded}"/></td>
                            <td>${task.title}</td>
                            <td>${task.price}</td>
                            <td><a href="/tasks/${task.id}" method="GET" class="btn btn-default center-block">Перейти на
                                страницу задания <i class="fa fa-caret-square-o-right"></i>
                            </a>
                            </td>

                        </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
