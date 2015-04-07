/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import br.com.pratixrest.model.City;
import br.com.pratixrest.model.State;
import br.com.restpratix.service.CityServiceImpl;
import br.com.restpratix.service.StateService;
import br.com.restpratix.service.interfaces.CityService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author pontocom
 */
@Path("testing")
public class TestingResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestingResource
     */
    public TestingResource() {
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.service.rest.TestingResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        
        System.out.println("Saving city");
        
        
        StateService stateService = new StateService();
        
        State state = new State();
        state.setName("new state");
        state.setAcronym("st");
        
        
        try {
            stateService.saveState(state);
        } catch (Exception e) {
            System.out.println("Error in sabving state");
            e.getMessage();
            e.printStackTrace();
        }
        
        
        
//        CityService cityService = new CityServiceImpl();
//        
//        City city = new City();
//        city.setName("city ");
//        
//        State state = new State();
//        state.setName("one");
//        state.setAcronym("o");
//        
//        city.setState(state);
//        
//        
//        cityService.saveCity(city);
        
        return null ;
    }

    /**
     * PUT method for updating or creating an instance of TestingResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
