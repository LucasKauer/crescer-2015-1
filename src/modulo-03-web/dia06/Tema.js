/* CoffeeScript > JQuery 4ever 
 * Tem a sintaxe parecida com a do Ruby > all
 */
 
/* Normalize CSS eh show tambem
 * "flatuicolors(.com) eh uma paleta de cores na moda" by: Bernardo
 */

/* http://simplesideias.com.br/usando-jquery-na-pratica
 * http://zkdesign.com.br/tutoriais-e-artigos/seletores-jquery-parte-1
 * http://eufacoprogramas.com/jquery-selecao-de-elemento/
 */

// 1.A
var ex1A = $('.module');
console.log(ex1A);

// 1.B
/* https://api.jquery.com/nth-child-selector/ */
var ex1B = $('#myList:nth-child(2)');

/* Outras opcoes:
 * var ex1B = $('#myList li').eq(2);
 * var ex1B = $('#myList:eq(2)');
 */
 
console.log(ex1B);

// 1.C
var ex1C = $("#search label[for='q']");
/* or $("label[for='q']"); */
console.log(ex1C);

// 1.D
/* https://api.jquery.com/has-attribute-selector/ */
var ex1D = $('[alt]').length;
/* $('[alt]').size(); */
console.log(ex1D);

// 1.E
/* https://api.jquery.com/even-selector/
 * https://api.jquery.com/not-selector/
 * https://api.jquery.com/first-child-selector/
 */
var ex1E = $('#fruits tr:even:not(:first-child)');
/* $('#fruits tbody tr:odd'); */
console.log(ex1E);

// 1.F
/* https://api.jquery.com/attribute-contains-selector/ */
var ex1F = $('h2:contains("B"):contains("e")').length();
/* $('h2:contains("B"):contains(\'e\')').size(); */
console.log(ex1F);

// 1.G
var ex1G = $('#myList li:not(.current)');
console.log(ex1G);

// 1.H
/* Será? */
// GAMB $('img:eq(2), h3:last-of-type :last');
// Sem GAMB
$('img:last, h3:last');

/* $('li:last-of-type img, li:last-of-type h3');
 * $('html:last img:last, html:last h3:last');
 */

// 1.I
/* text() concatena tudo */
$('#myList .current ~ li').text().length;
/* $('#myList .current ~ li').nextAll().text().length; */

// 3.C

$('div.module')
	.last()
	.after(
		$('<div/>').addClass('module')
			.append(
				$('img:eq(0)' ).clone()
			)
	);
