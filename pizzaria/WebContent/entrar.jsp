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
			<div class="row form-log">
			<jsp:include page="imports/msg.jsp" />
				<form class="col s8 " method="post" action="client?acao=loginCliente">
					<h3>login</h3>
 					<input type="hidden" name="user" value="cliente"> 
					<div class="row">
						<div class="input-field col s12">
							<input type="text" name="usuario" id="emailLogin"> <label
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
					
					
					
						
							<a class="btn waves-effect waves-light" href="cliente?acao=listaEstado&param=cliente">
								Cadstre-se <i class="material-icons right">send</i>
							</a>
						</div>
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
	<script src="js/getLocation.js"></script>

</body>
</html>