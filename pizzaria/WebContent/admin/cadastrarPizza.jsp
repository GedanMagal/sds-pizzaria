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
		<div class="col s9 offset-s6">
			<h4>Cadastro de pizza</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="nomeproduto" id="nomeproduto" > <label
					class="active" for="nomeproduto">Nome pizza</label>
			</div>
			<div class="input-field col s6">
				<select>
					<option value="0">Escolha o tamanho</option>
					<option value="Broto">Broto</option>
					<option value="8 pedacos">8 pedaços</option>
				</select>
			</div>

		</div>

		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="tamanho" id="tamanho"> <label
					class="active" for="tamanho">Tamanho</label>
			</div>
			<div class="input-field col s6">
				<input type="text" name="valor" id="valor"> <label
					class="active" for="valor">Valor</label>
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
	</div>


	<jsp:include page="imports/footer-admin.jsp" />


</body>


</html>