package dominio;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private Integer id;
    private String nome;
    private String email;

    public Pessoa(Integer id, String nome, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
