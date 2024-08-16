package poo.exercicios.atributosMetodos;

public class Retangulo {
    public double largura;
    public double altura;
    public double area() {
        return largura * altura;
    }
    public double perimeter() {
        return 2 * (largura + altura);
    }
    public double diagonal() {
        return Math.sqrt(largura * largura + altura * altura);
    }
}
