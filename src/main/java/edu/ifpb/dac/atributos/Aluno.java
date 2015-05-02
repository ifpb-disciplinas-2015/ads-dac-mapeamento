package edu.ifpb.dac.atributos;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Ricardo Job
 */
@Entity
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    public Aluno() {
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = new Matricula(matricula);
    }
    @Transient
    private Matricula matricula;

    @Access(AccessType.PROPERTY)
    @Column(name = "matricula_aluno")
    private String getMatriculaSimples() {
        return this.matricula.simples();
    }

    public String getMatriculaFormatada() {
        return this.matricula.formatada();
    }

    public void setMatriculaSimples(String matricula) {
        this.matricula = new Matricula(matricula);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", matricula=" + getMatriculaSimples()+ '}';
    }

}
