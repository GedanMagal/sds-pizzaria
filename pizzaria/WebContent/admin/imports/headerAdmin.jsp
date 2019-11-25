<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<!-- Compiled and minified CSS -->

<link rel="stylesheet" href="css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"rel="stylesheet">
<link rel="stylesheet" href="css/side-bar-admin.css">
<link rel="stylesheet" href="css/main.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>


<div class="navbar-fixed">
	<nav>
		<div class="nav-wrapper">
			<div class="brand">
			<a href="#" class="brand-logo center">
			<img src="../img/LogoFinal.png" alt="logo"/>
			</a>
			</div>
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="#" data-target="slide-out" class="sidenav-trigger">
						<i class="material-icons">dehaze</i>
				</a></li>
			</ul>
			
			
			<a class="btn-sair right waves-effect waves-light btn modal-trigger"
				href="admin?acao=logout">SAIR</a>
	
		</div>
	</nav>
</div>

<ul id="slide-out" class="sidenav">
	<li>
		<div class="user-view">
			<div class="background">
				<img src="img/office.jpg">
			</div>
			<a href="#user"> <img class="circle" src="img/user.png">
			</a> <a href="#name"> <span class="white-text name">${id.idPessoa}</span>
			</a> <a href="#email"><span class="white-text email">${loginUser.login}</span></a>
		</div>
	</li>
	<li><a class="waves-effect" href="relatorio-pedidos.jsp"> <i
			class="material-icons">content_copy</i> Relatório
	</a></li>
	<li><div class="divider"></div></li>
	<li><a class="waves-effect" href="gerenciar-estoque.jsp"> <i
			class="material-icons">account_balance</i> Gerenciar Estoque
	</a></li>
	
	<li><a class="waves-effect" href="gerenciar-pedidos.jsp"> <i
			class="material-icons">local_grocery_store</i> Gerenciar Pedidos
	</a></li>
	<li><div class="divider"></div></li>
	<li><a class="waves-effect" href="admin?acao=listaprodutos"> <i
			class="material-icons">event_note</i> Gerenciar Produto
	</a></li>
	<li><a class="waves-effect" href="admin?acao=cadastrarSaborPizza"> <i
			class="material-icons">local_pizza</i> Gerenciar cardápio
	</a></li>
	
	<li><div class="divider"></div></li>
	<li><a class="waves-effect" href="admin?acao=listarClientes"> <i
			class="material-icons">assignment_ind</i> Gerenciar Clientes
	</a></li>
	<li><div class="divider"></div></li>
	<li><a class="waves-effect" href="gerenciar-funcionario.jsp"> <i
			class="material-icons">assignment_ind</i> Gerenciar Funcionario
	</a></li>
	
</ul>


