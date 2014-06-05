    package edu.ifpb.dac.embedded;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ricardo Job
 */
@Embeddable
public class PessoaPKEmbedded implements Serializable {

    @Column(name = "PESSOA_NOME")
    private String nome;
    @Column(name = "PESSOA_CPF")
    private String cpf;

    public PessoaPKEmbedded() {
    }

    public PessoaPKEmbedded(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaPKEmbedded other = (PessoaPKEmbedded) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PessoaPKEmbedded{" + "nome=" + nome + "cpf=" + cpf + '}';
    }
}
