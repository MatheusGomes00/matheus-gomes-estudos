package application;

import entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Program3 {
    public static void main(String[] args) {
        Set<Product> set = new HashSet<>();
        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));
        Product prod = new Product("Notebook", 1200.0);

        // se os métodos hashCode e equals não forem criadas na classe Product
        // o compilador usa os ponteiros como referencia, apontando para endereços diferentes
        // então nas comparações de igualdade ou existencia vai sempre retornar false
        System.out.println(set.contains(prod));


    }
}
