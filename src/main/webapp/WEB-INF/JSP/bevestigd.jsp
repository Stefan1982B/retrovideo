<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bevestigd</title>
<link rel='icon' href='<c:url value="/images/retrovideo.ico"/>'
	type='image/x-icon'>
<link rel='stylesheet' href='<c:url value="/css/retrovideo.css"/>'>
</head>
<body>
	<nav>
	<ul>
		<li><a href="<c:url value='/'/>">Reserveren</a></li>
	</ul>
	</nav>
	<h1>Rapport</h1>
	  <c:if test='${empty filmTitels}'>      
	<p>De Reservatie is OK</p>
	</c:if>
  <c:if test='${not empty filmTitels}'>
  <p>De Reservatie is niet OK, volgende titels zijn niet op voorraad:</p>
	<ul>
		<c:forEach items='${filmTitels}' var='filmTitel'>
			<li><c:out value='${filmTitel}' /></li>
		</c:forEach>
	</ul>
	</c:if>

</body>

</html>