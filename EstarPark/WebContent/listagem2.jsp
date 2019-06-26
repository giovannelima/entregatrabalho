<%@page import="br.com.park.object.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventário</title>
<link rel="stylesheet" href="css/listagem.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>Codigo</th>
				<th>Modelo</th>
				<th>Marca</th>
				<th>Cor</th>
				<th>Placa</th>
				<th>Acao</th>
			</tr>
			<c:forEach var="park" items="${carros}">
				<tr>
					<td><c:out value="${park.id}" /></td>
					<td><c:out value="${park.modelo}" /></td>
					<td><c:out value="${park.marca}" /></td>
					<td><c:out value="${park.cor}" /></td>
					<td><c:out value="${park.placa}" /></td>
					<td><button class="buttonDelete" onclick="deletar()" type="button" value="deletar" name="delete	" />
					<button class="buttonAlterar"  type="button" value="deletar" name="delete" img	 /></td>
				</tr>
			</c:forEach>
		</table>
		
  <ul class="pagination" id="pag">
    <li><a href="listagem?pg=1">1</a></li>
    <li><a href="listagem?pg=2">2</a></li>
    <li><a href="listagem?pg=3">3</a></li>
    <li><a href="listagem?pg=4">4</a></li>
    <li><a href="listagem?pg=5">5</a></li>
  </ul>
</div>

</body>
</html>