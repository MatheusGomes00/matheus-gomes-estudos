package poo.vetoresArrayListas.exemplo1;

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] vect = new double [n];  // cria um vetor vect de tamanho n
        for (int i=0; i<n; i++){
            vect[i] = sc.nextDouble();
        }
        double sum = 0.0;
        for(int i=0; i<n; i++){
            sum += vect[i];
        }
        double avg = sum / n;
        System.out.printf("AVARAGE HEIGHT: %.2f", avg);
        sc.close();

    }
}
