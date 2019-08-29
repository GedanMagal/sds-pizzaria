$(document).ready(() => {
	$('#cep').blur(() => {
	
		let cep = $('#cep').val();
	
		fetch(`https://viacep.com.br/ws/${cep}/json/`)
			.then(data => data.json())
			.then(results => {
				console.log(results);
			}); 
			
	
	});
});