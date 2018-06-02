<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mandje</title>
<link rel='icon' href='images/retrovideo.ico' type='image/x-icon'>
<link rel='stylesheet' href='css/retrovideo.css'>
</head>
<body>
	<nav>
	<ul>
		<li><c:url value='/' var='url' /> <a href='${url}'>Reserveren</a>
		</li>
		<li><c:url value='/mandje' var='url' /> <a href='${url}'>Mandje</a>
		</li>
		<li><c:url value='/klant' var='url' />
		<a href='${url}'>Klant</a>
		</li>
		</ul>
</nav>
	<h1>Mandje</h1>
		<c:if test='${empty filmsInMandje}'>
		<h2>mandje niet gevonden</h2>
			</c:if>
	<c:if test='${not empty filmsInMandje}'>
		<table id="tabel">
		<tr>
		<th>Film</th>
		<th>Prijs</th>
		<th>Verwijderen</th>
		</tr>
			<c:forEach items='${filmsInMandje}' var='film'>
			<tr>
				<td><c:out value='${film.titel}' /></td>
				<td class="prijs"><c:out value='${film.prijs}' /></td>
				<td><input type='checkbox' name='verwijderFilm' value='${film.id}'></td>
				</tr>
			</c:forEach>
			<tr>
			</tr>
		</table>
	</c:if>
	      <script language="javascript" type="text/javascript">
            var tds = document.getElementById('tabel').getElementsByTagName('td');
            var sum = 0;
            for(var i = 0; i < tds.length; i ++) {
                if(tds[i].className == 'prijs') {
                    sum += parseFloat(tds[i].innerHTML);
                }
            }
            document.getElementById('tabel').innerHTML += '<tr><td><h4>totaal</h4></td>' +'<td><h4>' +"€" + sum + '</h4></td></tr>' ;
        </script>
</body>
</html>