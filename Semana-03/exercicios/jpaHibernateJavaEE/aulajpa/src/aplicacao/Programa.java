package aplicacao;

import dominio.Pessoa;

public class Programa {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Matheus Gomes", "matheus@gmail.com");
        Pessoa p2 = new Pessoa(1, "Maria Borges", "maria@gmail.com");
        Pessoa p3 = new Pessoa(1, "Sergio Varo", "sergio@gmail.com");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);


    }
}
