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

	<div class="main-container">
		<div class="col s9 offset-s6">
			<h4>Gerenciar Produto</h4>
		</div>
		<div class="input-field col s6">
		<div class="input-field col s6">
		<label class="active" for="tipo">Tipo</label>
			<select name="tipo" onchange="displaycadastro()" id="tipo">
				<option value="0">Tipo produto </option>
				<c:forEach items="${tiposProdutos}" var="t">
				<option value="${t.idTipoProduto}">${t.dsTipoProduto} </option>
				
				</c:forEach>
			</select>
		</div>
		<form action="admin?acao=cadastrarProduto" method="POST" class="none" id="form1">
		<input type="hidden" name="tipo" value="1">
		<div class="col s9 offset-s6">
			<h4>Pizza</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="descricao" id="descricao" value="${produto != null ? produto.nomeProduto : param.nomeProduto}"> <label
					class="active" for="descricao">Descrição</label>
			</div>
			
			
			</div>

		

		<div class="row">
			<div class="input-field col s6">
				<select name="tamanho">
				<option value="0">Tamanho </option>
				<option value="Broto ">Broto </option>
				<option value="8 pedaços ">8 pedaços </option>
				
			</select>
				
			</div>
				<div class="input-field col s6">
				<select name="sabores" onchange="displaycadastro()" id="tipo">
				<option value="0">Sabor </option>
				<c:forEach items="${sabores}" var="sab">
				<option value="${sab.idSabor}">${sab.dsSabor} </option>
				
				</c:forEach>
			</select>
		</div>
		
		
			<div class="input-field col s6">
				<input type="text" name="valor" id="valor" value="${sab.preco}" > <label
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
		</form>
		
	<form action="admin?acao=cadastrarProduto" method="POST" class="none" id="form2">
		<input type="hidden" name="tipo" value="2">
		<div class="col s9 offset-s6">
			<h4>bebida</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="descricao" id="descricao"> <label
					class="active" for="descricao">Descrição</label>
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
	
		
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="nome" id="nome"> <label
					class="active" for="nome">Pesquisa</label>
			</div>
			<div class="input-field col s6">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Filtrar <i class="material-icons right">search</i>
				</button>
			</div>
		</div>

		<div class="row">
			<table  class="striped centered">
				<thead>
					<tr>
						<th>id</th>
						<th>nome</th>
						<th>tamanho</th>
						<th>Valor</th>
						<th>estoque</th>
						<th>tipo</th>
						<th>ação</th>
					</tr>
				</thead>

				<tbody id="dados">
				
					<tr">
						
						<td>${prod.idProduto}</td>
						<td>${prod.nomeProduto}</td>
						<td>${prod.tamanho}</td>
						<td>${prod.valorProduto}</td>
						<td>${prod.quantidade}</td>
						<td>${prod.dsTipo}</td>
						
						
						<td>
						<a href="admin?acao=editarProduto&idProduto=${prod.idProduto}" class="btn waves-effect waves-light red" name="action">
								Editar <i class="material-icons right">create</i>
						</a> <a href="adicionar-produto.jsp"
							class="btn waves-effect waves-light red" name="action">
								Excluir <i class="material-icons right">delete</i>
						</a>
						</td>
						</tr>
					
					
					
				</tbody>
			</table>
		</div>

		
	</div>
	<div class="clear"></div>
</div>
<div class="clear"></div>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/jquery.mask.js"></script>
	<script type="text/javascript" src="js/getLocation.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
<jsp:include page="imports/footer-admin.jsp" />
<script type="text/javascript">
$(document).ready(function () {
	
	$("#nome").keyup(function() {
		pesquisa();
	})
	listar();
});
function pesquisa(){
		$.ajax({
		method:"POST",
        url: "busca?acao=busca",
        data: "nome="+$("#nome").val(),
        success: function(data){
        	 $("#dados").empty();
        	 for(i=0;i<data.length;i++){
            	 $("#dados").append("<tr>")
            	 .append("<td>"+data[i].idProduto+"</td>")
            	 .append("<td>"+data[i].nomeProduto+"</td>")
            	  .append("<td>"+data[i].tamanho+"</td>")
            	   .append("<td>"+data[i].valorProduto+"</td>")
            	    .append("<td>"+data[i].quantidade+"</td>")
            	    .append("<td>"+data[i].dsTipo+"</td></tr>")
        }
	  }
		 });
}

function listar(){
	$.ajax({
	method:"POST",
    url: "busca",
    data: "acao=listar",
    success: function(data){
    	 $("#dados").empty();
    	 for(i=0;i<data.length;i++){
        	 $("#dados").append("<tr>")
        	 .append("<td>"+data[i].idProduto+"</td>")
        	 .append("<td>"+data[i].nomeProduto+"</td>")
        	  .append("<td>"+data[i].tamanho+"</td>")
        	   .append("<td>"+data[i].valorProduto+"</td>")
        	    .append("<td>"+data[i].quantidade+"</td>")
        	    .append("<td>"+data[i].dsTipo+"</td></tr>")
    }
  }
	 });
}
</script>
</body>


</html>