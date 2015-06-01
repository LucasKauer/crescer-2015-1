using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication
{
    internal static class StringExtensions
    {
        internal static string ToBacon(/* this do prototype do JS */this string str, bool? upperCase = true)
        {
            if(upperCase.HasValue && upperCase.Value /* permite passar o tipo null no boolean ;D */)
            {
                return str + " BACON!!!";
            }
            else
            {
                return str + " bacon!!!";
            }
        }
    }
}
