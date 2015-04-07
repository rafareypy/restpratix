/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.State;

/**
 *
 * @author pontocom
 */
public class StateService extends BasicService{
    
    public State saveState(State state){
        
        
         try {
            getEm().getTransaction().begin();
            getEm().persist(state);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();                                    
            
        }finally{
            if(getEm().isOpen())
                getEm().close();            
        }
        
        return state ;
        
        
    }
    
}
