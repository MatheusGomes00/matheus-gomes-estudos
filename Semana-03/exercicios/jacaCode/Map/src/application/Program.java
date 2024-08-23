package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Joca");
        cookies.put("email", "joca@teste.com");
        cookies.put("phone", "35999794638");

        cookies.remove("email");
        cookies.put("phone", "35999999999");  // chaves iguais recebem valores sobrepostos

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Size: " + cookies.size());



        System.out.println("All cookies:");
        for(String key: cookies.keySet()){
            System.out.println(key + " " + cookies.get(key));
        }


    }
}
