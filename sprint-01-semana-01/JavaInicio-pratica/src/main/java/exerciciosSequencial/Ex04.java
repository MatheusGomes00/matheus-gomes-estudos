package exerciciosSequencial;

/*
Fazer um programa que leia o número de um funcionário, seu
número de horas trabalhadas, o valor que recebe por hora e
calcula o salário desse funcionário. A seguir, mostre o
número e o salário do funcionário, com duas casas decimais.
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double number = sc.nextDouble();
        int hours = sc.nextInt();
        double valuePerHour = sc.nextDouble();
        double pay = hours * valuePerHour;

        System.out.println("NUMBER = " + number);
        System.out.printf("Salary = U$ %.2f", pay);

        sc.close();
    }
}
