<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form:form method="post" action="searchbydescription" commandName="searchbydescription">

  <table>
    <tr>
      <td><form:label path="searchbydescription">
        <spring:message code="label.searchbydescription" />
      </form:label></td>
      <td><form:input path="searchbydescription" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="<spring:message code="label.send"/>" /></td>
    </tr>
  </table>
</form:form>
</body>
</html>
