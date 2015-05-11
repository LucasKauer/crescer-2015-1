function Elfo (nome, flechas) {

	this.nome = nome;
	this.flechas = flechas || 42;
	this.experiencia = 0;
	
	/*	Duplica "objetos" (funcoes) em memória
		this.atirarFlecha = function() {
		this.flechas--;
		this.experiencia++;
	}*/
}

/* Jeitinho maroto de não replicar código em memória */
Elfo.prototype.atirarFlecha = function() {
	this.flechas--;
	this.experiencia++;
}

function Elfo (options) {

	options = options || {};
	this.nome = options.nome;
	this.flechas = options.flechas || 42;
	this.experiencia = 0;
	
	/*	Duplica "objetos" (funcoes) em memória
		this.atirarFlecha = function() {
		this.flechas--;
		this.experiencia++;
	} */
	
}