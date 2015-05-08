var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var manchester_city = {
  nome: 'Manchester City Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 2 }
  ]
};

var clubes_ingleses = [ arsenal, chelsea, liverpool, manchester_city ]

// 2.A
function ordenaPorNacionais(a, b) {
	if (a.titulos[0].qtd > b.titulos[0].qtd) {
		return -1;
	} else if(a.titulos[0].qtd < b.titulos[0].qtd) {
		return 1;
	} else {
		return 0;
	}
}

clubes_ingleses.sort(ordenaPorNacionais);
clubes_ingleses;

// 2.B
function ordenaPorContinentais(a, b) {
	if (a.titulos[1].qtd > b.titulos[1].qtd) {
		return -1;
	} else if(a.titulos[1].qtd < b.titulos[1].qtd) {
		return 1;
	} else {
		return 0;
	}
}

clubes_ingleses.sort(ordenaPorContinentais);
clubes_ingleses;

// 2.C
function ordenaPorMundiais(a, b) {
	if (a.titulos[2].qtd > b.titulos[2].qtd) {
		return -1;
	} else if(a.titulos[2].qtd < b.titulos[2].qtd) {
		return 1;
	} else {
		return 0;
	}
}

clubes_ingleses.sort(ordenaPorMundiais);
clubes_ingleses;

// 3.A
function somarPorNacionais(arr) {
	var soma = 0;
	var nacionais = arr.map(
		function(i) {
			return i.titulos[0].qtd;
		});
	nacionais.forEach(
		function(valorAtual) {
			soma += valorAtual;
		});
	return soma;
}