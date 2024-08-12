package poo.exemplo4;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBanc conta1;

        System.out.print("Enter account number: ");
        int cc1 = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine(); // necessário para consumir a quebra de linha
        String titular = sc.nextLine();
        System.out.println("Is there initial deposit value: ");
        char opDep = sc.next().charAt(0);
        if(opDep == 'y'){
            System.out.println("Enter initial deposit value: ");
            double initDep = sc.nextDouble();
            conta1 = new ContaBanc(cc1, titular, initDep);
        }else{
            conta1 = new ContaBanc(cc1, titular);
        }
        System.out.println("Account data: ");
        System.out.println(conta1);
        System.out.println("Enter a deposit value: ");
        double valorDep = sc.nextDouble();
        conta1.deposito(valorDep);
        System.out.println("Updated account data: ");
        System.out.println(conta1);

        System.out.println("Enter a withdraw value: ");
        double valorSaq = sc.nextDouble();
        conta1.saque(valorSaq);
        System.out.println("Updated account data: ");
        System.out.println(conta1);

        sc.close();
    }
}
