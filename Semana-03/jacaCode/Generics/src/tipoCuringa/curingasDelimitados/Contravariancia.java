package tipoCuringa.curingasDelimitados;

import java.util.ArrayList;
import java.util.List;

public class Contravariancia {
    public static void main(String[] args) {
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs;
        myNums.add(10);  // --> put ok
        myNums.add(3.14);  // --> put ok
        // Number x = myNums.get(0); // --> get error de compilaca
    }
}
