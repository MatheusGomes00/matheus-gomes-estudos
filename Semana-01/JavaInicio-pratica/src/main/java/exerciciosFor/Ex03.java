package exerciciosFor;

import java.util.Locale;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double x;
        double y;
        double z;
        double media = 0;

        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            x = sc.nextDouble();
            y = sc.nextDouble();
            z = sc.nextDouble();
            media = ((x * 2) + (y * 3) + (z * 5))/ (2 + 3 + 5);
            System.out.printf("%.1f%n", media);
        }
    }
}
