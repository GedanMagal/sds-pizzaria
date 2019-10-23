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
	<form action="admin?acao=SalvarSaborPizza" method="POST">
		<div class="col s9 offset-s6">
			<h4>Produto</h4>
		</div>
		<div class="row">
			<div class="input-field col s6">
				<input type="text" name="sabor" id="sabor">
				 <label class="active" for="sabor">Sabor</label>
				 
			</div>
			<div class="input-field col s6">
			<input type="text" name="valor" id="valor"> 
				 <label	class="active" for="valor">valor</label></div>
			<a class="waves-effect waves-light btn modal-trigger" href="#modal1">selecionar ingredientes</a>
			
			<div id="modal1" class="modal">
			 <div class="modal-content">
			<div class="input-field col s8">
		
				<div class="switch label">
				<c:forEach items="${lista}" var="ing">
					<label>
					 ${ing.dsIngrediente} 
					<input type="checkbox" name="ingredientes" value="${ing.idIngrediente }"><span class="lever"></span>
					</label>
				</c:forEach>
		
			</div>
		</div>
			</div>
		</div>
		<div class="row">
			<div class="col s3 offset-s6">
				<button class="btn waves-effect waves-light red" type="submit"name="action">Limpar
				 <i class="material-icons right">clear</i>
				</button>
			</div>
			<div class="col s3">
				<button class="btn waves-effect waves-light" type="submit"name="action">Salvar
				 <i class="material-icons right">send</i>
				</button>

			</div>
		</div>
		</form>
		<div class="row">
		
			<form action="admin?acao=cadastarIngrediente" method="post">
			<div class="input-field col s6">
			<div  id="form">
			<input type="text" name="ingredientes" id=ingredientes class="ingre1" placeholder="ingredientes">
			<label class="active" for="ingredientes">Ingredientes</label>
			<input type="text" name="valor" id="valorIngre" class="valorIngre1">
			
			</div>
			
				<a class="btn waves-effect waves-light red" id="btn3">-</a>
				<a class="btn waves-effect waves-light" id="btn1">+</a>
					<button class="btn waves-effect waves-light" type="submit"name="action">Salvar
					 <i class="material-icons right">send</i>
					</button>
					</div>
				</form>
			</div>
			
				
			
		</div>
		
			<div class="clear"></div>
			

	<br>
	<br>
	<br>
	<br>
	<br>
	<br><br>
	<br>
	<br>
	<br>
	<br><br>
	<br>
	<br>
	<br>
	<br><br>
	<jsp:include page="imports/footer-admin.jsp" />


</body>


</html>