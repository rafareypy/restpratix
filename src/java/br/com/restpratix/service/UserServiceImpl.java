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
        
        getEm().getTransaction().begin();
        getEm().persist(user);
        getEm().getTransaction().commit();
        getEm().close();
        return user ;
    }

    @Override
    public User udpateUser(User user) {
        user.setPassword(Utils.md5(user.getPassword()));
        user.setToken(Utils.md5(user.getName()) +":"+Utils.md5(user.getPassword()));
        
        getEm().getTransaction().begin();
        getEm().persist(user);
        getEm().getTransaction().commit();
        getEm().close();
        
        return user ;        
    }

    @Override
    public Boolean deleteUser(User user) {
                
        try {
            getEm().getTransaction().begin();
            getEm().remove(user);
            getEm().getTransaction().commit();
            getEm().close();
            return true ;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Boolean deleteUser(Integer id) {
        User user = this.getUser(id);
        
        try {
            getEm().getTransaction().begin();
            getEm().remove(user);
            getEm().getTransaction().commit();
            getEm().close();
            return true ;
        } catch (Exception e) {
            return false;
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
        
        
//        System.out.println("token");
//        System.out.println(token);
//        System.out.println("2f5ebb0642cfa2a25af21fac655b30eb:14e1b600b1fd579f47433b88e8d85291");
//        
//        System.out.println("user id");
//        System.out.println(user.getId());
        
        
        try {
            
            Query query = getEm().createNamedQuery("User.findByToken")
                                    .setParameter("token",
                                    token);  

            result = (User) query.getSingleResult();          
            
            
        } catch (Exception e) {
            sysou(e.getMessage());
        }
        
        return result ;
    }
    
}
