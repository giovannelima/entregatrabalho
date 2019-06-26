<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="br.com.park.object.funcionarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	funcionarios fun = (funcionarios) session.getAttribute("usu");

	if (fun == null) {

		response.sendRedirect("login.jsp");
	}
%>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/Layouts.css">
<link rel="stylesheet" href="css/Menu.css">
</head>
<body>

	<header id="header">
		<div class="innertube">
			<h1>Sistema EstarPark</h1>
		</div>
	</header>

	<div id="wrapper">
		<menu>
			<div id="content">
				<div class="innertube">
					<iframe id="frame" name="conteudo"></iframe>
				</div>
			</div>
		</menu>


		<ul id="nav">
			<li><a href="listagem" target="conteudo">Home</a></li>
			<li><a href="entradaCarros.jsp" target="conteudo">Entrada</a></li>
			<li><a href="#">Saida</a></li>
			<li><a href="#">Ferramentas</a>
				<ul>
					<li><a href="">subMenu1</a></li>
					<li><a href="">subMenu2</a></li>
					<li><a href="">subMenu3</a></li>
					<li><a href="">subMenu4</a></li>

				</ul></li>
			<li><a href="#">Relatorios</a>
		</ul>


		<footer id="footer">
			<p class="bord">
				<%
					Date data = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					Date hora = Calendar.getInstance().getTime();
					SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
					String horas = sdf.format(hora);

					out.print("Usuario:" + request.getParameter("login"));
				%>
			</p>
		</footer>

	</div>
</body>
</html>