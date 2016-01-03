<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar POIs Próximos</title>
</head>
<body>
	
	<form action="ListProximityServlet" method="POST">
		<table>	  	   
	  	   <tr>
	  	   	<td>Coordenada X:</td>
	  	   	<td><input type="text" name="x" ></td>
	  	   </tr>
	  	   <tr>
	  	   	<td>Coordenada Y:</td>
	  	   	<td><input type="text" name="y" ></td>
	  	   </tr>
	  	   <tr>
	  	   	<td>Distância máxima em metros:</td>
	  	   	<td><input type="text" name="distance"></td>
	  	   </tr>
	  	   <tr>
	  	    <td><input type="submit" value="Listar"></td>
	  	   </tr>
	  	</table>
	</form>
	
</body>
</html>
