package exerciciosPipeline.ex02.services;

import exerciciosPipeline.ex02.entities.Employee;
import predicate.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class EmployeeService {

    public double preidicateFilteredSum(List<Employee> list, Predicate<Employee> criteria){
        double sum = 0.0;
        for(Employee e: list){
            if(criteria.test(e)){
                sum += e.getSalary();
            }
        }
        return sum;
    }
}
