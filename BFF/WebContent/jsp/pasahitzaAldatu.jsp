<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Pasahitza Aldatu</title>
		<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>BFF Bizkaiko Futbol Federazioa</h1>
			<h3>Pasahitza aldatzeko menua</h3>
		</header>
		<% if (request.getAttribute("different_pswds")!=null) { 
		if ((boolean) request.getAttribute("different_pswds")) { %>
		<section>
			<h2> Sartu pasahitz berdinak!</h2>
		</section>
		<% }} %>
		<% if (request.getAttribute("pswdTxarto")!=null) { 
		if ((boolean) request.getAttribute("pswdTxarto")) { %>
		<section>
			<h2> Sartutako pasahitza ez da egokia!</h2>
		</section>
		<% }} %>
		<section>
			<a href="/BFF/servlet/MainServlet" style="text-decoration: none">
				<font color="white">Menu Nagusira joan</font>
			</a>
		</section>			
		<section>
			<form method="POST" action="/BFF/servlet/PasahitzaAldatuServlet">
				<table>
	   				<tr>
	   					<td>Pasahitz Zaharra:</td>
	   					<td><input type="password" name="zaharra"></td>
	   				</tr>
	   				<tr>
	   					<td>Pasahitz berria:</td>
	   					<td><input type="password" name="berria"></td>
	   				</tr>
	   				<tr>
	   					<td>Errepikatu berria:</td>
	   					<td><input type="password" name="berria2"></td>
	   				</tr>
	 			</table>
				<button>Aldatu</button>
			</form>
		</section>
		<section>
			<a href="/BFF/servlet/MainServlet?action=logout" style="text-decoration: none">
			<font color="white">Sesioa amaitu</font>
		</a>
		</section>	
		<footer>Web Sistemak - Sergio Pascual</footer>
	</body>
</html>