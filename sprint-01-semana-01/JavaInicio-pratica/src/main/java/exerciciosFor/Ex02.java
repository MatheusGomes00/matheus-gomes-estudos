package exerciciosFor;

/*
Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X que serão lidos em seguida.
Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos estão fora do intervalo, mostrando
essas informações conforme exemplo (use a palavra "in" para dentro do intervalo, e "out" para fora do intervalo).
 */

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int entrada = 0;
        int contIn = 0;
        int contOut = 0;

        for(int i = 0; i < N; i++){
            entrada = sc.nextInt();
            if(entrada >= 10 && entrada <= 20){
                contIn += 1;
            }else {
                contOut += 1;
            }
        }
        System.out.println(contIn + " in\n" + contOut + " out");

        sc.close();
    }
}
