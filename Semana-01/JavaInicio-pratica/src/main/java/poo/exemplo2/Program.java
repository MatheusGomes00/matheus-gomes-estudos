package poo.exemplo2;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    // public static final double PI = 3.14159;  // final define que a váriável é contante

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // Calculator calc = new Calculator();

        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();
        double c = Calculator.circumference(radius);
        double v = Calculator.volume(radius);

        System.out.printf("Circunference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", Calculator.PI);

        sc.close();
    }

/*   public static double circumference(double radius){
//        return 2.0 * PI * radius;
//    }
//
//    public static double volume(double radius){
//        return 4.0 * PI * radius * radius * radius / 3.0;
    }
*/
}
