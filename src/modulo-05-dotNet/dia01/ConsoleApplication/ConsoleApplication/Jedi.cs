using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication
{
    internal class Jedi
    {
        internal string Nome { get; /*private --> agora ninguém mais pode usar o set*/ /*private*/ set; } // programacao orientada a propriedade

        internal Grau Grau { get; set; }
    }
}