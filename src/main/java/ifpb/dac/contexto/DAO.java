/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.contexto;

/**
 *
 * @author job
 */
public interface DAO {
    
    public boolean salvar(Object obj);
    
    public boolean atualizar(Object obj);
    
    public boolean excluir(Object obj);
    
    public Object buscar(Object chave, Class entidade);
    
    
}
