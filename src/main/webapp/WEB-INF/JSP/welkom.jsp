<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>

<!doctype html>
<html lang='nl'>
<head>
<title>retro video</title>
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
				<li><spring:url value='/{genreId}' var='url'>
						<spring:param name='genreId' value='${genre.id}' />
					</spring:url> <a href='${url}'>${genre.naam}</a></li>
			</c:forEach>
		</ul>
	</nav>
	<c:if test='${not empty genreFilms}'>
		<ul>
			<c:forEach var='genreFilm' items='${genreFilms}'>
				<spring:url value='/film/{id}' var='url'>
					<spring:param name='id' value='${genreFilm.id}' />
				</spring:url>
				<a href='${url}'>
				<img
					title='${genreFilm.titel}  ${genreFilm.gereserveerd < genreFilm.voorraad? "reservatie mogelijk" : "reservatie niet mogelijk"}'
					src="images/${genreFilm.id}.jpg" alt="${genreFilm.titel}">
					</a>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>