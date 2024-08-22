package tipoCuringa.curingasDelimitados.application;

import tipoCuringa.curingasDelimitados.entities.Circle;
import tipoCuringa.curingasDelimitados.entities.Rectangle;
import tipoCuringa.curingasDelimitados.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(myCircles));

        // Porém não é possível adicionar dados a uma
        //coleção de tipo curinga
        // List<?> list = new ArrayList<Integer>();
        // list.add(3); // erro de compilação
        // O compilador não sabe qual é o tipo específico do qual a lista foi instanciada.
    }

    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }
}
