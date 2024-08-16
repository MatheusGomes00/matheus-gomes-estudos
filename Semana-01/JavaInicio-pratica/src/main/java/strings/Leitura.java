package strings;

import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String x;
        x = sc.next();
        System.out.println("Você digitou o valor " + x);

        double x2;
        x2 = sc.nextDouble();
        System.out.println("Você digitou: " + x2);

        char x3;
        x3 = sc.next().charAt(0);
        System.out.println("A primeira letra digitada foi: " + x3);



        sc.close();
    }
}
