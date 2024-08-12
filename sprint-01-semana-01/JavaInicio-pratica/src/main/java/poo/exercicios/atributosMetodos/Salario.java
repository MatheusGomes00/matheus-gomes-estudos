package poo.exercicios.atributosMetodos;

public class Salario {
    public String name;
    public double bruto;
    public double taxa;
    public double salarioLiquido() {
        return bruto - taxa;
    }
    public void increaseSalary(double percentage) {
        bruto += bruto * percentage / 100.0;
    }
    public String toString() {
        return name + ", $ " + String.format("%.2f", salarioLiquido());
    }
}
