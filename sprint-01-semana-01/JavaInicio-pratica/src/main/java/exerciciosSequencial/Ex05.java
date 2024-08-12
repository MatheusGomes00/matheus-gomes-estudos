package exerciciosSequencial;

/*
Fazer um programa para ler o código de uma peça 1, o
número de peças 1, o valor unitário de cada peça 1,
o código de uma peça 2, o número de peças 2 e o valor
unitário de cada peça 2. Calcule e mostre o valor a ser pago.
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int codP1 = sc.nextInt();
        int numbP1 = sc.nextInt();
        double priceP1 = sc.nextDouble();
        double valueP1 = amount(numbP1, priceP1);

        int codP2 = sc.nextInt();
        int numbP2 = sc.nextInt();
        double priceP2 = sc.nextDouble();
        double valueP2 = amount(numbP2, priceP2);

        double amount = valueP1 + valueP2;

        System.out.printf("VALOR A PAGAR: R$ %.2f", amount );

        sc.close();

    }
    public static double amount(int numberOf, double priceOf){
        return numberOf * priceOf;
    }
}
