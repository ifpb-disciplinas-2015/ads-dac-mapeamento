package edu.ifpb.dac.idClass;

import java.io.Serializable;

/**
 *
 * @author Ricardo Job
 */
public class PessoaPK implements Serializable {

    private String nome;
    private String cpf;

    public PessoaPK() {
    }

    public PessoaPK(String nome, String cpf) {
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
        final PessoaPK other = (PessoaPK) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 41 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        return hash;
    }
}
