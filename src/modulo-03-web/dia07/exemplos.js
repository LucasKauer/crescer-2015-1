// Agenda uma funcao para ser executada daqui a pouco
setTimeout(function() {
	console.log('caiu a ficha!');
	}, 2000);
	
/* setInterval(function() {
	console.log('caiu a ficha!');
	}, 2000); */
	
var i = setInterval(function() {
	console.log(
		new Date()
	)
}, 2000);

clearInterval(i);