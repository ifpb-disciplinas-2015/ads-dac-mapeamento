package edu.ifpb.dac.embedded;

import edu.ifpb.dac.Dao;
import edu.ifpb.dac.DaoJPA;

/**
 *
 * @author Ricardo Job
 */
public class Executor {

    static Dao dao = new DaoJPA("mapeamento");
    
    public static void main(String[] args) {
        PessoaPKEmbedded key = new PessoaPKEmbedded("Ricardo Job", "123");
        PessoaChaveCompostaEmbedded pessoa = new PessoaChaveCompostaEmbedded(key);
        dao.save(pessoa);
        //Localizando
        PessoaPKEmbedded chave = new PessoaPKEmbedded("Ricardo Job", "123");
        PessoaChaveCompostaEmbedded copia = (PessoaChaveCompostaEmbedded) dao.find(PessoaChaveCompostaEmbedded.class, chave);//localizarEmbedded(chave);
        System.out.println(copia);

    }
}
