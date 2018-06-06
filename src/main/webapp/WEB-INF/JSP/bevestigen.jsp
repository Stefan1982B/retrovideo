<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bevestigen</title>
<link rel='icon' href='<c:url value="/images/retrovideo.ico"/>'
	type='image/x-icon'>
<link rel='stylesheet' href='<c:url value="/css/retrovideo.css"/>'>
</head>
<body>
	<nav>
	<ul>
		<li><a href="<c:url value='/'/>">Reserveren</a></li>
		<li><a href="<c:url value='/mandje'/>">Mandje</a></li>
		<li><a href="<c:url value='/klant'/>">Klanten</a></li>
	</ul>
	</nav>
	<h1>bevestigen</h1>
	<p>${mandje.size()}film(s)voor${klant.voornaam}
		${klant.familienaam}</p>
	<spring:url value='/klant/{klantId}/bevestigd' var='url'>
		<spring:param name='klantId' value='${klant.id}' />
	</spring:url>
	<form:form action='${url}' modelAttribute='reservatie' method='post' id='bevestigenform'>
		<input type='submit' value='Bevestigen' id='toevoegknop'>
	</form:form>

	<script>
		document.getElementById('bevestigenform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
	</script>
</body>
</html>