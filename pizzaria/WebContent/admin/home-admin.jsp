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
	<div class="container">
		<div class="col s9 offset-s6">
			<h4>Gerenciar cliente</h4>
		</div>		
		<div class="row">
			<div class="input-field col s9">
				<input type="text" name="cliente" id="cliente"> <label
					class="active" for="nome">Cliente</label>
			</div>	
			<div class="input-field col s3">
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
	              <th  align="center" colspan="2">Ação</th>	              
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
				<td>
		            <a href="pedido.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Novo Pedido <i class="material-icons right">add</i>
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
				<td>
		            <a href="pedido.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Novo Pedido <i class="material-icons right">add</i>
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
				<td>
		            <a href="pedido.jsp" class="btn waves-effect waves-light red" []
						name="action">
						Novo Pedido <i class="material-icons right">add</i>
					</a>
				</td>
	          </tr>
	        </tbody>
	      </table>
		</div>
		
	</div>
	
	

	<section class="content">
		<div class="container">
			<div class="row col s12"></div>
		</div>
	</section>

	<jsp:include page="imports/footer-admin.jsp" />


</body>
</html>