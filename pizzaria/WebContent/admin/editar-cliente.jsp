<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">

		<div class="col s9 offset-s6">
			<h4>Cliente</h4>
		</div>
		<h6>Dados Pessoais</h6>
		
		<form method="POST" >  
		<div class="row">
			<div class="input-field col s6">
			<input type="hidden" name="idCliente" value="${pessoa.idPessoa}">
				<input type="text" name="nome" id="nome" value="${pessoa.nome}"> <label
					class="active" for="nome">Nome</label>
			</div>
			<div class="input-field col s6">
				<input type="text" name="sobrenome" id="sobrenome" value="${pessoa.sobrenome}"> <label
					class="active" for="sobrenome">Sobrenome</label>
			</div>
			
		</div>
		
		<div class="row">
		<div class="input-field col s4">
				<input type="text" name="cpf" id="cpf" value="${pessoa.cpf}"> <label
					class="active" for="cpf">CPF</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="telefone" id="telefone" value="${pessoa.telefone }"> <label
					class="active" for="telefone1">Telefone 1</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="celular" id="telefone2" value="${pessoa.celular}"> <label
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
				<input type="email" name="email" id="email" value="${pessoa.email }"> <label
					class="active" for="email">E-mail</label>
			</div>
			
		</div>
		
		<h6>Localização Endereço</h6>
		<div class="row">
			<div class="input-field col s6">
				<input type="hidden" value="${pessoa.idEndereco }" name="idEndereco">
				<input type="text" name="logradouro" id="logradouro" value="${pessoa.endereco }"> <label
					class="active" for="nome">Logradouro (Av. / R. / Pç.)</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="numero" id="numero" value="${pessoa.numero }"> <label
					class="active" for="nome">nº.</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="complemento" id="complemento" value=""> <label
					class="active" for="complemento">Complemento</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s3">
				<input type="text" name="cep" id="cep" value="${pessoa.cep }"> <label
					class="active" for="nome">CEP</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="bairro" id="bairro" value="${pessoa.bairro }"> <label
					class="active" for="nome">Bairro.</label>
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
				<div class="input-field col s12">
				<input type="text" name="localReferencia" id="localReferencia">
				<label class="active" for="localReferencia">Local de
					Referência</label>
			</div>
		</div>
		
			
		<div class="row">
<!-- 			<div class="col s3 offset-s6"> -->
<!-- 				<a href="gerenciar-cliente.jsp" class="btn waves-effect waves-light red"  -->
<!-- 						name="action">Cancelar <i class="material-icons right">clear</i> -->
<!-- 				</a> -->
<!-- 			</div> -->
			
			<div class="col s3 offset-s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action" formaction="admin?acao=listarClientes">
					Cancelar <i class="material-icons right">clear</i>
				</button>

			</div>
			
			
			<div class="col s3 offset-s6">
				<button class="btn waves-effect waves-light" type="submit"
					name="action" formaction="admin?acao=atualizarCliente">
					Salvar <i class="material-icons right">check</i>
				</button>

			</div>
		</div>
</form>

	</div>

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