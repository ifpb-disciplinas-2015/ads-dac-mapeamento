package edu.ifpb.dac.atributos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Ricardo Job
 */
@Entity
@SequenceGenerator(name = "pessoa_ID",sequenceName = "Pessoa_SEQ",
allocationSize = 1,initialValue=1)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "pessoa_ID")
    private int id;
    
    @ElementCollection
    @CollectionTable(name = "Emails")
    private List<String> emails = new ArrayList<String>();
    
    @Transient
    private String versao;

    @Basic(fetch = FetchType.EAGER, optional = true)
    private String nome;

    @Basic(fetch = FetchType.LAZY, optional = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date aniversario;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] foto;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public enum Sexo {
        Masculino,
        Feminino;
    }

    @Embedded
    private Endereco endereco;

    public Date getAniversario() {
        return aniversario;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
    
    public void addEmail(String email){
        this.emails.add(email);
    }
    
    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}
