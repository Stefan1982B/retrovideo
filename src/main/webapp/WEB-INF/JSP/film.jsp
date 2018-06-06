<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title='film'/> 
</head>
<body>
<vdab:reserveren/> 

	<c:if test='${empty film}'>
		<h1>film niet gevonden</h1>
	</c:if>
	<c:if test='${not empty film}'>
		<h1>${film.titel}</h1>
		<img src=<c:url value ="/images/${film.id}.jpg"/> alt="${film.titel}">
		<dl>
			<dt>Prijs</dt>
			<dd>
				<spring:eval expression='film.prijs' />
			</dd>
			<dt>Voorraad</dt>
			<dd>${film.voorraad}</dd>
			<dt>Gereserveerd</dt>
			<dd>${film.gereserveerd}</dd>
			<dt>Beschikbaar</dt>
			<dd>${film.gereserveerd < film.voorraad ? 'ja' : 'nee'}</dd>
		</dl>
		<c:if test='${film.gereserveerd < film.voorraad}'>
			<spring:url value='/film/{id}' var='url'>
				<spring:param name='id' value="${film.id}" />
			</spring:url>
			<form:form action='${url}' modelAttribute='mandjeForm' method='post' id='mandjeform'>
				<input type='submit' value='Mandje' id='toevoegknop'>
			</form:form>
		</c:if>
	</c:if>
	
		<script>
		document.getElementById('mandjeform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
	</script>
</body>
</html>