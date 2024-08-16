package poo.exercicios.atributosMetodos;

import java.util.Locale;
import java.util.Scanner;

public class SalarioApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Salario emp = new Salario();
        System.out.print("Name: ");
        emp.name = sc.nextLine();
        System.out.print("Gross salary: ");
        emp.bruto = sc.nextDouble();
        System.out.print("Tax: ");
        emp.taxa = sc.nextDouble();

        System.out.println("\nEmployee: " + emp);

        System.out.print("\nWhich percentage to increase salary? ");
        double percentage = sc.nextDouble();
        emp.increaseSalary(percentage);

        System.out.println("\nUpdated data: " + emp);

        sc.close();
    }
}
