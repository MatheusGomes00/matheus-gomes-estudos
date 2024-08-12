package exerciciosCondicional;

/*
Leia 2 valores inteiros (A e B). Após, o programa deve mostrar
uma mensagem "Sao Multiplos" ou "Nao sao Multiplos", indicando
se os valores lidos são múltiplos entre si. Atenção: os
números devem poder ser digitados em ordem crescente ou decrescente.
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int A, B, maior, menor;

        A = sc.nextInt();
        B = sc.nextInt();
        if (A % B == 0) {
            System.out.println("São Multiplos");
        } else if(B % A == 0) {
            System.out.println("São Multiplos");
        }else{
            System.out.println("Não sao Multiplos");
        }

        sc.close();
    }
}
