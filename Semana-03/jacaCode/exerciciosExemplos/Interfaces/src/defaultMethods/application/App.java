package defaultMethods.application;

import defaultMethods.services.InterestService;
import defaultMethods.services.UsaInterestService;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new UsaInterestService(1.0);
        double payment = is.payment(amount, months);

        System.out.print("Payment after " + months + " months: ");
        System.out.printf("%.2f%n", payment);


        sc.close();
    }
}
