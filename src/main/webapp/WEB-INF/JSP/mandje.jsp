<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mandje</title>
<link rel='icon' href='<c:url value="/images/retrovideo.ico"/>'
	type='image/x-icon'>
<link rel='stylesheet' href='<c:url value="/css/retrovideo.css"/>'>
</head>
<body>
	<nav>
	<ul>
		<li><a href="<c:url value='/'/>">Reserveren</a></li>
		<li><a href="<c:url value='/mandje'/>">Mandje</a></li>
		<li><a href="<c:url value='/klant'/>">Klant</a></li>
	</ul>
	</nav>
	<h1>Mandje</h1>
	<c:if test='${empty filmsInMandje}'>
		<h2>mandje niet gevonden</h2>
	</c:if>
	<c:if test='${not empty filmsInMandje}'>
		<c:url value='/mandje' var='url' />
		<form action='${url}' method='post'>
			<table id="tabel">
				<tr>
					<th>Film</th>
					<th>Prijs</th>
					<th><input type='submit' value='Verwijderen'></th>
				</tr>
				<c:forEach items='${filmsInMandje}' var='film'>
					<tr>
						<td><c:out value='${film.titel}' /></td>
						<td class="prijs"><spring:eval expression='film.prijs' /></td>
						<td><input type='checkbox' name='verwijderid'
							value='${film.id}'></td>
					</tr>
				</c:forEach>
				<td>Totaal:</td>
				<td>€ ${totalePrijs }</td>
				<tr>
				</tr>
			</table>
	</c:if>
</body>
</html>