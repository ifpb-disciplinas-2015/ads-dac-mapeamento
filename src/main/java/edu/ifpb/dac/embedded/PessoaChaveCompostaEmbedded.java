package edu.ifpb.dac.embedded;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PessoaChaveCompostaEmbedded implements Serializable {

    @EmbeddedId
    /* @AttributeOverrides({
    @AttributeOverride(name = "nome", column =
    @Column(name = "PESSOA_NOME")),
    @AttributeOverride(name = "idade", column =
    @Column(name = "PESSOA_IDADE"))})*/
    private PessoaPKEmbedded chave;

    public PessoaChaveCompostaEmbedded() {
    }

    public PessoaChaveCompostaEmbedded(PessoaPKEmbedded chave) {
        this.chave = chave;
    }

    public PessoaPKEmbedded getChave() {
        return chave;
    }

    public void setChave(PessoaPKEmbedded chave) {
        this.chave = chave;
    }

    @Override
    public String toString() {
        return "PessoaChaveCompostaEmbedded{" + "chave=" + chave + '}';
    }
}
