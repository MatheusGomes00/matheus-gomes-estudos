package exerciciosPipeline.ex02.application;

import exerciciosPipeline.ex01.entities.Product;
import exerciciosPipeline.ex02.entities.Employee;
import exerciciosPipeline.ex02.services.EmployeeService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            // Comparator<String> comp = String::compareTo;

            List<String> emails = list.stream()
                    .filter(e -> e.getSalary() >= salary)
                    .map(e -> e.getEmail())
                    .sorted()
                    .toList();

            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
            emails.forEach(System.out::println);

            EmployeeService es = new EmployeeService();
            double sumSalarys = es.preidicateFilteredSum(list, p -> p.getName().charAt(0) == 'M');
            System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", sumSalarys);

        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
        }

        sc.close();
    }
}
