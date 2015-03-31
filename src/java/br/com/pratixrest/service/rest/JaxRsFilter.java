/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

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
public class JaxRsFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {        
        
        String v = requestContext.getHeaderString("Authorization") ;
        
        if(v != null && v.equals("123456789")){
            System.out.println("user authorized");
        }else{
            requestContext.abortWith( Response.status( Response.Status.UNAUTHORIZED ).build() );
            System.out.println("User not authorized");
        }        
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        System.out.println("Filter Two");
        
    }
    
}
