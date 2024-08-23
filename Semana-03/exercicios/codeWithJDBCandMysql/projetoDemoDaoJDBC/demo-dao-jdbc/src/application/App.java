package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
//        for(Seller obj: list){
//            System.out.println(obj);
//        }
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Chris", "chris@gmail.com", new Date(), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n==== TEST 5: seller update ====");
        seller = sellerDao.findById(2);
        seller.setName("Matheus Gomes");
        sellerDao.update(seller);
        System.out.println("Updated!");

        System.out.println("\n==== TEST 6: seller delete ====");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}
