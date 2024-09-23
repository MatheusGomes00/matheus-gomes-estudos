package com.pb.spring_boot_erudio;


import com.pb.spring_boot_erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertDouble(numberOne) + convertDouble(numberTwo);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertDouble(numberOne) - convertDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return convertDouble(numberOne) * convertDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        if(convertDouble(numberTwo) == 0){
            throw new UnsupportedMathOperationException("Division by 0 unsupported. Please change zero second value.");
        } else {
            return convertDouble(numberOne) / convertDouble(numberTwo);
        }

    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return (convertDouble(numberOne) / convertDouble(numberTwo)) / 2;

    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) throws Exception{

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Math.sqrt(convertDouble(number));
    }

    private Double convertDouble(String strNumber) {
        if(strNumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        // A expressão regular dentro do método matches() está validando se a string number corresponde ao padrão de um
        // número decimal, que pode incluir um sinal de mais ou menos, parte inteira, e parte fracionária.
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");

    }
}
