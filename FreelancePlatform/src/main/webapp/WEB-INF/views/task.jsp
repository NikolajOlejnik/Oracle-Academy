<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="task">

	<table>
		<tr>
			<td><form:label path="description">
				<spring:message code="label.description" />
			</form:label></td>
			<td><form:input path="description" /></td>
		</tr>
		<tr>
			<td><form:label path="price">
				<spring:message code="label.price" />
			</form:label></td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addtask"/>" /></td>
		</tr>
	</table>
</form:form>

<h3><spring:message code="label.tasks" /></h3>
<c:if test="${!empty taskList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.description" /></th>
			<th><spring:message code="label.date" /></th>
			<th><spring:message code="label.price" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${taskList}" var="task">
			<tr>
				<td>${task.description}</td>
				<td>${task.date}</td>
				<td>${task.price}</td>
				<td><a href="delete/${task.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<form id="searchbox" method="post" action="searchbydescription">
	<input id="search" type="text" placeholder="Type here">
	<input id="submit" type="submit" value="Search">
</form>

</body>
</html>