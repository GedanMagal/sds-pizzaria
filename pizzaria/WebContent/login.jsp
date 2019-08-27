<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="imports/header.jsp" />
	<section class="content background-img">
		<div class="side-content">
			<div class="row">
				<form class="col s6 form-log" method="post" action="index.jsp">
					<h3>já possuo cadastro</h3>
					<input type="text" name="login" placeholder="E-mail" /> <input
						type="password" name="senha" placeholder="senha"> <input
						type="hidden" name="acao" value="Login">
					<button class="btn waves-effect waves-light" type="submit"
						name="action">
						login <i class="material-icons right">send</i>
					</button>
					<p>
						Caso tenha esquecido seu Usuário clique<strong> <a
							class="modal-trigger" href="#modal1"> aqui</a></strong>
					</p>
				</form>
				<form class="col s6 form-log" method="post"
					action="index.jsp">
					<h3>cadastre-se</h3>
					<input type="text" name="e-mail" placeholder="Nome"> 
					<input type="text" name="e-mail" placeholder="cpf"> 
					<input type="text" name="e-mail" placeholder="data de Nascimento"> 
					<input type="text" name="e-mail" placeholder="telefone "> 
					<input type="text" name="e-mail" placeholder="celular"> 
					<input type="text" name="e-mail" placeholder="senha">
					 <input type="text"name="e-mail" placeholder="Repita a senha"> 
					 <input type="text" name="e-mail" placeholder="cep"> 
					 <input type="text" name="e-mail" placeholder="Logradouro/rua"> 
					 <input type="text" name="e-mail" placeholder="n°"> 
					 <input type="text" name="e-mail" placeholder="complento">
					<button class="btn waves-effect waves-light" type="submit" name="action">
						Cadastrar <i class="material-icons right">send</i>
					</button>
				</form>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</section>
	<div id="modal1" class="modal">
		<div class="modal-content">
			<h4>Modal Header</h4>
			<p>A bunch of text</p>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-close waves-effect waves-green btn-flat">Agree</a>
		</div>
	</div>
	<jsp:include page="imports/footer.jsp" />

</body>
</html>