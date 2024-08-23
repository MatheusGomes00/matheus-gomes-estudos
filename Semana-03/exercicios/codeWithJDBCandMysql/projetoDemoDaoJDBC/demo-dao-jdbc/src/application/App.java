package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.util.Date;

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

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);


    }
}
