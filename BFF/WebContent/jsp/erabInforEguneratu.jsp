<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% String email = (String) session.getAttribute("email");
String firstname = (String) session.getAttribute("firstname");
String lastnames = (String) session.getAttribute("lastnames");
String address = (String) session.getAttribute("address");
String tlf = (String) session.getAttribute("tlf");
String dni = (String) session.getAttribute("dni");%>
   
<html>
	<head>
		<title>Erabiltzailearen informazioa eguneratzeko orria</title>
		<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>BFF Bizkaiko Futbol Federazioa</h1>
			<h3>Erabiltzailearen informazioa eguneratzeko orria</h3>
		</header>
		<section>
			<a href="/BFF/servlet/MainServlet" style="text-decoration: none">
				<font color="black">Menu nagusira joan</font>
			</a>
		</section>			
		<section>
			<form method="POST" action="/BFF/servlet/InforEguneratuServlet">
				<table>
	   			<tr>
	   				<td>Email:</td>
	   				<td><input name="email" required="required" value="<%=email %>"/></td>
	   			</tr>				
				<tr>
	   				<td>Izena:</td>
	   				<td><input name="firstname" value="<%=firstname %>" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Abizenak:</td>
	   				<td><input name="lastnames" value="<%=lastnames %>" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Herria:</td>
	   				<td><input name="address" value="<%=address %>" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>Telefonoa:</td>
	   				<td><input name="tlf" value="<%=tlf %>" required="required"></td>
	   			</tr>
	   			<tr>
	   				<td>NAN:</td>
	   				<td><input name="nan" value="<%=dni %>" required="required"></td>
	   			</tr>
	 			</table>
				<button>Eguneratu</button>
			</form>
		</section>	
		<footer>Web Sistemak - Sergio Pascual</footer>	 
	</body>
</html>