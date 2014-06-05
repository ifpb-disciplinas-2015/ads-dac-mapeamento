package edu.ifpb.dac.idClass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PessoaPK.class)
public class PessoaChaveComposta implements Serializable {

    @Id
    private String nome;
    @Id
    private String cpf;

    public PessoaChaveComposta() {
    }

    public PessoaChaveComposta(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{ nome= " + nome + ", cpf= " + cpf + '}';
    }
    //dataNascimento, idade...
}
