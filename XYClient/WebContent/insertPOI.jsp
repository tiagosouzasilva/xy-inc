<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar POI</title>
</head>
<body>
	
	<form action="InsertPOIServlet" method="POST">
		<table>
	  	   <tr>
	  	   	<td>Nome do POI:</td>
	  	   	<td><input type="text" name="name" maxlength="200" placeholder="Digite aqui o nome do ponto de interesse" width="500"></td>
	  	   </tr>
	  	   <tr>
	  	   	<td>Coordenada X:</td>
	  	   	<td><input type="text" name="x" ></td>
	  	   </tr>
	  	   <tr>
	  	   	<td>Coordenada Y:</td>
	  	   	<td><input type="text" name="y" ></td>
	  	   </tr>
	  	   <tr>
	  	    <td><input type="submit" value="Cadastrar"></td>
	  	   </tr>
	  	</table>
	</form>
	
</body>
</html>

