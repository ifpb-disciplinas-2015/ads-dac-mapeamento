package edu.ifpb.dac.idClass;

import edu.ifpb.dac.Dao;
import edu.ifpb.dac.DaoJPA;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ricardo Job
 */
public class Executor {
    
    static Dao dao = new DaoJPA("mapeamento");
   
    public static void main(String[] args) {
        PessoaChaveComposta pessoa = new PessoaChaveComposta("Job", "123");
        //Salvando
        dao.save(pessoa);
        //Localizando
        PessoaPK chave = new PessoaPK("Ricardo", "998899");
        PessoaChaveComposta copia = (PessoaChaveComposta) dao.find(PessoaChaveComposta.class, chave);
        System.out.println(copia);

    }


}
