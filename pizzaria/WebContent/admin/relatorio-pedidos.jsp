<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
		<div class="header-content">
			<h5>Relatório de Pedidos</h5>
		</div>
		<div class="row">
			<div class="input-field col s3 offset-s1">
				<input type="text" id="codPedido" placeholder="Código Pedido" name="codPedido">
			</div>
			<div class="input-field col s3 offset-s1">
				<input type="date"  id="dataInicio" name="dataInicio"
					placeholder="Data de Inicio">
			</div>
			<div class="input-field col s3 offset-s1">
				<input type="date"  id="dataFim" name="dataFim"
					placeholder="Data Final">
			</div>
			<div class="input-field col s3 offset-s1">
				<button class="btn waves-effect waves-light" id="filtrar" type="submit"
					name="action">
					Gerar <i class="material-icons right">send</i>
				</button>
			</div>
		</div>

		<table class="highlight centered responsive-table">
			
				<tr>
					<th>Código do Pedido</th>
					<th>Data</th>
					<th>Nome do cliente</th>
					<th>Descrição</th>
					<th>Quantidade</th>
					<th>Valor</th>

				</tr>
			</thead>
			<tbody id="dados">
				
			</tbody>
		</table>

		<div class="row">
			<div class="input-field col s3 offset-s9">
				
			</div>
		</div>

	</div>


	<jsp:include page="imports/footer-admin.jsp" />


<script type="text/javascript">
$(document).ready(function () {
	var allItems = [];
	listar();
});

$("#filtrar").on("click", function(){
	var codPedido = $("#codPedido").val();
	var dataInicio = $("#dataInicio").val();
	var dataFim = $("#dataFim").val();
	filtrar(codPedido,dataInicio,dataFim);
	
});

function filtrar(codPedido,dataInicio,dataFim){
	$.ajax({
	method:"POST",
    url: "pedidos?acao=listar",
    data: "codPedido="+codPedido+"&dataInicio="+dataInicio+"&dataFim="+dataFim,
    success: function(data){
    	allItems = data;
    	 renderData(allItems);
  }
	 });
}
function listar(){
	$.ajax({
	method:"POST",
    url: "pedidos",
    data: "acao=listar",
    success: function(data){
    	allItems = data;
    	 renderData(allItems);
  }
	 });
}

function renderData(data){
	$("#dados").empty();
	 for(i=0;i<data.length;i++){
   	 $("#dados").append("<tr>")
   	 .append("<td>"+data[i].idPedido+"</td>")
   	 .append("<td>"+data[i].dataPedido+"</td>")
   	  .append("<td>"+data[i].nomeCliente+" "+data[i].sobrenome+"</td>")
   	  .append("<td>"+data[i].valorPedido+"</td>")
   	    .append("<td>"+data[i].tipoPagamento+"</td>")
   	    .append("<td>"+data[i].valorPagemnto+"</td>")
   	    .append("<td>"+data[i].vlTroco+"</td>")
			.append("<td><a href=admin?acao=editarCliente&idCliente="+data[i].idPedido+" class='btn waves-effect waves-light' name='action'><i class='material-icons right'>create</i></a></td></tr>");
			
	 }
}

</script>
</body>
</html>