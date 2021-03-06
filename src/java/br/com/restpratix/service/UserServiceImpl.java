/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.Product;
import br.com.pratixrest.model.User;
import br.com.pratixrest.util.Utils;
import br.com.restpratix.service.interfaces.UserService;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author pontocom
 */
public class UserServiceImpl extends BasicService implements UserService{

    @Override
    public User saveUser(User user) {
        
        user.setPassword(Utils.md5(user.getPassword()));
        user.setToken(Utils.md5(user.getName()) +":"+Utils.md5(user.getPassword()));
        
        try {
            getEm().getTransaction().begin();
            getEm().persist(user);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();                                    
            
        }finally{
            if(getEm().isOpen())
                getEm().close();            
        }
        

        return user ;
    }

    @Override
    public User udpateUser(User user) {
        user.setPassword(Utils.md5(user.getPassword()));
        user.setToken(Utils.md5(user.getName()) +":"+Utils.md5(user.getPassword()));
        
        try {
            getEm().getTransaction().begin();
            getEm().persist(user);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();                                    
        }finally{
            if(getEm().isOpen())
                getEm().close();
            
        }
        

        
        return user ;        
    }

    @Override
    public Boolean deleteUser(User user) {
                
        try {
            getEm().getTransaction().begin();
            getEm().remove(user);
            getEm().getTransaction().commit();
            return true ;
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();            
            return false;
        }finally{
            if(getEm().isOpen())
                getEm().close();            
        }
        
    }

    @Override
    public Boolean deleteUser(Integer id) {
        User user = this.getUser(id);
        
        try {
            getEm().getTransaction().begin();
            getEm().remove(user);
            getEm().getTransaction().commit();            
            return true ;
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();                                    
            
            return false ;
        }finally{
            if(getEm().isOpen())
                getEm().close();
            
        }
    }

    @Override
    public User getUser(User user) {
        return getEm().find(User.class, user.getId());
    }

    @Override
    public User getUser(Integer id) {
        return getEm().find(User.class, id);
    }

    @Override
    public List<User> getListUser() {
        return getEm().createQuery("from User").getResultList();
    }

    @Override
    public User getUserByToken(String token) {
        
        User result = null ;
                
        try {
            
            Query query = getEm().createNamedQuery("User.findByToken")
                                    .setParameter("token",
                                    token);  

            result = (User) query.getSingleResult();          
            
            
            getEm().close();
            
        } catch (Exception e) {
            sysou(e.getMessage());
        }
        
        return result ;
    }
    
}
