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

/* Testar essas resoluções
 * var ex1B = $('#myList li').eq(2);
 * var ex1B = $('#myList li:eq(2)');
 */
 
console.log(ex1B);

// 1.C
var ex1C = $("label[for='q']");
console.log(ex1C);

// 1.D
/* https://api.jquery.com/has-attribute-selector/ */
var ex1D = $('[alt]').length;
console.log(ex1D);

// 1.E
/* https://api.jquery.com/even-selector/
 * https://api.jquery.com/not-selector/
 * https://api.jquery.com/first-child-selector/
 */
var ex1E = $('#fruits tr:even:not(:first-child)');
console.log(ex1E);

// 1.F
/* https://api.jquery.com/attribute-contains-selector/ */
var ex1F = $('h2:contains("B"):contains("e")')
console.log(ex1F);

// 1.G
var ex1G = $('#myList li:not(.current)');
console.log(ex1G);

// 1.H
/* Será? */
// GAMB $('img:eq(2), h3:last-of-type :last');
// Sem GAMB
$('img:last, h3:last-of-type :last');

// 1.I