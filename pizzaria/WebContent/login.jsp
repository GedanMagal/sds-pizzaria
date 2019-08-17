<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<section class="content background-img">
		<div class="side-content">
			<div class="row">
				<form class="col s6 form-log">
					<h3>já possuo cadastro</h3>
					<input type="text" name="e-mail" placeholder="E-mail"> <input
						type="password" name="e-mail" placeholder="Senha"> <input
						type="button" value="entrar" class="btn">
				</form>
			

			<form class="col s6 form-log">
				<h3>cadastre-se</h3>
				
				<input type="text" name="e-mail" placeholder="Nome"> 
				<input type="text" name="e-mail" placeholder="cpf"> 
				<input type="text" name="e-mail" placeholder="data de Nascimento"> 
				<input type="text" name="e-mail" placeholder="senha"> 
				<input type="text" name="e-mail" placeholder="Repita a senha"> 
				<input type="text" name="e-mail" placeholder="cep"> 
				<input type="text" name="e-mail" placeholder="Logradouro/rua"> 
				<input type="text" name="e-mail" placeholder="n°"> 
				<input type="text" name="e-mail" placeholder="complento"> 
				<input type="button" value="cadastrar" class="btn">
			</form>
		</div>

			<div class="clear"></div>

		</div>
		<div class="clear"></div>
	</section>
	
	<jsp:include page="footer.jsp"/>
            
</body>
</html>