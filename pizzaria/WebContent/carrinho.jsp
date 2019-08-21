<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="imports/header.jsp"/>
<section class="content background-img">
    <div class="container side-content">
		<h3>carrinho</h3>
		<div class="row">
			<table class="table_cart">
				<tr>
				<th>Produto</th>
				<th>descricao</th>
				<th>Quantidade</th>
				<th>acao</th>
				</tr>
				<tr>
				<td>pizza</td>
				<td>Mussarela/Calabresa</td>
				
				<td><input class="number_form"type="number" name="qtd"></td>
				<td><a href=""><i class="material-icons icone">remove_circle</i></a></td>
				</tr>
				<tr>
				<td>Refrigerante</td>
				<td>Coca-cola</td>
				<td><input class="number_form"type="number" name="qtd"></td>
				<td><a href=""><i class="material-icons icone">remove_circle</i></a></td>
				</tr>
			</table>
			
				<div class="row btn_proximo right">
				<a class="waves-effect waves-light btn">Finalizar Pedidoj</a>
				</div>
		</div>
    </div> 
    <div class="clear"></div> 
</section>

<jsp:include page="imports/footer.jsp"/>
</body>
</html>