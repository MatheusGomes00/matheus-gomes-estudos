package function.application;

import function.util.UpperCaseName;
import predicate.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //  List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        //  map aplica uma função a cada item de uma coleção de valores

        //  List<String> names = list.stream().map(Product::staticUpperCaseName).toList();

        //  List<String> names = list.stream().map(Product::nonStaticUpperCaseName).toList();

        //  Function<Product, String> func = p -> p.getName().toUpperCase();
        //  List<String> names = list.stream().map(func).toList();

        List<String> names = list.stream().map(p -> p.getName().toUpperCase()).toList();


        names.forEach(System.out::println);

    }
}
