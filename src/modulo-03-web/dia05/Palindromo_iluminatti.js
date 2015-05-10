// 3
var palindromoIluminatti = function (str) {
	
	var cleanStr = clear(str);
	/* http://marizmelo.com/2013/04/25/js_reverse_string.html */
	var cleanStrInvertida = cleanStr.split("").reverse().join("");
	
	var arrIluminatti = [
		"iluminatti",
		"ledesma",
		"dante",
		"verdemusgo",
		"bacon"
	]
	
	if (cleanStr === cleanStrInvertida) {
		return true;
	} else if(cleanStr === "iluminatti" || cleanStr === "ledesma" || cleanStr === "dante" || cleanStr === "verdemusgo" || cleanStr === "bacon") {
		return true;
	} else {
		return false;
	}
	
};

/* Script para testar o Palindromo Iluminatti */
[
	{ teste: 'ovo',                                         esperado: true },
	{ teste: 'ôvo',                                         esperado: true },
	{ teste: 'arara',                                       esperado: true },
	{ teste: 'rodador',                                     esperado: true },
	{ teste: 'O tRoTe ToRtO',                               esperado: true },
	{ teste: 'bacon',                                       esperado: true },
	{ teste: 'A miss é péssima!',                           esperado: true },
	{ teste: 'VERDE musgo!!',                               esperado: true },
	{ teste: 'Nova Schin, cervejão!',                       esperado: false },
	{ teste: 'camigoal',                                    esperado: false },
	{ teste: 'ledesma@@@@@@@@',                             esperado: true },
	{ teste: '!!d@ante!?!?',                                esperado: true },
	{ teste: '1@ilu$$$m1in$$$$$$$$$$4att$$$$$$$$1i!!!!!',   esperado: true }
].forEach(
	function(ct) {
		var res = palindromo(ct.teste);
		console.assert(res === ct.esperado, 'Errooooou! CT:', ct.teste, 'Esperado:', ct.esperado, 'Obtido:', res);
	}
);

// clear
function clear(str) {
	str = str.replace(/^\s+|\s+$/g, ""); // retira espacos do inicio e do fim
	str = str.replace(/\s{2,}/g, " "); // retira espacos duplicados

	replacements = {
		"[áãàäâª]": "a",
		"[éèëê]": "e",
		"[íìï]": "i",
		"[óòôõö]": "o",
		"[ùúûü]": "u",
		"[ç]": "c"
	}; // substituicoes
 
	regex = {}; // expressoes regulares

	for (i in /* enquanto i estiver contido */ replacements) {
		regex[i] = new RegExp(i, 'g' /* pega todas as ocorrencias do padrao na sequencia de caracteres pesquisada*/ );
	}

	for(i in replacements){
		str = str.replace(regex[i], replacements[i]); // substitui caracteres acentuados
	}
	
	str = str.toLowerCase(); // coloca a string em minusculo
	str = str.replace(/[^A-Za-z]/g, ""); // retira os caracteres especiais (e numeros) da string 
	return str;
}