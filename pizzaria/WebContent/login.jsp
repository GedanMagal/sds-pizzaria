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
	<jsp:include page="header.jsp" />
	<section class="content background-img">
		<div class="side-content">
			<div class="row">
				<form class="col s6 form-log" method="post"
					action="${linkEntradaServlet}">
					<h3>já possuo cadastro</h3>
					<input type="text" name="login" placeholder="E-mail" /> <input
						type="password" name="senha" placeholder="senha"> <input
						type="hidden" name="acao" value="Login">
						<button class="btn waves-effect waves-light" type="submit" name="action">login
    					<i class="material-icons right">send</i>
  					</button>
				</form>


				<form class="col s6 form-log" method="post"
					action="${linkEntradaServlet}">
					<h3>cadastre-se</h3>
					<input type="text" name="e-mail" placeholder="Nome"> 
					<inputtype="text" name="e-mail" placeholder="cpf"> 
					<inputtype="text" name="e-mail" placeholder="data de Nascimento">
					<input type="text" name="e-mail" placeholder="senha"> 
					<input type="text" name="e-mail" placeholder="Repita a senha"> 
					<input type="text" name="e-mail" placeholder="cep"> 
					<input	type="text" name="e-mail" placeholder="Logradouro/rua"> 
					<input type="text" name="e-mail" placeholder="n°"> 
					<input type="text" name="e-mail" placeholder="complento"> 
					<button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar
    					<i class="material-icons right">send</i>
  					</button>
				</form>
			</div>

			<div class="clear"></div>

		</div>
		<div class="clear"></div>
	</section>

	<jsp:include page="footer.jsp" />

</body>
</html>