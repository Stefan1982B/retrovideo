<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head>
<title>retrovideo</title>
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='icon' href='images/retrovideo.ico' type='image/x-icon'>
<link rel='stylesheet' href='css/retrovideo.css'>
</head>
<body>
	<c:url value='/' var='url' />
	<a href='${url}'>Reserveren</a>

	<h1>Reserveren</h1>
	<c:forEach var='genre' items='${genres}'>
		<li>${genre}</li>
	</c:forEach>

</body>
</html>