<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kautotu</title>
<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
</head>
<body>
		<header>
			<h1>BFF</h1>
			<h3>Bizkaiko Futbol Federazioa</h3>
		</header>
		<% if (request.getAttribute("login_error")!=null) { 
		if ((boolean) request.getAttribute("login_error")) { %>
		<section>
			<h2> Ezin da sesioa hasi!</h2>
		</section>
		<% }} %>
		<% if (request.getAttribute("ok")!=null) { 
		if ((boolean) request.getAttribute("ok")) { %>
		<section>
			<h2> Erabiltzailea ondo sortu da</h2>
		</section>
		<% }} %>
		<section>
			<form method="POST" action="/BFF/servlet/LoginServlet">
				<table>
	   				<tr>
	   					<td>Erabiltzailea:</td>
	   					<td><input name="username"/></td>
	   				</tr>
	   				<tr>
	   					<td>Pasahitza:</td>
	   					<td><input type="password" name="pswd"/></td>
	   				</tr>
	 			</table>
				<button>Sartu</button>
			</form>
		</section>
		<section>
			<a href="/BFF/jsp/newSignUpForm.jsp" style="text-decoration: none">
				<font color="white">Kautotu</font>
			</a>
		</section>
		<footer>Web Sistemak - Sergio Pascual</footer> 
	</body>
</html>