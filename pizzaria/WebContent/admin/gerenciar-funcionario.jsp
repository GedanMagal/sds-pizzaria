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
			<h4>Gerenciar funcionário</h4>
		</div>		
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="funcionario" id="funcionario"> <label
					class="active" for="nome">Funcionário</label>
			</div>	
			<div class="input-field col s6">
				<button class="btn waves-effect waves-light red" type="submit"
					name="action">
					Filtrar <i class="material-icons right">search</i>
				</button>
			</div>				
		</div>
		
		<div class="row">
		  <table>
	        <thead>
	          <tr>
	              <th>Funcionário</th>
	              <th>Telefone</th>
	              <th>Cargo</th>
	              <th>Ação</th>	              
	          </tr>
	        </thead>
	
	        <tbody>
	          <tr>
	            <td>Walter Campos</td>
	            <td>11 987654322</td>
	            <td>Pizzaiolo</td>
	            <td>
		            <a href="editar-funcionario.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	          <tr>
	            <td>Tamara Barbosa</td>
	            <td>11 987654322</td>
	            <td>Atendente</td>
	            <td>
		            <a href="editar-funcionario.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	          <tr>
	            <td>João da Silva</td>
	            <td>11 987654322</td>
	            <td>Entregador</td>
	            <td>
		            <a href="editar-funcionario.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	        </tbody>
	      </table>
	      <br>
	      <div class="fl-right row">
	      <a href="adminis?acao=listaEstado&param=adminFun" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		</div>
		</div>
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

</body>


</html>