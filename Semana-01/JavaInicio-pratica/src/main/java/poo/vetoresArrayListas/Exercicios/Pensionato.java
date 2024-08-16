package poo.vetoresArrayListas.Exercicios;

import java.util.Locale;
import java.util.Scanner;

public class Pensionato {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        AluguelPensionato[] vect = new AluguelPensionato[10];

        System.out.print("Quantos quartos serão alugados? ");
        int quant = sc.nextInt();

        for(int i=1; i <= quant; i++){
            System.out.println("Aluguel # " + i + ":");
            System.out.print("Name: ");
            sc.nextLine();  // limpar o buff
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Quarto: ");
            int roomNubmer = sc.nextInt();
            vect[roomNubmer] = new AluguelPensionato(name, email);
        }

        System.out.println("Quartos ocupados");
        for(int i=1; i < vect.length; i++){
            if(vect[i] != null){
                System.out.println(i + ": " + vect[i]);
            }
        }


        sc.close();
    }
}
