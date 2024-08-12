package exerciciosWhile;

/*
Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva
um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel
4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até
que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a
mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme
exemplo.
 */

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int valorDigitado;
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        boolean encerrarPesquisa = true;

        while(encerrarPesquisa){
            valorDigitado = sc.nextInt();
            if(valorDigitado == 1){
                cont1 += 1;
            } else if (valorDigitado == 2) {
                cont2 += 1;
            } else if (valorDigitado == 3) {
                cont3 += 1;
            } else if (valorDigitado == 4) {
                encerrarPesquisa = false;
            }else{
                System.out.println("Código invalido");
            }
        }
        System.out.printf("MUITO OBRIGADO\nAlcool: %d%nGasolina: %d%nDiesel: %d%n", cont1, cont2, cont3);

        sc.close();
    }
}
