package ifpb.dac.contexto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Ricardo Job
 */
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEndereco;

    @Column(name = "rua")
    private String nomeRua;

    public Endereco() {
    }

    public Endereco( String rua) {
        this.nomeRua = rua;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return nomeRua;
    }

    public void setRua(String rua) {
        this.nomeRua = rua;
    }

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", nomeRua=" + nomeRua + '}';
    }

}
