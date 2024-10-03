package com.pb.spring_boot_erudio.basicCalculator.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TreatsNumbers implements Serializable {

    public Double convertDouble(String strNumber) {
        if(strNumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        // A expressão regular dentro do método matches() está validando se a string number corresponde ao padrão de um
        // número decimal, que pode incluir um sinal de mais ou menos, parte inteira, e parte fracionária.
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");

    }
}
