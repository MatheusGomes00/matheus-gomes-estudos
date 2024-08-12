package poo.vetoresArrayListas.Exercicios;

public class AluguelPensionato {
    private String name, email;

    public AluguelPensionato(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ", " + email;
    }

    public AluguelPensionato() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
