
package edu.ifpb.dac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuell
 */
public interface Dao {
    
        public void save(Object o);
        
        public Object find(Class classe, Object object);
        
        public void update(Object o);
        
        public void delete(Object o);
}
