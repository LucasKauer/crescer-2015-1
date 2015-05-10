// 1. Brewdog
function brewdog(strA, strB) {
	var numeroCaracteresDiferentes = 0;
	/* var strMaior = strA.length > strB.length ? strA.length : strB.length; */
	var strMaior = Math.max(strA, strB);
	
	for(var i = 0; i < strMaior; i++) {
		/* var caracteresSaoIguais = (strA.charAt(i) != strB.charAt(i)); */
		if ((strA[i] != strB[i]) {
			numeroCaracteresDiferentes++;
		}
	}
	return numeroCaracteresDiferentes;
}

console.log(brewdog('bacon', 'beico')); // 4

[
    { params: ['american ipa','american ipa'],                        esperado: 0 },
    { params: ['russian imperial stout','russian imperial vodka'],    esperado: 5 },
    { params: ['1002012','dfgdf12'],                                  esperado: 5 },
    { params: ['k4rol1n','k4thr1n'],                                  esperado: 3 },
    { params: ['a1df222266%334op;','ssdfjfdkjgsdfgofdgudf9g8dufsg'],  esperado: 26 },
  ].forEach(
    function(ct) {
      var res = brewdog(ct.params[0], ct.params[1]);
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.params, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );
  
 // 2. Emprestimo
 