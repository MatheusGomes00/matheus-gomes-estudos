package personalizado;

public class Program {


    public static void main(String[] args) {

        Client c1 = new Client("Pedro", "pedro@gmail.com");
        Client c2 = new Client("Maria", "maria@gmail.com");
        Client c3 = new Client("Maria", "maria@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c2.equals(c3));
        System.out.println(c2 == c3);


    }
}
