<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
<vdab:head title='mandje'/> 
</head>
<body>
<vdab:menu/>
	<h1>Mandje</h1>
	<c:if test='${empty filmsInMandje}'>
		<h2>mandje is leeg</h2>
	</c:if>
	<c:if test='${not empty filmsInMandje}'>
		<c:url value='/mandje' var='url' />
		<form action='${url}' method='post' id='mandjeform'>
			<table id="tabel">
				<tr>
					<th>Film</th>
					<th>Prijs</th>
					<th><input type='submit' value='Verwijderen' id='verwijderknop'></th>
				</tr>
				<c:forEach items='${filmsInMandje}' var='film'>
					<tr>
						<td><c:out value='${film.titel}' /></td>
						<td class="prijs"><spring:eval expression='film.prijs' /></td>
						<td><input type='checkbox' name='verwijderid'
							value='${film.id}'></td>
					</tr>
				</c:forEach>
				<tr>
				<td>Totaal:</td>
				<td><spring:eval expression= 'totalePrijs.waarde' /></td>
				</tr>
			</table>
			</form>
	</c:if>
	
		<script>
		document.getElementById('mandjeform').onsubmit = function() {
			document.getElementById('verwijderknop').disabled = true;
		};
	</script>
</body>
</html>