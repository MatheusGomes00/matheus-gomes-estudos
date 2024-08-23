package tipoCuringa;

import java.util.Arrays;
import java.util.List;


// Com tipos curinga podemos fazer métodos
// que recebem um genérico de "qualquer tipo"
public class Exemplo1 {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printList(myInts);
    }

    // o Object seria a superclasse base para todos os tipos,
    // porém ao trabalhar com listas,
    // o supertipo é representado pela <?>
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
