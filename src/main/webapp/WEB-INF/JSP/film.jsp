<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<title>film</title>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='icon' href='<c:url value="/images/retrovideo.ico"/>' type='image/x-icon'>
<link rel='stylesheet' href='<c:url value="/css/retrovideo.css"/>'>
</head>
<body>
	<c:url value='/' var='url' />
	<a href='${url}'>Reserveren</a>

	<c:if test='${empty film}'>
		<h1>film niet gevonden</h1>
	</c:if>
	<c:if test='${not empty film}'>
		<h1>${film.titel}</h1>
		<img src=<c:url value ="/images/${film.id}.jpg"/> alt="${film.titel}">
		<dl>
			<dt>Prijs</dt>
			<dd><spring:eval expression='film.prijs'/></dd>
			<dt>Voorraad</dt>
			<dd>${film.voorraad}</dd>
			<dt>Gereserveerd</dt>
			<dd>${film.gereserveerd}</dd>
			<dt>Beschikbaar</dt>
			<dd>${film.gereserveerd < film.voorraad ? 'ja' : 'nee'}</dd>
		</dl>
		<c:if test='${film.gereserveerd < film.voorraad}'>
			<spring:url value='/film/{id}' var='url'>
			   <spring:param name='id' value="${film.id}"/>  
			    </spring:url> 
			<form:form action='${url}' modelAttribute='mandjeForm' method='post'>
				<input type='submit' value='Mandje'>
			</form:form>
		</c:if>
	</c:if>
</body>
</html>