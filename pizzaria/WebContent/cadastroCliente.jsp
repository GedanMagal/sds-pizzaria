<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar</title>
</head>
<body>
	<jsp:include page="imports/header.jsp" />

	<section class="content background-img">
		<form method="post" action="servlet?acao=cadastroPessoa">
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
						<input type="hidden" name="classificador">
						<input type="text" name="telefone" id="telefone"> <label
							class="active" for="telefone">Telefone</label>
					</div>
					<div class="input-field col s4">
					<input type="hidden" name="classificador">
						<input type="text" name="celular" id="celular"> <label
							class="active" for="celular">Celular</label>
					</div>

				</div>
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
							class="active" for="endereco">Logradouro (Av. / R. / P�.)</label>
							
					</div>
					<div class="input-field col s3">
						<input type="text" name="numero" id="numero"> <label
							class="active" for="numero">n�.</label>
					</div>
					<div class="input-field col s3">
						<input type="text" name="complemento" id="complemento"> <label
							class="active" for="complemento">Complemento</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s3">
						<input type="text" name="cep" id="cep"> <label
							class="active" for="cep">CEP</label>
					</div>
					<div class="input-field col s4">
						<input type="text" name="bairro" id="bairro"> <label
							class="active" for="bairro">Bairro.</label>
					</div>
					<div class="input-field col s4">
						<input type="text" name="cidade" id="cidade"> <label
							class="active" for="cidade">Cidade</label>
					</div>
					<div class="input-field col s1">
						<select id="estado" name="estado">
							<option value="AC">Acre</option>
							<option value="AL">Alagoas</option>
							<option value="AP">Amap�</option>
							<option value="AM">Amazonas</option>
							<option value="BA">Bahia</option>
							<option value="CE">Cear�</option>
							<option value="DF">Distrito Federal</option>
							<option value="ES">Esp�rito Santo</option>
							<option value="GO">Goi�s</option>
							<option value="MA">Maranh�o</option>
							<option value="MT">Mato Grosso</option>
							<option value="MS">Mato Grosso do Sul</option>
							<option value="MG">Minas Gerais</option>
							<option value="PA">Par�</option>
							<option value="PB">Para�ba</option>
							<option value="PR">Paran�</option>
							<option value="PE">Pernambuco</option>
							<option value="PI">Piau�</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="RN">Rio Grande do Norte</option>
							<option value="RS">Rio Grande do Sul</option>
							<option value="RO">Rond�nia</option>
							<option value="RR">Roraima</option>
							<option value="SC">Santa Catarina</option>
							<option value="SP">S�o Paulo</option>
							<option value="SE">Sergipe</option>
							<option value="TO">Tocantins</option>
							<option value="EX">Estrangeiro</option>
						</select> <label class="active" for="estado">Estado</label>
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
						<a href="gerenciar-cliente.jsp"
							class="btn waves-effect waves-light red" \name="action">
							Cancelar <i class="material-icons right">add</i>
						</a>
					</div>
					<div class="col s3"offset-s6">
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