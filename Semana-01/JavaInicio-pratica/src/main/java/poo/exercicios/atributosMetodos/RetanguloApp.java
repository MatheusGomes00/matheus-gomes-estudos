package poo.exercicios.atributosMetodos;

import java.util.Locale;
import java.util.Scanner;

public class RetanguloApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Retangulo rect = new Retangulo();
        System.out.println("Enter rectangle width and height:");
        rect.largura = sc.nextDouble();
        rect.altura = sc.nextDouble();
        System.out.printf("AREA = %.2f%n", rect.area());
        System.out.printf("PERIMETER = %.2f%n", rect.perimeter());
        System.out.printf("DIAGONAL = %.2f%n", rect.diagonal());
        sc.close();
    }
}
