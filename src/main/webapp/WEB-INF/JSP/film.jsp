<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>

</head>
<body>
	<c:url value='/' var='url' />
	<a href='${url}'>Reserveren</a>

	<c:if test='${empty films}'>
		<h1>film niet gevonden</h1>
	</c:if>
	<c:if test='${not empty films}'>
		<h1>${films.titel}</h1>
		<img src=<c:url value ="/images/${films.id}.jpg"/> alt="${films.titel}">
		<dl>
			<dt>Prijs</dt>
			<dd>${films.prijs}</dd>
			<dt>Voorraad</dt>
			<dd>${films.voorraad}</dd>
			<dt>Gereserveerd</dt>
			<dd>${films.gereserveerd}</dd>
			<dt>Beschikbaar</dt>
			<dd>${films.gereserveerd < films.voorraad ? 'ja' : 'nee'}</dd>
		</dl>
		<c:if test='${films.gereserveerd < films.voorraad}'>
			<spring:url value='/film/{id}' var='url'>
			   <spring:param name='id' value="${films.id}"/>  
			    </spring:url> 
			<form:form action='${url}' modelAttribute='mandjeForm' method='post'>
				<input type='submit' value='Mandje'>
			</form:form>
		</c:if>
	</c:if>
</body>
</html>