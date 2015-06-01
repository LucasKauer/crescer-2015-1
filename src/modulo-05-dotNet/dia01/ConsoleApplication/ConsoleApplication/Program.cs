using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication
{
    class Program
    {
        private string _variavel;

        static void Main(string[] args)
        {

            #region dynamic

            dynamic oi = "Ta se loco!";
            oi += 10;

            Console.WriteLine(oi);

            #endregion

            #region anotacoes
            // por padrão as classes, variáveis e métodos são privados.
            // Crtl + f5 or Console. ReadLine()
            // Crtl + shift + b --> compile
            // Crtl + dot === Crtl + 1 (Eclipse)
            // Shift + f9 mudar o valor da variável em tempo de execucao
            // Crtl + K + U  --> Tira comentário da linha
            // Crtl + K + C --> Adiciona comentário da linha
            // Crtl + - --> Volta para onde estava
            #endregion

            #region Arraiii

            var numeros = new[] { 1, 2, 3 }.ToList(); /* transforma o arraiii numa lista */
            // numeros.Add(4);

            // var numeros = new List<int>(capacity: 10);

            #region ArraiiiAnotacoes
            // IList<int> numeros = new List<int>(new[] { 1, 2, 3 });
            
            /* List<int> numeros = new List<int>(); 
             * numeros.Add(1);
             * numeros.Add(2);
             * numeros.Add(3);
             * 
             * List nao eh interface no C# (Java eh).
             * IList é o List do Java (interface).
             */

            // numeros.AddRange(new[] { 4, 5 }) --> aceita uma colecao de numeros
            // numeros.Sum() --> Soma todos os numeros do arraiii
            // numeros.Avg() --> Faz a media do arraiii
            #endregion

            string str1 = "Ana";

            /*for (int i = 0; i < 10000; i++)
            {
                Console.WriteLine(i);
                // breakpoint condicional i > 7000
                // Shift + F5 --> para o debug
            }*/

            // C# mito já sabe o tipo do arraiii VAR
            //foreach (var i in numeros)
            //{
            //    console.writeline(i);
            //}

            Action<int> imprimir = i => Console.WriteLine(i + " bacon");

            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);

            /* numeros.ForEach((i) =>
                {
                    Console.WriteLine(i);
                });*/

            #endregion

            #region Extension Methods

            Console.WriteLine("Ana".ToBacon(/*false*/ /*null*/));

            #endregion

            #region Jedi

            // var yoda = new Jedi();
            var yoda = new Jedi/*()*/
            {
                Nome = "Yoda",
                Grau = Grau.MESTRE
            };

            var baconJedi = new
                {
                    Nome = yoda.Nome.ToBacon()
                };

            //yoda.Nome = "Yoda";

            Console.WriteLine(yoda.Nome);

            #endregion

            #region DateTime

            DateTime agora = DateTime.Now;

            #endregion

            Console.ReadLine();
        }
    }
}