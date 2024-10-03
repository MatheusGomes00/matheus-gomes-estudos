package com.pb.spring_boot_erudio.basicCalculator.service;

import com.pb.spring_boot_erudio.basicCalculator.exceptions.UnsupportedMathOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Operations {

    private final TreatsNumbers treats;

    public Double sum(String numberOne, String numberTwo) {

        if(!treats.isNumeric(numberOne) || (!treats.isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return treats.convertDouble(numberOne) + treats.convertDouble(numberTwo);
    }


    public Double sub(String numberOne, String numberTwo) {

        if(!treats.isNumeric(numberOne) || (!treats.isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return treats.convertDouble(numberOne) - treats.convertDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo) {

        if(!treats.isNumeric(numberOne) || (!treats.isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        return treats.convertDouble(numberOne) * treats.convertDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo) {

        if(!treats.isNumeric(numberOne) || (!treats.isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }
        if(treats.convertDouble(numberTwo) == 0){
            throw new UnsupportedMathOperationException("Division by 0 unsupported. Please change zero second value.");
        } else {
            return treats.convertDouble(numberOne) / treats.convertDouble(numberTwo);
        }
    }

    public Double mean(String numberOne, String numberTwo) {

        if(!treats.isNumeric(numberOne) || (!treats.isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return (treats.convertDouble(numberOne) / treats.convertDouble(numberTwo)) / 2;
    }

    public Double sqrt(String number) {

        if(!treats.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value.");
        }

        return Math.sqrt(treats.convertDouble(number));
    }

}
