 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="../css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="../css/main.css">
<!-- <link rel="stylesheet" href="../css/cadastrar-cliente.css"> -->
<link rel="stylesheet" href="../css/side-bar-admin.css">
</head>
<body>

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
		<div class="col s9 offset-s6">
			<h4>Funcionário</h4>
		</div>
		<h6>Dados Pessoais</h6>
		<form method="post" action="admin?acao=salvarFuncionario">
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
					<input type="text" name="telefone" id="telefone"> <label
						class="active" for="telefone1">Telefone 1</label>
				</div>
				<div class="input-field col s4">
					<input type="hidden" name="classificador"> <input
						type="text" name="celular" id="celular"> <label
						class="active" for="celular">Celular</label>
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
						class="active" for="logradouro">Logradouro (Av. / R. / Pç.)</label>
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

			<h6>Dados do Funcionário</h6>
			<div class="row">
				<div class="input-field col s4">
					<input type="text" name="nomeCargo" id="nomeCargo"> <label
						class="active" for="nomeCargo">Nome do Cargo</label>
				</div>
				<div class="input-field col s4">
					<input type="text" id="dataAdmissao" name="dataAdmissao"
						placeholder="Data de Admissão" maxlength="10">
				</div>
				<div class="input-field col s4">
					<input type="text" name="status" id="status"> <label
						class="active" for="status">Status</label>
				</div>
			</div>
				<div class="row">
						<div class="input-field col s12">
							<textarea id="descricao" name="descricao" class="materialize-textarea"></textarea>
							<label for="descricao">Descrição do Cargo</label>
						</div>
					</div>
			
			
			<div class="row">
				<div class="col s3 offset-s6">
					<a href="gerenciar-funcionario.jsp"
						class="btn waves-effect waves-light red" name="action">
						Cancelar <i class="material-icons right">cancel</i>
					</a>
				</div>
			
				<div class="col s3"offset-s6">
					<button class="btn waves-effect waves-light" type="submit"
						name="action">
						Salvar <i class="material-icons right">check</i>
					</button>
			</div>	
			</div>
	</form>

	<jsp:include page="imports/footer-admin.jsp" />

</body>
<script>
	$(document).ready(function() {

		$('select[name=estado]').on('change',function(){
			$.ajax({
				method: "POST",
				  url: "cidadeServlet",
				  data: "idEstado="+ $('select[name=estado]').val(),
				  statusCode:{
					  404: function() {
						alert('pagina não encontrada')
					},
					500: function() {
						alert('erro no servidor')
					}
				  },		 
				  success: function(dados) {
					  $('select[name=cidade] option').remove();
					  var pegaDados = dados.split(":");
						
						for(var i=0;i < pegaDados.length - 1;i++){
							var codigoCidade = pegaDados[i].split("-")[0];
							var nomeCidade = pegaDados[i].split("-")[1];
							
							$('select[name=cidade]').append('<option value= "'+codigoCidade+'">'+nomeCidade+'</option>');							
							
						}
						$('select').formSelect();

				  }
				 
				});

			})
		});
	
	</script>



</html>