<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html>
<head>
<vdab:head title='rapport'/> 
</head>
<body>
<vdab:reserveren/>
	<h1>Rapport</h1>
	<c:if test='${empty param.mislukteFilms}'>
		<p>De Reservatie is OK</p>
	</c:if>
	<c:if test='${not empty param.mislukteFilms}'>
		<p>Volgende reservatie(s) zijn mislukt:</p>
		<ul>
			<c:forEach items='${param.mislukteFilms}' var='filmTitel'>
				<li><c:out value='${filmTitel}' /></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>