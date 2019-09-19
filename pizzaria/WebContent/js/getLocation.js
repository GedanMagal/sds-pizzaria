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
						
					$("#logradouro").val(`${logradouroRuaEnd}, ${bairroEnd}, ${cidadeEnd}, ${estadoEnd}`).focus();
					$("#bairro").val(bairroEnd).focus();
					$('#cep').focus();
						
						
				}).catch(error => {
					console.error(`Houveram erros na consulta de endereço. Detalhes: ${error}`);
				});			
		}
	});
	
	
});