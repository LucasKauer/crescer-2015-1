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
	str = str.replace(/[^A-Za-z0-9]/g, ""); // retira os caracteres especiais da string
	return str;
}