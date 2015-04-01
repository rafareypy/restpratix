/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service.interfaces;

import br.com.pratixrest.model.Product;
import br.com.pratixrest.model.User;
import java.util.List;

/**
 *
 * @author pontocom
 */
public interface UserService {
 
    public User saveUser(User user);
    public User udpateUser(User user);    
    public Boolean deleteUser(User user);
    public Boolean deleteUser(Integer id);
    public User getUser(User user);
    public User getUserByToken(String  token);
    public User getUser(Integer id);
    public List<User> getListUser();
    
    
}
