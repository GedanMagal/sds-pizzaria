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
	<jsp:include page="imports/msg.jsp" />
		<div class="col s9 offset-s6">
			<h4>Gerenciar cliente</h4>
		</div>		
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="cliente" id="nome"> <label
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
	              <th align="center">Nome</th>
	              <th align="center">E-mail</th>
	              <th align="center">Telefone</th>
	                  <th align="center">Celular</th>
	              <th align="center">Endereço</th>
	              <th align="center">numero</th>
	                  <th align="center">Cep</th>
	              <th align="center">bairro</th>
	              
	              <th>Ação</th>	              
	          </tr>
	        </thead>
	
	        <tbody id="dados">
	        <c:forEach items="${pessoas}" var="p">
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
	          	<td><a href="admin?acao=editarCliente&idCliente=${p.idPessoa}"
							class="btn waves-effect waves-light " name="action">
								 <i class="material-icons right">create</i>
						</a>	</td>
	          </tr>
	          	</c:forEach>
	           
	        </tbody>
	      </table>
	       <br>
	      <div class="fl-right row">
	      <a href="adminis?acao=listaEstado&param=admin" title="adicionar cliente"  class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		</div>
		</div>
		
	</div>

	
	<jsp:include page="imports/footer-admin.jsp" />
<script type="text/javascript">
$(document).ready(function () {
	
	$("#nome").keyup(function() {
		pesquisa();
	})
	
});
function pesquisa(){
		$.ajax({
		method:"POST",
        url: "buscacliente",
        data: "nome="+$("#nome").val(),
        success: function(data){
        	 $("#dados").empty();
        	 for(i=0;i<data.length;i++){
            	 $("#dados").append("<tr>")
            	 .append("<td>"+data[i].nome+"</td>")
            	 .append("<td>"+data[i].sobrenome+"</td>")
            	  .append("<td>"+data[i].cpf+"</td>")
            	   .append("<td>"+data[i].telefone+"</td>")
            	    .append("<td>"+data[i].celular+"</td>")
            	    .append("<td>"+data[i].endereco+"</td>")
        			.append("<td>"+data[i].numero+"</td>")
        			.append("<td>"+data[i].cep+"</td>")
        			.append("<td>"+data[i].bairro+"</td>")
        			.append("<td><a href=admin?acao=editarCliente&idCliente="+data[i].idPessoa+" class='btn waves-effect waves-light' name='action'><i class='material-icons right'>create</i></a></td></tr>");
        			
        	 }
	  }
		 });
}


</script>
	
</body>


</html>