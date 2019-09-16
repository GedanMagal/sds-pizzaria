$(document).ready(() => {
	
	$('.endereco-info').hide();
	
	
	$('#cep').on('keyup', () => {		
		
		let cep = $('#cep').val();		
			
		if(cep.length == 8){
		
			fetch(`https://viacep.com.br/ws/${cep}/json/`)
				.then(data => data.json())
				.then(results => {
						
					let {logradouro, bairro, localidade, uf} = results;
						
					let logradouroRuaEnd = `${logradouro}`;
					let bairroEnd = `${bairro}`;
					let cidadeEnd = `${localidade}`;
					let estadoEnd = `${uf}`;
						
					$("#logradouro").val(logradouroRuaEnd);
					$("#bairro").val(bairroEnd);
					$("#cidade").val(cidadeEnd);
					$("#estado").val(estadoEnd);
					$('#complemento').focus();
					$('.endereco-info').show();
						
						
				}).catch(error => {
					console.error(`Houveram erros na consulta de endereço. Detalhes: ${error}`);
				});			
		}
	});
	
	$('select[name=estado]').on('change',function(){
		$.ajax({
		  method: "POST",
		  url: "servlet?acao=listarEstados",
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
			  $('select[name=estado] option').remove();
			  var pegaDados = dados.split(":");
				
				for(var i=0;i < pegaDados.length - 1;i++){
					var codigoBairro = pegaDados[i].split("-")[0];
					var nomeBairro = pegaDados[i].split("-")[1];
					
					$('select[name=bairro]').append('<option value= "'+codigoBairro+'">'+nomeBairro+'</option>');
				}

		  }
		});
});
});