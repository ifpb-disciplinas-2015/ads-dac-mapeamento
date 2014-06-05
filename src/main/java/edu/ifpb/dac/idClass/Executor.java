package edu.ifpb.dac.idClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo Job
 */
public class Executor {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mapeamento");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        PessoaChaveComposta pessoa = new PessoaChaveComposta("Ricardo", "998899");
        //Salvando
        salvar(pessoa);
        //Localizando
//        PessoaPK chave = new PessoaPK("Job", "123");
//        PessoaChaveComposta copia = localizar(chave);
//        System.out.println(copia);

    }

    public static void salvar(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
            System.out.println("Sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public static PessoaChaveComposta localizar(Object object) {
        return em.find(PessoaChaveComposta.class, object);
    }
}
