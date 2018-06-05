<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>klanten</title>
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
	<h1>Klanten</h1>

	<c:url value='/klant' var='url' />
	<form:form action='${url}' modelAttribute='deelNaamForm' method='get'
		id='deelnaamForm'>
		<form:label path='deelNaam'>Familienaam bevat: <form:errors
				path='deelNaam' />
		</form:label>
		<form:input path='deelNaam' autofocus='autofocus' required='required' />
		<input type='submit' value='Zoeken' id='zoekknop'>
	</form:form>
	<c:if test='${not empty klanten}'>
		<table>
			<tr>
				<th>Naam</th>
				<th>Straat - Huisnummer</th>
				<th>Postcode</th>
				<th>Gemeente</th>
			</tr>
			<c:forEach items='${klanten}' var='klant'>
				<tr>
					<td><spring:url value='/klant/{id}' var='url'>
							<spring:param name='id' value='${klant.id}' />
						</spring:url> <a href='${url}'><c:out
								value='${klant.familienaam} ${klant.voornaam}' /> </a></td>
					<td><c:out value='${klant.straatNummer}' /></td>
					<td><c:out value='${klant.postcode}' /></td>
					<td><c:out value='${klant.gemeente}' /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>
</body>
</html>