/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.dac;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Samuell
 */
public class DaoJPA implements Dao{
    
    
    private EntityManagerFactory emf;
    private  EntityManager em; 

    public DaoJPA(String unidadePersistencia){
        emf = Persistence.createEntityManagerFactory(unidadePersistencia);
        em = emf.createEntityManager();
    }

    public DaoJPA(){
        this("mapeamento");
    }
    
    @Override
    public void save(Object o) {
       
        try {
            
            em.getTransaction().begin();

            em.persist(o);

            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public Object find(Class classe, Object object) {
       return em.find(classe, object);
    }

    @Override
    public void update(Object o) {
         try {
             
            em.getTransaction().begin();

            em.merge(o);
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Object o) {
    
    }
    
    
//        private static void listar(EntityManager em) {
//
//        List<Aluno> lista = em.createQuery("Select p From Aluno p").getResultList();
//
//        for (Aluno pessoa : lista) {
//            System.out.println(pessoa);
//        }
//    }
    
}
