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

 <section class="content">
	<div class="container">
		<div class="row col s12">
			
			<form class="login_form_admin">
					<div class="row">
					<div class="input-field col s12">
						<input placeholder="usuario" id="first_name" type="text"
							class="validate"> 
							
					</div>
					</div>
					<div class="row">
					<div class="input-field col s12">
						
						<input placeholder="senha" id="first_name" type="text"
							class="validate">
					</div>
					</div>
					<div class="row">
					<div class="input-field col s6">
						<input type="button" id="first_name" class="waves-light btn" value="log in">
					</div>
					</div>
					<p>Caso tenha esquecido seu Usuário clique aqui</p>
				</form>
		</div>	
	</div>

</section>
<jsp:include page="../footer.jsp"/>
</body>
</html>