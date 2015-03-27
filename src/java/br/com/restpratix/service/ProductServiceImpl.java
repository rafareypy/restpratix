/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.Product;
import br.com.restpratix.service.interfaces.ProductService;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author pontocom
 */
@Stateless
public class ProductServiceImpl extends BasicService implements ProductService, Serializable{
  
    @Override
    public Product saveProduct(Product product) {
        getEm().getTransaction().begin();
        getEm().persist(product);
        getEm().getTransaction().commit();
        getEm().close();
        return product ;
    }
    
    @Override
    public Product udpateProduct(Product product) {
        getEm().getTransaction().begin();
        getEm().merge(product);
        getEm().getTransaction().commit();
        getEm().close();
        return product ;        
    }
    
    @Override
    public Boolean deleteProduct(Product product) {
        getEm().getTransaction().begin();
        getEm().remove(product);
        getEm().getTransaction().commit();
        getEm().close();
        return true ;        
    }
    
    @Override
    public Product getProduct(Product product) {
        return getEm().find(Product.class, product.getId());
    }
    
    @Override
    public Product getProduct(Integer id) {
        return getEm().find(Product.class, id);
    }
    
    @Override
    public List<Product> getListProduct() {
        return getEm().createQuery("from Product").getResultList();
    }
    
    @Override
    public List<Product> getListProductByName(String name) {
        return getEm().createQuery("from Product ").getResultList();
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        
        Product product = getEm().find(Product.class, id);
        
        if(product != null )
            return this.deleteProduct(product);
        
        return false ;
        
        
    }

}
