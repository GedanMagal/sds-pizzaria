<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!-- Compiled and minified CSS -->

<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<link rel="stylesheet" href="../css/side-bar-admin.css">
	<script type="text/javascript">
	function toggleSidebar() {
		document.getElementById('sidebar').classList.toggle('active');
	}
	
	</script>
</head>


<nav id="sidebar">
<figure><img width="120px" height="90px" alt="logo" src="../img/logo.png"> </figure>
	<ul>
		<li><a href="relatorio-pedidos.jsp">Relatório</a></li>
		<li><a href="gerenciar-estoque.jsp">Gerenciar Estoque</a></li>
		<li><a href="gerenciar-produto.jsp">Gerneciar Produto</a></li>
		<li><a href="cadastrar-cliente.jsp">Gerenciar Clientes</a></li>
		<li><a href="login.jsp">Sair</a></li>
	</ul>
	<div class="toggle-btn" onclick="toggleSidebar()">
		<span></span>
		<span></span>
		<span></span>
	</div>

</nav>

