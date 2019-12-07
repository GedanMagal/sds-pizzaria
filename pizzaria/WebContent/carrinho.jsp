<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="imports/header.jsp"/>
<section class="content background-img">
<div class="row">
    <div class="container side-content-index">
		<h3>carrinho</h3>
		
			<table class="table_cart">
				<tr>
				<th>Produto</th>
				<th>descricao</th>
				<th>Quantidade</th>
				<th>acao</th>
				</tr>
				<c:forEach items="${carrinho}" var="car">
				<tr>
					
					<td>${car.nomeProduto}</td>
					<td>${car.tamanho}</td>
					<td>${car.quantidade}</td>
				</tr>
				</c:forEach>
			</table>
			
				<div class="row btn_proximo right">
				<a class="waves-effect waves-light btn" href="index?acao=finalizarpedido">Finalizar Pedidoj</a>
				</div>
				
		
		</div>

   <div class="form-total">
   		<h2>Total</h2>
   		<input type="text" value="${totalpagar}" disabled="disabled">
   		</div>
    
    <div class="clear"></div> 
   		
    </div> 
    </section>
		
<jsp:include page="imports/footer.jsp"/>
</body>
</html>