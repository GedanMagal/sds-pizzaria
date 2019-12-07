<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="imports/header.jsp"/>
	<section class="content background-img">
	<!-- <div class="carousel carousel-slider container">
    <a class="carousel-item" href="#one!">
    <img src="img/banner_site_pedepizza.jpg"></a>
    <a class="carousel-item" href="#two!"><img src="https://lorempixel.com/800/400/food/2"></a>
    <a class="carousel-item" href="#three!"><img src="https://lorempixel.com/800/400/food/3"></a>
    <a class="carousel-item" href="#four!"><img src="https://lorempixel.com/800/400/food/4"></a>
    </div>
         -->
	<div class=" content background-img">
		
	
	
	<div class="side-content container">
	

	
	<h1>Promoções</h1>
	<div id="produtos">
	
    
	</div>

	<div class="clear"></div>
	<h1>Bebidas</h1>
    <div class="card small sm-card">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="img/refrigerante.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">Card Title<i class="material-icons right">menu</i></span>
      <p><a class="waves-effect waves-light btn-small" href="#">Comprar</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Card Title<i class="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
    </div>
    
	<div class="card small sm-card">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="img/refrigerante.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">Card Title<i class="material-icons right">menu</i></span>
      <p><a class="waves-effect waves-light btn-small" href="#">Comprar</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Card Title<i class="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
    </div>
    <div class="card small sm-card">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="img/refrigerante.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">Card Title<i class="material-icons right">menu</i></span>
      <p><a class="waves-effect waves-light btn-small" href="#">Comprar</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Card Title<i class="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
    </div>
    
	<div class="card small sm-card">
    <div class="card-image waves-effect waves-block waves-light">
      <img class="activator" src="img/refrigerante.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-darken-4">Card Title<i class="material-icons right">menu</i></span>
      <p><a class="waves-effect waves-light btn-small" href="#">Comprar</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Card Title<i class="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
    </div>
    </div>
    
        
      <div id="modal1" class="modal">
    <div class="modal-content">
      <h4>Inggredientes</h4>
     	<div id="ingrediente">
     		
     	</div>
    </div>
    <div class="modal-footer">
      <a href="javascript:void(0)" class="modal-close waves-effect waves-green btn-flat" >fechar</a>
    </div>
  </div>

<div class="clear"></div>
</div>

</section>
        <jsp:include page="imports/footer.jsp"/>
         <script type="text/javascript">
     
       
             $(document).ready(function () {
            	 $('.sidenav').sidenav();
            	   $.ajax({
            		   method:"POST",
                       url: "index",
                       data: "acao=listar",
                       success: function(data){
                    	 for(i=0;i<data.length;i++){
                    	 $("#produtos").append("<div class='card small sm-card'>"+
                    	   "<div class='card-image waves-effect waves-block waves-light'>"+
                    	      "<img class='activator' src='img/pizzass.png'>"+
                    	    "</div>"+
                    	    "<div class='card-content'>"+
                    	      "<span class='card-title  grey-text text-darken-4'><a class=' modal-trigger' href='#modal1' onclick='carregaIngrediente("+data[i].idProduto+");'>"+data[i].nomeProduto+"</a></span>"+
                    	      "<p><a class='waves-effect waves-teal btn-small' href='javascript:void(0)' onclick='addProduto("+data[i].idProduto+")'>Comprar</a></p>"+
                    	    "</div>"+
                    	    "<div class='card-reveal'id='ingredientes'>"+
                    	      "<span class='card-title grey-text text-darken-4'>"+data[i].nomeProduto+"<i class='material-icons right'>close</i></span>"+
                    	      "<p> </p>"+                 	      
                    	      "</div>"+
                    	    "</div>");
                    	    

                    	 }
                       }
            	   });
            	 
             }); 
             
             
             function addProduto(idproduto){
            	$.ajax({
          		   	method:"POST",
                     url: "index?acao=add",
                     data: "idproduto="+idproduto,
                     success: function(data){
                    	 alert("adicionado ao carrionde compras!")
                    	$("#qtd").html("<b>"+data.quantidade+"</b>");
                    
                     }
           	  });
            }
             
             function carregaIngrediente(idsabor) {
                 $.ajax({
                         method: "POST",
                         url: "saborServlet",
                         data: "idSabor=" + idsabor,
                         statusCode: {
                             404: function () {
                                 alert('pagina não encontrada')
                             },
                             500: function () {
                                 alert('erro no servidor')
                             }
                         },
                         success: function (data) {
                        	 $("#ingrediente").empty();
                        	 for (i=0;i<data.length;i++){
                        	 $("#ingrediente").append("<li>"+data[i].dsIngrediente+"</li>");
                        	 }
                             }
                         
                     });
             }
        /* 
             function carregaIngrediente(idsabor) {
                 $.ajax({
                         method: "POST",
                         url: "saborServlet",
                         data: "idSabor=" + idsabor,
                         statusCode: {
                             404: function () {
                                 alert('pagina não encontrada')
                             },
                             500: function () {
                                 alert('erro no servidor')
                             }
                         },
                         success: function (dados) {
                        	 $("#ingrediente").empty();
                             var pDados = dados.split(":");
                             for (var i = 0; i < pDados.length - 1; i++) {
                                 var codiIngre = pDados[i].split("-")[0];
                                 var dsIngre = pDados[i].split("-")[1];
                                 $("#ingrediente").append(
                                         "<div class='switch'>"
                                         + dsIngre
                                         + "<label><input type='checkbox' value='" + codiIngre +
                                         "'checked='true' name='ingredientes' id='ingr'><span class='lever'></span></label></div>");
                             }
                         }
                     });
             } */
         </script>   
</body>
</html>