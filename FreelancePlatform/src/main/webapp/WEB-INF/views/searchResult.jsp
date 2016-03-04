
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result</title>
</head>
<body>
<c:if test="${!empty searchResult}">
  <table class="data">
    <tr>
      <th><spring:message code="label.description" /></th>
      <th><spring:message code="label.date" /></th>
      <th><spring:message code="label.price" /></th>
      <th>&nbsp;</th>
    </tr>
  </table>
</c:if>
</body>
</html>
