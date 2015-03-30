/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pontocom
 */
public class BaseRest {
    
    public Response returnTrue(String message, String json){
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("success",Boolean.TRUE);
            result.put("message","Product created succcess");
            result.put("data",json);
                        
            
            
            return Response.ok(new Gson().toJson(result), MediaType.APPLICATION_JSON).build();
    }

    public Response returnTrue( List<String> messages, String json){
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("success",Boolean.TRUE);
            result.put("message",messages);
            result.put("data",json);
                        
            return Response.ok(new Gson().toJson(result), MediaType.APPLICATION_JSON).build();
    }
    
    public Response returnFalse( List<String> messages, String json){
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("success",Boolean.FALSE);
            result.put("message",messages);
            result.put("data",json);
                        
            return Response.ok(new Gson().toJson(result), MediaType.APPLICATION_JSON).build();
    }


    public Response returnFalse( String message, String json){
            
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("success",Boolean.FALSE);
            result.put("message",message);
            result.put("data",json);
                        
            return Response.ok(new Gson().toJson(result), MediaType.APPLICATION_JSON).build();
    }
    
    
}
