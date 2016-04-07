<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.ArrayList" %>
<% String licensetype = (String) session.getAttribute("licensetype");
	ArrayList<String> lizentziak = new ArrayList<String>();
	
	lizentziak.add("Paquete");
	lizentziak.add("Cojo");
	lizentziak.add("Veneno");
	lizentziak.add("Tuercebotas");
	
	lizentziak.remove(licensetype);%>
 
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
			<form method="POST" action="/BFF/servlet/InforEguneratuServlet">
				<table>
	   				<tr>
	   					<td>Lizentzia Mota:</td>
	   				<td><select name="licensetype" required="required" >
  						<option value="<%=licensetype%>"><%=licensetype%></option>
  					    <option value="<%=lizentziak.get(0)%>"><%=lizentziak.get(0)%></option>
  					    <option value="<%=lizentziak.get(1)%>"><%=lizentziak.get(1)%></option>
  					    <option value="<%=lizentziak.get(2)%>"><%=lizentziak.get(2)%></option></select> </td>
	   				</tr>				
	 			</table>
				<button>Aldatu</button>
			</form>
		</section>	
		<footer>Web Sistemak - Sergio Pascual</footer>	
	</body>
</html>