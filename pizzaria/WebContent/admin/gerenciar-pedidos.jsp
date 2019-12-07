<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/cadastrar-cliente.css">
<link rel="stylesheet" href="css/side-bar-admin.css">
</head>
<body>
		<jsp:include page="imports/headerAdmin.jsp" />

	<div class="main-container">
		<div class="col s9 offset-s6">
			<h4>Realizar Pedido</h4>
		</div>		
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="nome" id="nome"> <label
					class="active" for="nome">Cliente</label>
			</div>	
			<div class="input-field col s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Filtrar <i class="material-icons right">search</i>
				</button>
			</div>				
		</div>

		<div class="row">
		  <table class="striped centered">
	        <thead >
	          <tr >
	              <th align="center">id</th>
	              <th align="center">data</th>
	              <th align="center">cliente</th>
	                  <th align="center">quantidade</th>
	              <th align="center">descProduto</th>
	              <th align="center">total</th>
	              <th>Ação</th>	              
	          </tr>
	        </thead>

	        <tbody id="dados">
	        
	          <tr>
	          <!-- nm_cliente, sobrenome, ds_email, cli_telefone, cli_celular, ds_logradouro, nm_endereco, nm_cep, ds_bairro -->
	          	<td> ${p.nome} ${p.sobrenome} </td>
	          	<td> ${p.email}</td>
	          	<td> ${p.telefone}</td>
	          	<td> ${p.celular}</td>
	          	<td> ${p.endereco}</td>
	          	<td> ${p.numero}</td>
	          	<td> ${p.cep}</td>
	          	<td> ${p.bairro}</td>
	          	<td> <a href="admin?acao=realizarPedido
							class="btn waves-effect waves-light " name="action">
								 <i class="material-icons right">local_grocery_store</i>
						</a>
				</td>
	          </tr>
	          
	        </tbody>
	      </table>
	       <br>
	      <div class="fl-right row">
	      <a href="admin?acao=realizarPedido" title="Adicionar Pedido"  class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		</div>
		</div>

	</div>


	<jsp:include page="imports/footer-admin.jsp" />


</body>
<script type="text/javascript">
$(document).ready(function () {
	listar();
});

function listar(){
	$.ajax({
	method:"POST",
    url: "pedidos",
    data: "acao=listar",
    success: function(data){
    	 $("#dados").empty();
    	 for(i=0;i<data.length;i++){
        	 $("#dados").append("<tr>")
        	 .append("<td>"+data[i].idPedido+"</td>")
        	 .append("<td>"+data[i].dataPedido+"</td>")
        	  .append("<td>"+data[i].valorPedido+"</td>")
        	   .append("<td>"+data[i].nomeCliente+" "+data[i].sobrenome+"</td>")
        	    .append("<td>"+data[i].tipoPagamento+"</td>")
        	    .append("<td>"+data[i].valorPagemnto+"</td>")
        	    .append("<td>"+data[i].vlTroco+"</td>")
        	    .append("<td>"+data[i].total+"</td>")
    			.append("<td><a href=admin?acao=editarCliente&idproduto="+data[i].idPedido+" class='btn waves-effect waves-light' name='action'><i class='material-icons right'>create</i></a></td></tr>");
    			
    	 }
  }
	 });
}

</script>

</html> 