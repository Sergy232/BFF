<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String licensetype = (String) session.getAttribute("licenseType");

   //userInfo[5] --> licensetype;%>
 
<html>
	<head>
		<title>Lizentzia mota aldatzeko menua</title>
		<link href="/BFF/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>BFF Bizkaiko Futbol Federazioa</h1>
			<h3>Lizentzia mota aldatzeko menua</h3>
		</header>
		<section>
			<a href="/BFF/servlet/MainServlet" style="text-decoration: none">
				<font color="white">Menu nagusira joan</font>
			</a>
		</section>			
		<section>
			<form method="POST" action="/BFF/servlet/LizEguneratuServlet">
				<table>
	   				<tr>
	   					<td>Lizentzia Mota:</td>
	   				<td><select name="licensetype" required="required" value="<%=licensetype%>">
  						<option value="Paquete">Paquete</option>
  					    <option value="Cojo">Cojo</option>
  					    <option value="Veneno">Veneno</option>
  					    <option value="Tuercebotas">Tuercebotas</option></select> </td>
	   				</tr>				
	 			</table>
				<button>Aldatu</button>
			</form>
		</section>	
		<footer>Web Sistemak - Sergio Pascual</footer>	
	</body>
</html>