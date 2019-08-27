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

				<form class="col s5 form-log" method="post" action="index.jsp">
					<h3>Já possuo cadastro</h3>

					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="emailLogin" id="emailLogin"> <label
								class="active" for="emailLogin">E-Mail</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input type="password" name="senha" id="senha"> <label
								class="active" for="senha">Senha</label>
						</div>
					</div>

					<input type="hidden" name="acao" value="Login">

					<div class="row">
						<div class="col s12">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								login <i class="material-icons right">send</i>
							</button>
						</div>
					</div>

					<div class="row">
						<div class="col s12">
							<p>
								Caso tenha esquecido seu Usuário clique<strong> <a
									class="modal-trigger" href="#modal1"> aqui</a></strong>
							</p>
						</div>
					</div>

				</form>

				<form class="col s5 offset-s1 form-log" method="post"
					action="index.jsp">
					<h3>Cadastre-se</h3>

					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="nome" id="nome"> <label
								class="active" for="nome">Nome</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="text" name="cpf" id="cpf" class="cpf"> <label
								class="active" for="cpf">CPF</label>
						</div>
						<div class="input-field col s6">
							<input type="text" name="dataNascimento" class="datepicker"
								placeholder="Data de Nascimento">
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="text" name="telefone" id="telefone"> <label
								class="active" for=""telefone "">Telefone</label>
						</div>
						<div class="input-field col s6">
							<input type="text" name="celular" id="celular"> <label
								class="active" for="celular">Celular</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s4">
							<input type="text" name="cep" id="cep"> <label
								class="active" for="cep">CEP</label>
						</div>
						<div class="input-field col s8">
							<input type="text" name="complemento" id="complento"> <label
								class="active" for="complemento">Complemento</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s8">
							<input type="text" name="logradouro" id="logradouro"> <label
								class="active" for="logradouro">Logradouro/rua</label>
						</div>
						<div class="input-field col s4">
							<input type="text" name="numero" id="numero"> <label
								class="active" for="numero">Número</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input type="password" name="senha" id="senha"> <label
								class="active" for="senha">Senha</label>
						</div>
						<div class="input-field col s6">
							<input type="password" name="repetirSenha" id="repetirSenha">
							<label class="active" for="repetirSenha">Repetir a Senha</label>
						</div>
					</div>

					<div class="row">
						<div class="col s12">
							<button class="btn waves-effect waves-light" type="submit"
								name="action">
								Cadastrar <i class="material-icons right">send</i>
							</button>
						</div>
					</div>



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