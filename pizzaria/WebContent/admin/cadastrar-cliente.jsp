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
			<h4>Cliente</h4>
		</div>
		<h6>Dados Pessoais</h6>
		
		<form method="post" action="servlet?acao=salvarCliente">
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="nome" id="nome"> <label
					class="active" for="nome">Nome</label>
			</div>
			<div class="input-field col s6">
				<input type="text" name="sobrenome" id="sobrenome"> <label
					class="active" for="sobrenome">Sobrenome</label>
			</div>
			
		</div>
		
		<div class="row">
		<div class="input-field col s4">
				<input type="text" name="cpf" id="cpf"> <label
					class="active" for="cpf">CPF</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="telefone1" id="telefone1"> <label
					class="active" for="telefone1">Telefone 1</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="telefone2" id="telefone2"> <label
					class="active" for="telefone2">Telefone 2</label>
			</div>
			
		</div>
		
		<!--<div class="row">
			<div class="col s12">
				<p>
					<span class="gender">Sexo</span> <label> <input
						name="genero" type="radio" /> <span>Masculino</span>
					</label> <label> <input name="genero" type="radio" /> <span>Feminino</span>
					</label>
				</p>
			</div>
		</div>
		-->
		<div class="row">
			<div class="input-field col s9">
				<input type="email" name="email" id="email"> <label
					class="active" for="email">E-mail</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="senha" id="senha"> <label
					class="active" for="senha">Senha</label>
			</div>
		</div>
		
		<h6>Localização Endereço</h6>
		<div class="row">
					<div class="input-field col s3">
						<input type="text" name="cep" id="cep"> <label
							class="active" for="cep">CEP</label>
					</div>
					<div class="input-field col s4">
						<input type="text" name="bairro" id="bairro"> <label
							class="active" for="bairro">Bairro.</label>
					</div>
					<div class="input-field col s2">
						<select name="cidade" id="cidade">
						<option value="0">Selecione</option>
					
						</select><label class="active" for="cidade">Cidade</label>
					</div>
					<div class="input-field col s2">
						<select name="estado" id="estado" class="Sel">
							<option value="0">Selecione</option>
							<c:forEach items="${estados}" var="est">
							<option value="${est.idEstado}">${est.dsuf}</option>
							</c:forEach>
							</select> <label class="active" for="estado">Estado</label>
					</div>
				</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="logradouro" id="logradouro"> <label
					class="active" for="nome">Logradouro (Av. / R. / Pç.)</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="numero" id="numero"> <label
					class="active" for="nome">nº.</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="complemento" id="complemento"> <label
					class="active" for="complemento">Complemento</label>
			</div>
		</div>		
		<div class="row">
			<div class="input-field col s12">
				<input type="text" name="localReferencia" id="localReferencia">
				<label class="active" for="localReferencia">Local de Referência</label>
			</div>
		</div>
		
		<div class="row">
					<div class="col s6 offset-s6">					
						<button class="btn waves-effect waves-light red">
							Cancelar <i class="material-icons right">cancel</i>
						</button>					
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							Salvar <i class="material-icons right">check</i>
						</button>
					</div>
				</div>
		</form>

	</div>

	<jsp:include page="imports/footer-admin.jsp" />

</body>


</html>