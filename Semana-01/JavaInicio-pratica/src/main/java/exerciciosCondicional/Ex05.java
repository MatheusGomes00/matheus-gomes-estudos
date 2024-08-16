package exerciciosCondicional;

/*
Com base na tabela abaixo, escreva um programa que
leia o código de um item e a quantidade deste item. A
seguir, calcule e mostre o valor da conta a pagar.

    CODIGO      ESPECIFICACO            PRECO
    1           Cachorro quente         R$4.00
    2           X-Salada                R$4.50
    3           X-Bacon                 R$5.00
    4           Torrada Simples         R$2.00
    5           Refrigerante            R$1.50

 */

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total;
        int cod = sc.nextInt();
        int quant = sc.nextInt();

        switch (cod){
            case 1:
                total = quant * 4;
                System.out.printf("Total: R$ %.2f", total);
                break;
            case 2:
                total = quant * 4.5;
                System.out.printf("Total: R$ %.2f", total);
                break;
            case 3:
                total = quant * 5;
                System.out.printf("Total: R$ %.2f", total);
                break;
            case 4:
                total = quant * 2;
                System.out.printf("Total: R$ %.2f", total);
                break;
            default:
                total = quant * 1.5;
                System.out.printf("Total: R$ %.2f", total);
                break;
        }

        sc.close();
    }
}
