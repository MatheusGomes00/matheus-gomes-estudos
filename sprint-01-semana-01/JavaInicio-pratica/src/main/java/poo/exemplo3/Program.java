package poo.exemplo3;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the dollar price? ");
        double dolar = sc.nextDouble();

        System.out.println("How many dollars will be bought? ");
        double valueDesired = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.dolar(dolar, valueDesired));
    }
}
