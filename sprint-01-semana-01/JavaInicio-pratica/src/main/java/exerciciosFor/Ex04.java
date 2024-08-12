package exerciciosFor;

/*
Fazer um programa para ler um número N. Depois leia N pares de números e mostre a divisão do primeiro pelo
segundo. Se o denominador for igual a zero, mostrar a mensagem "divisao impossivel"
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double x = 0;
        double y = 0;
        double resultado;

        for(int i=0; i < N; i++){
            x = sc.nextInt();
            y = sc.nextInt();

            if(y != 0){
                resultado = x / y;
                System.out.printf("%.1f%n", resultado);
            } else{
                System.out.println("divisao impossivel");
            }
        }

        sc.close();
    }
}
