/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import br.com.pratixrest.model.User;
import br.com.restpratix.service.UserServiceImpl;
import br.com.restpratix.service.interfaces.UserService;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author pontocom
 */
@Provider
public class JaxRsFilter implements ContainerRequestFilter, ContainerResponseFilter  {

    @Override
    public void filter(ContainerRequestContext requestContext) {        
        
        String token = requestContext.getHeaderString("Authorization") ;
        
//        UserService  userService = new UserServiceImpl();
//        
//        User user = userService.getUserByToken(token);
//                
//        if(user == null || user.getId() == null)
//            requestContext.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
        
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        
        
    }
    
}
