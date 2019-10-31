<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<jsp:include page="imports/msg.jsp" />

	<div class="main-container">
		
		<div class="col s9 offset-s6">
			<h4>Cliente</h4>
			
			
		</div>
		<h6>Dados Pessoais</h6>

		<form method="post" action="admin?acao=salvarCliente">
			<div class="row">
				<div class="input-field col s6">
					<input type="text" name="nome" id="nome" required="required"> <label
						class="active" for="nome">Nome</label>
				</div>
				<div class="input-field col s6">
					<input type="text" name="sobrenome" id="sobrenome" required> <label
						class="active" for="sobrenome">Sobrenome</label>
				</div>

			</div>

			<div class="row">
				<div class="input-field col s4">
					<input type="text" name="cpf" id="cpf" maxlength="11" required="required"> <label
						class="active" for="cpf">CPF</label>
				</div>
				<div class="input-field col s4">
					<input type="text" name="telefone" id="telefone1" required="required"> <label
						class="active" for="telefone1">Telefone 1</label>
				</div>
				<div class="input-field col s4">
					<input type="hidden" name="classificador" > <input
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
					<input type="email" name="email" id="email" required="required"> <label
						class="active" for="email">E-mail</label>
				</div>
				<div class="input-field col s3">
					<input type="password" name="senha" id="senha" required="required"> <label
						class="active" for="senha">Senha</label>
				</div>
			</div>

			<h6>Localiza��o Endere�o</h6>
			<div class="row">
				<div class="input-field col s3">
					<input type="text" name="cep" id="cep" required="required"> <label
						class="active" for="cep">CEP</label>
				</div>
				<div class="input-field col s4">
					<input type="text" name="bairro" id="bairro" required="required"> <label
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
						class="active" for="nome">Logradouro (Av. / R. / P�.)</label>
				</div>
				<div class="input-field col s3">
					<input type="text" name="numero" id="numero" required="required"> <label
						class="active" for="numero">n�.</label>
				</div>
				<div class="input-field col s3">
					<input type="text" name="complemento" id="complemento"> <label
						class="active" for="complemento">Complemento</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input type="text" name="localReferencia" id="localReferencia">
					<label class="active" for="localReferencia">Local de
						Refer�ncia</label>
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
<script>
	$(document).ready(function() {

		$('select[name=estado]').on('change',function(){
			$.ajax({
				method: "POST",
				  url: "cidadeServlet",
				  data: "idEstado="+ $('select[name=estado]').val(),
				  statusCode:{
					  404: function() {
						alert('pagina n�o encontrada')
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
</body>


</html>