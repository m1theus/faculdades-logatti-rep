using System;

namespace ProjExercicio01032021
{
    class Eq2Grau
    {
        public static void Main(String[] args)
        {
            double a, b, c;
            double delta;
            double x1, x2, x;


            Console.WriteLine("Informe o valor de A:");
            a = double.Parse(Console.ReadLine());
            Console.WriteLine("Informe o valor de B:");
            b = double.Parse(Console.ReadLine());
            Console.WriteLine("Informe o valor de C:");
            c = double.Parse(Console.ReadLine());



            if (a == 0 && b == 0 && c == 0)
            {
                Console.WriteLine("A, B e C devem ser diferentes de 0!");
            }
            else
            {
                delta = b * b - 4 * a * c;

                if (delta < 0)
                {
                    Console.WriteLine("Esta equação não possui raizes reais!");
                }
                else if (delta == 0)
                {
                    x = (-b + Math.Sqrt(delta)) / (2 * a);
                    Console.WriteLine(String.Format("x = {0}", x));
                }
                else
                {
                    x1 = (-b + Math.Sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.Sqrt(delta)) / (2 * a);

                    Console.WriteLine(String.Format("x1 = {0}", x1));
                    Console.WriteLine(String.Format("x2 = {0}", x2));
                }
            }

            Console.ReadKey();


        }
    }
}
