package edu.ifpb.dac.embedded;

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
        PessoaPKEmbedded key = new PessoaPKEmbedded("Ricardo Job", "123");
        PessoaChaveCompostaEmbedded pessoa = new PessoaChaveCompostaEmbedded(key);
        salvar(pessoa);
        //Localizando
//        PessoaPKEmbedded chave = new PessoaPKEmbedded("Job", "123");
//        PessoaChaveCompostaEmbedded copia = localizarEmbedded(chave);
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

    public static PessoaChaveCompostaEmbedded localizarEmbedded(Object object) {
        return em.find(PessoaChaveCompostaEmbedded.class, object);
    }
}
