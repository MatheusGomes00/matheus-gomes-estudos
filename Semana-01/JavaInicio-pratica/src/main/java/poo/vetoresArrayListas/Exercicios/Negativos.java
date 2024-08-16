package poo.vetoresArrayListas.Exercicios;

import java.util.Scanner;

public class Negativos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros vai digitar?");
        int n = sc.nextInt();

        int[] vet = new int[n];

        for(int i=0; i< vet.length; i++){
            System.out.print("Digite um numero:");
            vet[i] = sc.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS: ");
        for(int j = 0; j < vet.length; j++){
            if(vet[j] < 0){
                System.out.println(vet[j]);
            }
        }

        sc.close();
    }
}
