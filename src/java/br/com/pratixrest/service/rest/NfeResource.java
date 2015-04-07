/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import benefix.nfe.NfeiService;
import benefix.nfe.NfeiServiceSoap;
import br.com.pratixrest.model.Product;
import com.thoughtworks.xstream.XStream;
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

/**
 * REST Web Service
 *
 * @author pontocom
 */
@Path("nfe")
public class NfeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NfeResource
     */
    public NfeResource() {
    }

    /**
     * Retrieves representation of an instance of br.com.pratixrest.service.rest.NfeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        
       return null ;
        
        
        
    }

    /**
     * PUT method for updating or creating an instance of NfeResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
        
    }
    
    @POST
    @Consumes("application/xml")
    public void postNfe(String content) {
        
        System.out.println("Post Nfe");
        
        NfeiService service = new NfeiService();
       
       NfeiServiceSoap soap = service.getNfeiServiceSoap();
       
        System.out.println("Sending nfe");
       
       //soap.solicitarImportacaoArquivoXMLasUTF8(arquivolote, cnp, tipoAutenticacao, usuario, senha, result, retNFeSec);
        
        
        
    }    
    
    
}
