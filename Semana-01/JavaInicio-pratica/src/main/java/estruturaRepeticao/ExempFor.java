package estruturaRepeticao;

import java.util.Scanner;

public class ExempFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i=4; i>=0; i--) {
            System.out.println("Valor de i: " + i);
        }

        int N = sc.nextInt();
        int soma = 0;
        for(int i=0; i<N;i++){
            int x = sc.nextInt();
            soma += x;
        }
        System.out.println(soma);
    }
}
