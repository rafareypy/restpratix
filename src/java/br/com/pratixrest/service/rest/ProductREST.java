/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import br.com.pratixrest.model.IcmsCst;
import br.com.pratixrest.model.Product;
import br.com.restpratix.service.IcmsCstServiceImpl;
import br.com.restpratix.service.ProductServiceImpl;
import br.com.restpratix.service.interfaces.IcmsCstService;
import br.com.restpratix.service.interfaces.ProductService;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("product")
public class ProductREST extends BaseRest{

    
    
    ProductService  productService  ;
    /**
     * Creates a new instance of ProductREST
     */
    public ProductREST() {
        init();        
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.rest.ProductREST
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getJson() {            
        
        
//        IcmsCstService icmsCstService = new IcmsCstServiceImpl();
//        
//        
//        try {
//
//                System.out.println("Saving icms");
//            
//                IcmsCst icmsCst = new IcmsCst();
//                icmsCst.setAcronym("acron");
//                icmsCst.setCode(1);
//                icmsCst.setDescription("description");
//                icmsCst.setMandatoryCofins(Boolean.TRUE);
//                icmsCst.setMandatoryIcms(true);
//                icmsCst.setMandatoryPis(true);
//                icmsCst.setMandatoryReducao(true);
//                icmsCst.setTypeTribute(1);
//            
//                icmsCstService.saveIcmsCst(icmsCst);
//                
//                System.out.println("Cod save ");
//                System.out.println(icmsCst.getId());
//                
//        } catch (Exception e) {
//            System.out.println("Error saving icms");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
        
        try{
            return returnTrue("ok", new Gson().toJson(productService.getListProduct()));
        } catch (Exception e) {
            e.printStackTrace();
            return returnFalse(e.getMessage(), "error");        
        }
       
        
        
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getJson(@PathParam("id") Integer id) {            
        
        try {
            return returnTrue("ok", new Gson().toJson(productService.getProduct(id)));        
        } catch (Exception e) {
            return returnFalse(e.getMessage(), new Gson().toJson(id));        
        }
        
        
    }    
    
    /**
     * PUT method for updating or creating an instance of ProductREST
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Path("{id}")
    @Consumes({ "application/json"})
    public Response  putJson(@PathParam("id") Integer id, Product product) {
        
        try {
            product.setId(id);
            productService.udpateProduct(product);
            Map<String , Object > resul = new HashMap<String, Object >();
            resul.put("id", product.getId());
            
            return returnTrue(new Gson().toJson(product), new Gson().toJson(resul));            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in update ProductREST \n " + e.getMessage()  );
            return returnFalse(e.getMessage(), null);
        }        
        
        
        
    }
    
    @POST    
    @Consumes({"application/json"})
    public Response create(Product product) {

        try {
            productService.saveProduct(product);
            
            return returnTrue( "Product created success", new Gson().toJson(product.getId()) );
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in create ProductREST \n " + e.getMessage()  );
            return returnFalse("Product created success", new Gson().toJson(product.getId()) );
        }
        
    }    

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        
        try {
            productService.deleteProduct(id);

            return returnTrue("Register removed", "Register removed" );            
                        
        } catch (Exception e) {
            System.out.println("Error in delete product ");
            e.printStackTrace();
            return returnFalse("Register not removed", new Gson().toJson(id) );            
        }
    }
    
    
    private void init() {
        productService  = new ProductServiceImpl();
    }
    
}
