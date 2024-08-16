package poo.vetoresArrayListas.forEach;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] vect = new String[] {"Maria", "Pedro", "Joao"};

        for (String obj: vect){
            System.out.println(obj);
        }

    }
}
