package poo.vetoresArrayListas.matriz;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i=0; i < n; i++){
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Diagonal principal: ");
        for(int i=0; i < n; i++){
            System.out.print(matrix[i][i] + " ");
        }
        int count = 0;
        for(int i=0; i < n; i++){
            for(int j=0; j<n; j++){
                if (matrix[i][j] < 0){
                    count++;
                }
            }
        }
        System.out.println("\nNumeros negativos: " + count);

        sc.close();
    }
}
