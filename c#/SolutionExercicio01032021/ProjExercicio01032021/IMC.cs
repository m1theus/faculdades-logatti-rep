using System;

namespace ProjExercicio01032021
{
    class IMC
    {
        public static void Main(String[] args)
        {
            float A, P, imc;

            Console.Write("Digite o seu peso:");
            P = float.Parse(Console.ReadLine());


            Console.Write("Digite o seu altura:");
            A = float.Parse(Console.ReadLine());

            imc = (P / (A * A));

            if (imc <= 18.5)
            {
                Console.WriteLine("Magreza, quando o resultado é menor que 18,5 kg/m2");
            }
            else if ((imc >= 18.5) && (imc <= 25))
            {
                Console.WriteLine("Normal, quando o resultado está entre 18,5 e 24,9 kg/m2");
            }
            else if ((imc >= 25) && (imc <= 30))
            {
                Console.WriteLine("Sobrepeso, quando o resultado está entre 24,9 e 30 kg/m2");
            }
            else if (imc >= 30)
            {
                Console.WriteLine("Obesidade, quando o resultado é maior que 30 kg/m2");
            }
            

            Console.ReadKey();


        }
    }
}
