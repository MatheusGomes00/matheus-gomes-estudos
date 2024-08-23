package paramFunction.model.services;

import predicate.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductServices {
    public double filteredSum(List<Product> list){
        double sum = 0.0;
        for(Product p: list){
            if(p.getName().charAt(0) == 'T'){
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public double preidicateFilteredSum(List<Product> list, Predicate<Product> criteria){
        double sum = 0.0;
        for(Product p: list){
            if(criteria.test(p)){
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
