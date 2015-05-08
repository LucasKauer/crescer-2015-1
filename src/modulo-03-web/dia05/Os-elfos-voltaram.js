function Elfo (nome, flechas) {

	this.nome = nome;
	this.flechas = flechas || 42;
	this.experiencia = 0;
	
	this.atirarFlecha = function() {
		this.flechas--;
		this.experiencia++;
	}
	
}

function Elfo (options) {

	options = options || {};
	this.nome = options.nome;
	this.flechas = options.flechas || 42;
	this.experiencia = 0;
	
	this.atirarFlecha = function() {
		this.flechas--;
		this.experiencia++;
	}
	
}