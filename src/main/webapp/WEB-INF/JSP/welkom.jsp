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
	<nav>
		<ul>
			<c:forEach var='genre' items='${genres}'>
				<li><c:url value='/' var='url'>
						<c:param name='id' value='${genre.id}' />
					</c:url> <a href='${url}'>${genre.naam}</a></li>
			</c:forEach>
		</ul>
	</nav>


	<c:if test='${empty genreFilms}'>
		<h1>Pizza niet gevonden</h1>
	</c:if>
	<c:if test='${not empty genreFilms}'>
		<c:forEach var='genreFilm' items='${genreFilms}'>
			<h1>${genreFilm.titel}</h1>
		</c:forEach>
	</c:if>
</body>
</html>