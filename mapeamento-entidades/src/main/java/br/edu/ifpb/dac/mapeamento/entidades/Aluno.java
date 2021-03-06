package br.edu.ifpb.dac.mapeamento.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
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
@Access(AccessType.FIELD)
public class Aluno implements Serializable {    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    
    @ElementCollection
    @CollectionTable(name = "Telefone")
    private List<String> telefones;

    @Transient
    private Matricula matricula;

    @Column(name = "data_aniversario")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate aniversario;

    public Aluno() {
    }

    public Aluno(String nome, String matricula) {
        this(nome, matricula, LocalDate.now());
    }

    public Aluno(String nome, String matricula, LocalDate aniversario) {
        this.nome = nome;
        this.matricula = new Matricula(matricula);
        this.aniversario = aniversario;
        this.telefones= new ArrayList<>();
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "matricula_aluno")
    public String getMatriculaSimples() {
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

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
    
    public void addTelefone(String tel){
        this.telefones.add(tel);
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", matricula=" + getMatriculaSimples() + '}';

    }

}
