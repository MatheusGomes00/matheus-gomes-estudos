package poo.exemplo3;

public  class CurrencyConverter {
    public static final double IOF = 0.06;

    public static double dolar(double dolar, double valueDesired){
        double amount = dolar * valueDesired;
        double tax = IOF * amount;
        return amount + tax;
    }
}
