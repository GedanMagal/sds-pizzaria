
$(document).ready(function() {
	
	ingredientes();
	 $('.tooltipped').tooltip();
	$('select').formSelect();
	$('.modal').modal();
	$('.sidenav').sidenav();
	$('.datepicker').datepicker({
		format : 'dd mmm, yyyy'
	});
	$('.cep').mask('00000-000');
	$('.phone').mask('(00) 0000-0000');
	$('.cpf').mask('000.000.000-00', {
		reverse : true
	});
	$('.cnpj').mask('00.000.000/0000-00', {
		reverse : true
	});


});
function addSabores() {
	let qtd = document.getElementById('select').value;
	let add = document.getElementById('add');
	let add2 = document.getElementById('add2');
	let add3 = document.getElementById('add3');

	if (qtd === '1') {

		add.classList.add('dsblock');
		add.classList.remove('dsnone');
		add2.classList.add('dsnone');
		add2.classList.remove('dsblock');
		add3.classList.add('dsnone');
		add3.classList.remove('dsblock');

	} else if (qtd === '2') {
		add.classList.add('dsblock');
		add.classList.remove('dsnone');
		add2.classList.add('dsblock');
		add2.classList.remove('dsnone');
		add3.classList.add('dsnone');
		add3.classList.remove('dsblock');
	} else if (qtd === '3') {
		add.classList.add('dsblock');
		add.classList.remove('dsnone');
		add2.classList.add('dsblock');
		add2.classList.remove('dsnone');
		add3.classList.add('dsblock');
		add3.classList.remove('dsnone');
	}

}
function carregaIng() {
	let ing = document.getElementsByClassName('dsnone');
	for (let i = 0; i < ing.length; i++) {

		ing[i].classList.add('dsblock');
		ing[i].classList.remove('dsnone');

	}
}
 function flip() {
	 document.querySelector("#flip-container").classList.toggle("flip")
}
 
 let increment = 1;

function ingredientes() {	
	
	if(increment == 1){
		$("#btn3").hide();
	}
	
	$("#btn1").click(function() {
		increment++;		
		$("#form").append(`<input type='text' class="ingre${increment}" placeholder='ingredientes' name='ingredientes' id='txtIngrediente' >`);
		$("#form").append(`<input type='text' name='valor' id='valorIngre' class="valorIngre${increment}">`);
		if(increment > 1){
			$("#btn3").show();
		}
	});

	$("#btn3").click(function() {
		$(`.ingre${increment}`).remove();
		increment--;		
		
		if(increment == 1){
			$("#btn3").hide();
		}
	});
}

