<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="imports/header.jsp" />

<section class="content background-img">
<form method="post">
    <div class="container side-content">
		<div class="col s9 offset-s6">
			<h4>Cliente</h4>
		</div>
		<h6>Dados Pessoais</h6>
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
		
		<h6>Localiza��o Endere�o</h6>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="endereco" id="endereco"> <label
					class="active" for="nome">Logradouro (Av. / R. / P�.)</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="numero" id="numero"> <label
					class="active" for="nome">n�.</label>
			</div>
			<div class="input-field col s3">
				<input type="text" name="complemento" id="complemento"> <label
					class="active" for="complemento">Complemento</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s3">
				<input type="text" name="cep" id="cep"> <label
					class="active" for="nome">CEP</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="bairro" id="bairro"> <label
					class="active" for="nome">Bairro.</label>
			</div>
			<div class="input-field col s4">
				<input type="text" name="cidade" id="cidade"> <label
					class="active" for="nome">Cidade</label>
			</div>
			<div class="input-field col s1">
				<input type="text" name="estado" id="estado"> <label
					class="active" for="nome">Estado</label>
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
			<div class="col s3 offset-s6">
				<a href="gerenciar-cliente.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Cancelar <i class="material-icons right">add</i>
				</a>
			</div>
			<div class="col s3" offset-s6">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Salvar <i class="material-icons right">check</i>
				</button>

			</div>
	</div>
	<div class="clear"></div>
	</div>
	</form>
</section>
</body>
</html>