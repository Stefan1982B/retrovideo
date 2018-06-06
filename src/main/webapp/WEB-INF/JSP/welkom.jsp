<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title='retro video'/> 
</head>
<body>
<vdab:reserveren/> 
	<h1>Reserveren</h1>
	<nav class="menu">
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
				<a href='${url}'> <img
					title='${genreFilm.titel}  ${genreFilm.gereserveerd < genreFilm.voorraad? "reservatie mogelijk" : "reservatie niet mogelijk"}'
					src="images/${genreFilm.id}.jpg" alt="${genreFilm.titel}">
				</a>
			</c:forEach>
		</ul>
	</c:if>
	<script>
		for (var i = 0; i < document.links.length; i++) {
			if (document.links[i].href == document.URL) {
				document.links[i].className = 'active';
			}
		}
	</script>
</body>
</html>