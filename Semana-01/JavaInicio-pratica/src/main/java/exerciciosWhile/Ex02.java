package exerciciosWhile;

/*
Escreva um programa para ler as coordenadas (X,Y)
de uma quantidade indeterminada de pontos no sistema
cartesiano. Para cada ponto escrever o quadrante a que
ele pertence. O algoritmo será encerrado quando pelo
menos uma de duas coordenadas for NULA (nesta situação
sem escrever mensagem alguma).
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double x, y;
        boolean response=true;

        while(response){
            x = sc.nextDouble();
            y = sc.nextDouble();
            if(x > 0 && y > 0){
                System.out.println("primeiro");
            } else if (x < 0 && y > 0) {
                System.out.println("segundo");

            }else if (x < 0 && y < 0){
                System.out.println("terceiro");
            } else if (x > 0 && y < 0) {
                System.out.println("quarto");
            }else{
                response = false;
            }
        }


        sc.close();
    }

}
