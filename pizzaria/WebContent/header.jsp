<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="css/materialize.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" href="css/main.css">
<!-- Compiled and minified JavaScript -->

</head>
<div class="content">
	<nav>
		<div class="nav-wrapper main-menu">
			<a href="" class="brand-logo">Logo</a> <a href="index.jsp"
				data-target="mobile-demo" class="sidenav-trigger"> <i
				class="material-icons">dehaze</i></a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="index.jsp">home</a></li>
				<li><a href="cardapio.jsp">cardapio</a></li>
				<li><a href="pedido.jsp">Monte seu pedido</a></li>
				<li><a href="carrinho.jsp">carrinho</a></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
					href="login.jsp">login</a></li>
			</ul>
		</div>
	</nav>

	<ul class="sidenav" id="mobile-demo">

		<li><a href="">home</a></li>
		<li><a href="">cardapio</a></li>
		<li><a href="">Monte seu pedido</a></li>
		<li><a href="">carrinho</a></li>
		<li><a class="waves-effect waves-light btn modal-trigger"
			href="#modal1">login</a></li>

	</ul>
<div class="clear"></div>
</div>
	