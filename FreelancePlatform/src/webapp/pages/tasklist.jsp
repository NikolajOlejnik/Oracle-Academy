<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>TaskList</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>

</head>
<body>
<table border="1" width="100%" cellpadding="5">
  <tr>
    <th>id</th>
    <th>price</th>
    <th>title</th>
    <th>description</th>
    <th>actions</th>
  </tr>
  <c:forEach items="${taskList}" var="task">
    <tr>
      <td>${task.id}</td>
      <td>${task.price}</td>
      <td>${task.title}</td>
      <td>${task.description}</td>
      <td>
        <form action="/delete/${task.id}" method="GET">
          <button type="submit">delete</button>
        </form><form action="/edit?id=${task.id}" method="GET">
        <button type="submit">edit</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>