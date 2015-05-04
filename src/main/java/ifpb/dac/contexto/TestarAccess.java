package ifpb.dac.contexto;

/**
 * @author job
 */
public class TestarAccess {
    public static void main(String[] args) {
        DAO<Aluno> dao = new DAOJPA<>();
        
        Aluno aluno = new Aluno("Job", "1234");
        
        System.out.println(dao.salvar(aluno));
    }
}
