/* Avisa o JS para ele ser mais rigoroso e lancar erro para as besteiras do JS_10_dias */
'use strict';

a = 10;
console.log(a);

/* function Elfo (nome, flechas) {

	this.nome = nome;
	this.flechas = flechas || 42;
	this.experiencia = 0;
	
	// Duplica "objetos" (funcoes) em memória
	// this.atirarFlecha = function() {
	// this.flechas--;
	// this.experiencia++;
	// }
} */

/* Jeitinho maroto de não replicar código em memória */

function Elfo (options) {

	options = options || {};
	this.nome = options.nome;
	this.flechas = options.flechas || 42;
	this.experiencia = 0;
	
	// Duplica "objetos" (funcoes) em memória
	// this.atirarFlecha = function() {
	// this.flechas--;
	// this.experiencia++;
	// }
}

Elfo.prototype.atirarFlecha = function() {
	this.flechas--;
	this.experiencia++;
}