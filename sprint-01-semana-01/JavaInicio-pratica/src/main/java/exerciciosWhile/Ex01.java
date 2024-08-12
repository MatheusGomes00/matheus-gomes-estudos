package exerciciosWhile;

/*
Escreva um programa que repita a leitura de uma senha até
que ela seja válida. Para cada leitura de senha incorreta
informada, escrever a mensagem "Senha Invalida". Quando a
senha for informada corretamente deve ser impressa a
mensagem "Acesso Permitido" e o algoritmo encerrado.
Considere que a senha correta é o valor 2002.
 */

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tentativa;
        while(true){
            tentativa = sc.nextInt();
            if(tentativa == 2002){
                System.out.println("Acesso Permitido");
                break;
            }else{
                System.out.println("Senha invalida");
                continue;
            }
        }

        sc.close();
    }
}
