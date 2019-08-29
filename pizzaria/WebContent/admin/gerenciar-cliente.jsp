<!DOCTYPE html>
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
	<jsp:include page="header-admin.jsp" />

	<div class="container">
		<div class="col s9 offset-s6">
			<h4>Gerenciar cliente</h4>
		</div>		
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="cliente" id="cliente"> <label
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
		  <table>
	        <thead>
	          <tr>
	              <th>Cliente</th>
	              <th>Tel 1</th>
	              <th>Tel 2</th>
	              <th>Ação</th>	              
	          </tr>
	        </thead>
	
	        <tbody>
	          <tr>
	            <td>Walter Campos</td>
	            <td>11 31328950</td>
	            <td></td>
	            <td>
		            <a href="editar-cliente.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	          <tr>
	            <td>Tamara Barbosa</td>
	            <td>11 972005816</td>
	            <td>11 995446502</td>
	            <td>
		            <a href="editar-cliente.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	          <tr>
	            <td>João da Silva</td>
	            <td>11 21342547</td>
	            <td>11 932145874</td>
	            <td>
		            <a href="editar-cliente.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Editar <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	        </tbody>
	      </table>
	       <br>
	      <div class="fl-right row">
	      <a href="cadastrar-cliente.jsp" title="adicionar cliente"  class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
		</div>
		</div>
		
	</div>

	<jsp:include page="footer-admin.jsp" />

</body>


</html>