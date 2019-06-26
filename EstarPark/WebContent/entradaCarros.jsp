<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Entrada de carros</title>
<link rel="stylesheet" href="css/entrada.css">

</head>
<div id="conteudo" align="center">
	<form id="cadastro" action="cadastro" method="get">
		
			<label> Modelo: </label><input class="modelo" type="text" name="modelo"  placeholder="Gol"><br> <br> 
			<label> Marca: </label><input class="marca"  type="text" name="marca" placeholder="Volkswagem"><br><br> 
			<label> Cor: </label><input class="cor"  type="text" name="cor" placeholder="Branco" /><br> <br> 
			<label> Placa: </label><input class="placa"  type="text" name="placa" placeholder="AAX-2121" /><br>
			 <input class="button" type="submit" value="Enviar" width: 75px; height: 25px"/><br>
		
	</form>
</div>


</html>