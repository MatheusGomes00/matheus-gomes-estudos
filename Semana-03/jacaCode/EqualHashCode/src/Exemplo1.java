public class Exemplo1 {
    public static void main(String[] args) {
        String a = "Maria";
        String b = "Alex";
        System.out.println(a.equals(b));

        a = "Maria";
        b = "Alex";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
