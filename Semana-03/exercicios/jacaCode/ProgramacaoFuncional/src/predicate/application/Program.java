package predicate.application;

import predicate.entities.Product;
import predicate.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // list.removeIf(p -> p.getPrice() >= 100);

        // list.removeIf(new ProductPredicate());  // implementação do Predicate em uma classe

        // list.removeIf(Product::staticProductPredicate);   // method reference static, referencia para metodo

        // list.removeIf(Product::nonStaticProductPredicate);  // method reference nonStatic

        //  Predicate<Product> pred =p -> p.getPrice() >= 100;
        //  list.removeIf(pred);  // lambda declarada


        list.removeIf(p -> p.getPrice() >= 100);  // lambda inline

        for(Product p: list){
            System.out.println(p);
        }

    }
}
