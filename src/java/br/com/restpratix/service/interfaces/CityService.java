/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service.interfaces;

import br.com.pratixrest.model.City;
import java.util.List;

/**
 *
 * @author pontocom
 */
public interface CityService {
    
    public City saveCity(City city);
    public City udpateCity(City city);    
    public Boolean deleteCity(City city);
    public Boolean deleteCity(Integer id);
    public City getCity(City city);    
    public City getCity(Integer id);
    public List<City> getListCity();    
    
}
