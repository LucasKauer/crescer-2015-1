/* http://http://illuminati.instaweb.com.br:6789/autentica
http://http://illuminati.instaweb.com.br:6789/exercicios?token=%3CCODIGO%20RECEBIDO%3E */

var nome = {nome: 'Lucas'};

function enviaNome(){
	$.ajax({
		url: 'http://illuminati.instaweb.com.br:6789/autentica',
		type: 'POST',
		contentType: 'application/json',
		dataType: 'json',
		data: JSON.stringify(nome)
	}).done(function() {
		alert("Oi");
	});
};


success: function (data) {})