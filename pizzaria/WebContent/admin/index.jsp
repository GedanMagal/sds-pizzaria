<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" href="../css/main.css">
</head>
<body>
<section class="container">
<div class="logo">
	<h1 class="ds-none">Smart pizza</h1>
</div>

			<div class="row col s12">

				<form class="login_form_admin" method="post" action="admin?acao=loginUser">
					<div class="row">
						<div class="input-field col s12">
							<input placeholder="Usu�rio" id="usuario" name="usuario" type="text"
								class="validate">
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">

							<input placeholder="Senha" id="senha" name="senha" type="text"
								class="validate">
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">							
								<button type="submit" id="entrar" class="waves-ligth btn">
								Entrar
								</button>
						</div>
					</div>
					<p>Caso tenha esquecido seu Usu�rio clique <a href="recuperacao-senha.jsp">aqui</a></p>
				</form>
			</div>
	</section>
</body>
</html>