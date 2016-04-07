<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erregistroa betetzeko orria</title>
<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
</head>
	<title>Erregistroa bete</title>
	<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
<body>
	<header>
		<h1>BFF Bizkaiko Futbol Federazioa</h1>
		<h3>Erregistroa bete</h3>
	</header>
	<% if (request.getAttribute("different_pswds")!=null) { 
		if ((boolean) request.getAttribute("different_pswds")) { %>
		<section>
			<h2> Sartu pasahitz berdinak!</h2>
		</section>
		<% }} %>
	<% if (request.getAttribute("user_exists")!=null) { 
		if ((boolean) request.getAttribute("user_exists")) { %>
		<section>
			<h2> Jada existitzen da erabiltzaile bat izen horrekin</h2>
		</section>
		<% }} %>
	<section>
		<a href="/BFF/jsp/newLoginForm.jsp" style="text-decoration: none">
			<font color="white">Atzera</font>
		</a>
	</section>
	<section>
		<form method="POST" action="/BFF/servlet/SignupServlet">
			<table>
				<tr>
	   				<td>Erabiltzailea:</td>
	   				<td><input name="username" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Pasahitza:</td>
	   				<td><input type="password" name="pswd" required="required"/></td>
	   			</tr>
	   			<tr>
	   				<td>Errepikatu pasahitza:</td>
	   				<td><input type="password" name="pswd2" required="required"/></td>
	   			</tr>
	   			<tr>
	   				<td>Email:</td>
	   				<td><input name="email" required="required"/></td>
	   			</tr>				
				<tr>
	   				<td>Izena:</td>
	   				<td><input name="firstname" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Abizenak:</td>
	   				<td><input name="lastnames" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Lizentzia Mota:</td>
	   				<td><select name="licensetype" required="required">
  						<option value="Paquete">Paquete</option>
  					    <option value="Cojo">Cojo</option>
  					    <option value="Veneno">Veneno</option>
  					    <option value="Tuercebotas">Tuercebotas</option></select> </td>
	   			</tr>
	   			<tr>
	   				<td>Herria:</td>
	   				<td><input name="address" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Telefonoa:</td>
	   				<td><input name="tlf" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>NAN:</td>
	   				<td><input name="nan" required="required"></td>
	   			</tr>
	 		</table>
			<button>Bidali</button>
		</form>
	</section>
	<footer>Web Sistemak - Sergio Pascual</footer> 
	</body>
</html>