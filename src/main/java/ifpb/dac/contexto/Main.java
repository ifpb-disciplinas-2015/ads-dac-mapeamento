package ifpb.dac.contexto;

/**
 * @author job
 */
public class Main {
    public static void main(String[] args) {
        Endereco endereco=new Endereco("manel");
        DAO dao=new DAOJPA();
        if(dao.salvar(endereco))
                System.out.println("Deucerto");
        else
                System.out.println("Deu errado");
    }
}
