package application;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        // hashSet, não respeita ordem de insersao
        // linkedHashSet respeita
        Set<String> set = new HashSet<>();
        Set<String> set2 = new LinkedHashSet<>();

        set.add("Bola");
        set.add("Bike");
        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        for (String p : set) {
            System.out.println(p);
        }

        System.out.println();

        set2.add("Bola");
        set2.add("Bike");
        set2.add("TV");
        set2.add("Notebook");
        set2.add("Tablet");



        set.removeIf(x -> x.length() >= 4);
        for (String p : set) {
            System.out.println(p);
        }

        System.out.println();
        System.out.println(set.contains("Notebook"));



        System.out.println();
        for (String p : set2) {
            System.out.println(p);
        }

    }
}
