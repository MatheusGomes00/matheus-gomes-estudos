package poo.vetoresArrayListas.boxingUnboxing;

import java.util.Objects;

public class Program {
    public static void main(String[] args) {
        int x = 30;

        Object obj = x;

        System.out.println(obj);

        int y = (int) obj;

        System.out.println(y);
    }
}
