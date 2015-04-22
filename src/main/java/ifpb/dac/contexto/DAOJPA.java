package ifpb.dac.contexto;

import com.sun.javafx.scene.EnteredExitedHandler;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author job
 */
public class DAOJPA implements DAO{
    
    private EntityManager entityManager;
    
    public DAOJPA(){
        this("desenvolvimento");
    }
    
    public DAOJPA(String unidadePersistencia){
        entityManager=Persistence.createEntityManagerFactory(unidadePersistencia).createEntityManager();
        
    }
    
    @Override
    public boolean salvar(Object obj) {
        EntityTransaction transacao=entityManager.getTransaction();
        
        try{
           transacao.begin();
           entityManager.persist(obj);
           transacao.commit();   
           return true;
        }catch(Exception ex){
            if(transacao.isActive())
               transacao.rollback();
            return false;
        }
        
    }

    @Override
    public boolean atualizar(Object obj) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Object chave, Class entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
