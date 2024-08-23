package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
/*
        Department obj = new Department(1, "Eletronics");

        Seller seller = new Seller(10, "Matias", "matias@gmail.com", new Date(), 5000.0, obj);

        // dessa forma eviatamos que a aplicação conheça a implementação
        // expomos somente a interface, fazendo uma injeção de dependencia
        // sem especificar a implementação
        SellerDao sellerDao = DaoFactory.createSellerDao();
*/
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj: list){
            System.out.println(obj);
        }
        // list.forEach(System.out::println);
    }
}
