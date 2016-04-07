<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu nagusia</title>
<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
	<header>
	<h1>BFF Bizkaiko Futbol Federazioa</h1>
	<h3>Menu Nagusia</h3>
	</header>
	<% if (request.getAttribute("ezezaguna")!=null) { 
		if ((boolean) request.getAttribute("ezezaguna")) { %>
		<section>
			<h2> Ez da ulertu eskakizuna</h2>
		</section>
	<% }} %>
	<% if (request.getAttribute("eragiketaOndo")!=null) { 
		if ((boolean) request.getAttribute("eragiketaOndo")) { %>
		<section>
			<h2> Ondo bete da eskakizuna</h2>
		</section>
	<% }} %>
	<section>
		<table>
			<tr>
				<td><a href="/BFF/jsp/pasahitzaAldatu.jsp">Pasahitza aldatu</a></td>
			</tr>
			<tr>
				<td><a href="/BFF/jsp/erabInforEguneratu.jsp">Erabiltzailearen informazioa eguneratu</a></td>
			</tr>
			<tr>
				<td><a href="/BFF/jsp/lizMotaAldatu.jsp">Lizentzia mota aldatu</a></td>
			</tr>
			<tr>
				<td><a href="/BFF/servlet/LizentziaServlet">Lizentzia lortu</a></td>
			</tr>
			<tr>
				<td><a href="/BFF/servlet/MainServlet?action=logout">Sesioa amaitu</a></td>
			</tr>
		</table>
	</section>
	<footer>Web Sistemak - Sergio Pascual</footer>
</body>
</html>