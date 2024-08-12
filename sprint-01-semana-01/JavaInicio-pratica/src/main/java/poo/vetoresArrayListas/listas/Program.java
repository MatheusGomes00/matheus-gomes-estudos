package poo.vetoresArrayListas.listas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Matheus");
        list.add("Maria");
        list.add("Joao");
        list.add("Flavio");
        list.add("Anna");
        list.add("Lets");
        list.add("Fernanda");
        list.add("Erick");
        list.add(2, "Pedro");

        System.out.println(list.size());

        list.remove(5);
        list.remove("Joao");

        for(String obj: list){
            System.out.println(obj);
        }

        System.out.println("---------------");

        list.remove(1);
        list.removeIf(x -> x.charAt(0) == 'M');  // remove aqueles que começam com 'M'

        for(String obj: list){
            System.out.println(obj);
        }

        System.out.println("------------------");
        System.out.println("Index of Lets" + list.indexOf("Lets") );
        System.out.println("------------------");

        // criar uma nova lista, apenas com os iniciados em 'F':
        // primeiro criamos uma stream, depois aplicamos a expressao lambida sem retorno,
        // e por fim convertemos para uma lista
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'F').collect(Collectors.toList());
        for(String obj: result){
            System.out.println(obj);
        }
        System.out.println("------------------");
        // encontrar o primeiro elemento, que começa com 'F'
        // criamos uma stream, aplicamos uma lambda para filtrar os que iniciam com F,
        // depois chamaos o findFirst da primeira ocorrencia, é um optional e orElse null;
        String name = list.stream().filter(x -> x.charAt(0) == 'F').findFirst().orElse(null);
        System.out.println(name);



    }
}
