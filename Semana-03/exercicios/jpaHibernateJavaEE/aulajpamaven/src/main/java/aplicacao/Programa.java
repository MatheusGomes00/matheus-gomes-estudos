package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /*
        Para trabalhar com os dados do banco, pecisa ser uma entidade monitorada...
        acabou de ser instancia da ou selecionada do banco.
         */

        Pessoa p = em.find(Pessoa.class, 3);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Done!");

        em.close();
        emf.close();

    }
}
