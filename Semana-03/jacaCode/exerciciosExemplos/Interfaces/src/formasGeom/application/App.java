package formasGeom.application;

import formasGeom.model.entities.AbstractShape;
import formasGeom.model.entities.Circle;
import formasGeom.model.entities.Rectangle;
import formasGeom.model.enums.Color;

public class App {
    public static void main(String[] args) {

        AbstractShape aS1 = new Circle(Color.WHITE, 2.0);
        AbstractShape aS2 = new Rectangle(Color.BLACK, 3.0, 7.0);

        System.out.println("Circle color: " + aS1.getColor());
        System.out.println("Circle area: " + String.format("%.3f", aS1.area()));
        System.out.println("Rectangle color: " + aS2.getColor());
        System.out.println("Rectangle area: " + String.format("%.3f", aS2.area()));



    }
}
