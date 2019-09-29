 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/cadastrar-cliente.css">
</head>
<body>
	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
	<form action="admin?acao=cadastrarProduto" method="POST">
		<div class="col s9 offset-s6">
			<h4>Produto</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="descricao" id="descricao"> <label
					class="active" for="descricao">Descrição</label>
			</div>
			<div class="input-field col s6">
			<select name="tipo">
				<option value="0">Selecione </option>
				<option value="1">Bebida </option>
				<option value="2">Pizza </option>
			</select>
			<label
					class="active" for="tipo">Tipo</label>
			</div>

		</div>

		<div class="row">
			<div class="input-field col s6">
				<select name="tamanho">
				<option value="0">Selecione </option>
				<option value="600ml">600ml </option>
				<option value="2 litros">2 litros </option>
			</select>
				
			</div>
			<div class="input-field col s6">
				<input type="text" name="valor" id="valor"> <label
					class="active" for="valor">Valor</label>
			</div>
		</div>
		<div class="row">
		<div class="input-field col s6">
				<input type="text" name="quantidade" id="quantidade"> <label
					class="active" for="quantidade">Quantidade</label>
			</div>
			<div class="input-field col s6">
				<input type="text" name="sabor" id="sabor"> <label
					class="active" for="sabor">Sabor</label>
			</div>
			</div>
		<div class="row">
			<div class="col s3 offset-s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Limpar <i class="material-icons right">clear</i>
				</button>
			</div>
			<div class="col s3">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Salvar <i class="material-icons right">send</i>
				</button>

			</div>
		</div>
		</form>
	</div>

	
	<jsp:include page="imports/footer-admin.jsp" />


</body>


</html>