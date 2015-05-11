//2.B
console.log(emprestimo.valorParcela()); // 269.03

/* 2. Emprestimo */
function Emprestimo(valorTotal, taxaDeJuros, quantidadeParcelas) {
	
	// 2.A
	this.valorTotal = valorTotal;
	this.taxaDeJuros = taxaDeJuros;
	this.quantidadeParcelas = quantidadeParcelas || 3;
	
	// 2.B
	this.valorParcela = function() {
		
		var valor = (this.valorTotal * this.taxaDeJuros) / (1 - (1 / Math.pow((1 + this.taxaDeJuros), this.quantidadeParcelas)));
		/* return parseFloat(valor.toFixed(2)); */
		return (Math.round (valor * 100) / 100);
	}
}

// 2.A
var emprestimo = new Emprestimo(1000, 0.03, 4);
console.log(emprestimo.valorTotal); // 1000

var emprestimo2 = new Emprestimo(500, 0.05);
console.log(emprestimo2.quantidadeParcelas); // 3

// 2.B
console.log(emprestimo.valorParcela()); // 269.03

/* Script para testar a funcao valorParcela */
[
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 269.03 },
    { emprestimo: new Emprestimo(1800, 0.05, 8),  esperado: 278.5 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 183.6 },
].forEach(
    function(ct) {
      var res = ct.emprestimo.valorParcela();
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
);