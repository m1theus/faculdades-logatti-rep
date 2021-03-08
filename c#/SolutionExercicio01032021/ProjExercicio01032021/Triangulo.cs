using System;

namespace ProjExercicio01032021
{
    class Triangulo
    {
        public static void Main(String[] args)
        {
            int A;
            int B;
            int C;

            Console.Write("Informe o lado A: ");
            A = Convert.ToInt32(Console.ReadLine());

            Console.Write("Informe o lado B: ");
            B = Convert.ToInt32(Console.ReadLine());

            Console.Write("Informe o lado C: ");
            C = Convert.ToInt32(Console.ReadLine());

            if ((A < B + C) && (B < A + C) && (C < A + B))
            {

                if ((A == B) && (B == C))
                {
                    Console.Write("Triângulo Equilátero");

                }
                else if ((A == B) || (B == C) || (A == C))
                {
                    Console.Write("Triângulo Isósceles");
                }
                else
                {
                    Console.Write("Triângulo Escaleno");
                }

            }
            else
            {
                Console.Write("Os valores informado não formam um triângulo!");
            }

            Console.ReadKey();
        }
    }
}
