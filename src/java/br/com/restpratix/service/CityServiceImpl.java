/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.City;
import br.com.restpratix.service.interfaces.CityService;
import java.util.List;

/**
 *
 * @author pontocom
 */
public class CityServiceImpl extends BasicService implements CityService{

    @Override
    public City saveCity(City city) {
        try {
            getEm().getTransaction().begin();
            getEm().persist(city);
            getEm().getTransaction().commit();
        } catch (Exception e) {
            if(getEm().isOpen())
                getEm().getTransaction().rollback();                                    
            
        }finally{
            if(getEm().isOpen())
                getEm().close();            
        }
        
        return city ;
        
    }

    @Override
    public City udpateCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteCity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City getCity(City city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City getCity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<City> getListCity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
