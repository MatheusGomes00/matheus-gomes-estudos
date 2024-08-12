package exerciciosCondicional;

/*
Em um país imaginário denominado Lisarb, todos os habitantes ficam felizes em pagar seus impostos, pois sabem
que nele não existem políticos corruptos e os recursos arrecadados são utilizados em benefício da população, sem
qualquer desvio. A moeda deste país é o Rombus, cujo símbolo é o R$.
Leia um valor com duas casas decimais, equivalente ao salário de uma pessoa de Lisarb. Em seguida, calcule e
mostre o valor que esta pessoa deve pagar de Imposto de Renda, segundo a tabela abaixo.

RENDA                           IMPOSTO DE RENDA
de 0.0 até R$ 2000.00                 Isento
de R$ 2000.01 até R$ 3000.00            8%
de R$ 3000.01 até R$ 4500.00            18%
acima de R$ 4500.00                     28%


Lembre que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas sobre R$ 1000.00, pois a faixa de
salário que fica de R$ 0.00 até R$ 2000.00 é isenta de Imposto de Renda. No exemplo fornecido (abaixo), a taxa é
de 8% sobre R$ 1000.00 + 18% sobre R$ 2.00, o que resulta em R$ 80.36 no total. O valor deve ser impresso com
duas casas decimais.
 */


import java.util.Locale;
import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double salario = sc.nextDouble();
        double tax = 0;
        if(salario <= 2000){
            System.out.println("Isento");
        } else if (salario <= 3000) {
            tax = (salario - 2000) * 0.08;

        } else if (salario <= 4500) {
            tax = (salario - 3000.0) * 0.18 + 1000.0 * 0.08;

        } else if (salario > 4500){
            tax = (salario - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
        }if(salario > 2000){
            System.out.printf("R$ %.2f", tax);
        }

        // que bizarrice, demorei a entender...
        // o imposto é calculado por faixas salarial,
        // os primeiros 2000 são isentos, o resto do salario
        // é somando o imposto de cada faixa

        sc.close();
    }
}
