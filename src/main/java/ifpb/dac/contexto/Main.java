package ifpb.dac.contexto;

/**
 * @author job
 */
public class Main {
    public static void main(String[] args) {
//        Endereco endereco=new Endereco("manel");
        DAO<Endereco> dao=new DAOJPA<>();
//        if(dao.salvar(endereco))
//                System.out.println("Deucerto");
//        else
//                System.out.println("Deu errado");
        Endereco enderecoRetorno=dao.buscar(51, Endereco.class);
//        System.out.println(obj);
//        enderecoRetorno.setRua("joao");
        if(dao.excluir(enderecoRetorno)){
            System.out.println("Deu certo");
        }else{
            System.out.println("Nao deu certo");
        }
        
        
        
        
    }
}
