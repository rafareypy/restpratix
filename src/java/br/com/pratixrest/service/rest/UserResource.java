/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import br.com.pratixrest.model.Product;
import br.com.pratixrest.model.User;
import br.com.restpratix.service.UserServiceImpl;
import br.com.restpratix.service.interfaces.UserService;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author pontocom
 */
@Path("user")
public class UserResource extends BaseRest{

    @Context
    private UriInfo context;
    
    UserService userService ;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
        init();
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.service.rest.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getJson() {

        
        System.out.println("getJson");
        
        List<User> list = new ArrayList<User>();
        
        for (int i = 0; i < 10; i++) {
            User user = new User(i);
            user.setName("Name " + i );
            user.setPassword("password " + i );
            user.setToken("token " + i);
            list.add(user);
        }
        
       
            
        
        return returnTrue("success", list);
        
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public Response putJson(User user) {
        
        try {
            
            userService.udpateUser(user);
                        
            return returnTrue( "User successfully updated ..!", user.getId() );
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in create ProductREST \n " + e.getMessage()  );
            return returnFalse("User successfully  failure..! \n" + e.getMessage() , user );
        }        
                    
        
    }
    

    
    @POST    
    @Consumes({"application/json"})
    public Response create(User user) {

        
        try {
            
            userService.saveUser(user);
                        
            return returnTrue( "User created success", user.getId() );
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in create ProductREST \n " + e.getMessage()  );
            return returnFalse("User creation failure \n" + e.getMessage() , user );
        }        
            
        
        
    }        
    

    private void init() {
        userService = new UserServiceImpl();
    }
    
}
