/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service.interfaces;

import br.com.pratixrest.model.State;
import java.util.List;

/**
 *
 * @author pontocom
 */
public interface StateService {
    
    public State saveState(State state);
    public State udpateState(State state);    
    public Boolean deleteState(State state);
    public Boolean deleteState(Integer id);
    public State getState(State state);    
    public State getState(Integer id);
    public List<State> getListState();
    
}
