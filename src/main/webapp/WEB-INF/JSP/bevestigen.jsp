<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
 <vdab:head title='bevestigen'/> 
</head>
<body>
	<vdab:menu/>
	<h1>bevestigen</h1>
	<p>${mandje.size()}film(s)voor${klant.voornaam}
		${klant.familienaam}</p>
	<spring:url value='/klant/{klantId}/bevestigd' var='url'>
		<spring:param name='klantId' value='${klant.id}' />
	</spring:url>
	<form:form action='${url}' modelAttribute='reservatie' method='post'
		id='bevestigenform'>
		<input type='submit' value='Bevestigen' id='toevoegknop'>
	</form:form>

	<script>
		document.getElementById('bevestigenform').onsubmit = function() {
			document.getElementById('toevoegknop').disabled = true;
		};
	</script>
</body>
</html>