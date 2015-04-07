/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pratixrest.service.rest;

import br.com.pratixrest.model.User;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pontocom
 */
public class UserResourceIT {
    
    public UserResourceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getJson method, of class UserResource.
     */
    @Test
    public void testGetJson() {
        
        UserResource instance = new UserResource();
        
        Response result = instance.getJson();
        
        System.out.println("Result");
        System.out.println(result);
        
    }

    /**
     * Test of putJson method, of class UserResource.
     */
    @Test
    public void testPutJson() {
//        System.out.println("putJson");
//        User user = null;
//        UserResource instance = new UserResource();
//        Response expResult = null;
//        Response result = instance.putJson(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class UserResource.
     */
    @Test
    public void testCreate() {
//        System.out.println("create");
//        User user = null;
//        UserResource instance = new UserResource();
//        Response expResult = null;
//        Response result = instance.create(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
