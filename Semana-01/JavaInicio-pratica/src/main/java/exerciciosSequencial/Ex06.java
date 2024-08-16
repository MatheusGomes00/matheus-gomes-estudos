package exerciciosSequencial;

/*
Fazer um programa que leia três valores com ponto flutuante de
dupla precisão: A, B e C. Em seguida, calcule e
mostre:
a) a área do triângulo retângulo que tem A por base e C por altura.
b) a área do círculo de raio C. (pi = 3.14159)
c) a área do trapézio que tem A e B por bases e C por altura.
d) a área do quadrado que tem lado B.
e) a área do retângulo que tem lados A e B

 */

import java.util.Locale;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double A, B, C;

        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();
        double pi = 3.14159;

        double triRet = A * C / 2;
        System.out.printf("TRIANGULO: %.3f%n", triRet);

        double circle = pi * (C * C);
        System.out.printf("CIRCULO: %.3f", circle);

        double trapz = ((A + B) * C) / 2;
        System.out.printf("\nTRAPEZIO: %.3f", trapz);

        double quadrado = (B * B);
        System.out.printf("\nQUADRADO: %.3f%n", quadrado);

        double retang = A * B;
        System.out.printf("RETANGULO: %.3f", retang);

        sc.close();
    }
}
