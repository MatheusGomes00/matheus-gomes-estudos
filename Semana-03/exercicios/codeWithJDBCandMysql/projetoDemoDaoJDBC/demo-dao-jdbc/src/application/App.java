package application;

import entities.Department;
import entities.Seller;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        Department obj = new Department(1, "Eletronics");

        Seller seller = new Seller(10, "Matias", "matias@gmail.com", new Date(), 5000.0, obj);

        System.out.println(seller);


    }
}
