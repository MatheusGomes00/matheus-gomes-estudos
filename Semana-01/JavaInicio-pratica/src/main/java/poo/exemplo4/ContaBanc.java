package poo.exemplo4;

public class ContaBanc {
    private final int numeroCC;
    private String nome;
    private double saldo;

    public ContaBanc(int numeroCC, String nome, double depositoInicial) {
        this.numeroCC = numeroCC;
        this.nome = nome;
        deposito(depositoInicial);
    }

    public ContaBanc(int numeroCC, String nome) {
        this.numeroCC = numeroCC;
        this.nome = nome;
    }

    public int getNumeroCC() {
        return numeroCC;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public void saque(double valor){
        this.saldo -= (valor + 5);
    }

    @Override
    public String toString() {
        return "Account " + numeroCC +
                ", Holder: " + nome + '\'' +
                ", Balance: $ " + saldo;
    }
}
