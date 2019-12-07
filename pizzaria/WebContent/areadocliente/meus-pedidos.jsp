<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/side-bar-admin.css">
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
	<!-- <nav> -->
	<!-- 		<a href="#" data-target="slide-out" class="sidenav-trigger"><i -->
	<!-- 			class="material-icons">menu</i></a> -->
	<!-- 		<div class="nav-wrapper main-menu"> -->

	<!-- 			<ul id="nav-mobile" class="right hide-on-med-and-down"> -->



	<!-- 			</ul> -->
	<!-- 		</div> -->
	<!-- 	</nav> -->

	<div class="col s12 content-fix ">
	
	<nav>
	
		<a href="#" data-target="slide-out" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
		<div class="nav-wrapper main-menu">

			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="../index?acao=index">home</a></li>
				<li><a href="cardapio.jsp">cardapio</a></li>
				<li><a href="../montaPizza.jsp">Monte seu pedido</a></li>
				<li><a href="index?acao=meus-pedidos"> Meus pedidos</a></li>
				<li><a href="index?acao=meus-pedidos"><b>bem vindo ${id.nome}!</b></a></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
					href="entrar.jsp">sair</a></li>
					
			</ul>
		</div>
	</nav>
		
	<ul class="sidenav	" id="mobile-demo">

		<li><a href="">home</a></li>
		<li><a href="">cardapio</a></li>
		<li><a href="">Monte seu pedido</a></li>
		<li><a href="">carrinho</a></li>
		<li><a class="waves-effect waves-light btn modal-trigger"href="#modal1">login</a></li>

	</ul>
	<div class="clear"></div>
</div>
	

	<div class="content bg-red-sal">
		<section class="side-content ">
			<div class="row">
				<h1 align="center">Meus Pedidos</h1>
				<table>
					<tr>
						<td>Pedido</td>
						<td>Status</td>
						<td>Detelhes</td>
					</tr>
					<c:forEach items="${pedidos}" var="pedido">
					<tr>
						<td>${pedido.idPedido }</td>	
						<td>${pedido.dataPedido }</td>	
						<td>${pedido.tipo} ${pedido.nomeProduto}</td>	
						<td>${pedido.quantidade }</td>						
					</tr>
					</c:forEach>
				</table>

			</div>

		</section>
		<div class="clear"></div>
	</div>
	
	

	<jsp:include page="../imports/footer.jsp" />

	
	<script>
		$('.navbar-fixed').attr('class', 'navbar');
	</script>

</body>
</html>