/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.restpratix.service;

import br.com.pratixrest.model.User;
import java.util.List;
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
public class UserServiceImplIT {
    
    public UserServiceImplIT() {
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
     * Test of saveUser method, of class UserServiceImpl.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        
        User user = new User();
        user.setName("user test");
        user.setPassword("usertest");
        
                
        UserServiceImpl instance = new UserServiceImpl();
        
        User result = instance.saveUser(user);
        assertEquals(user.getName(), result.getName());
        
        assertTrue(result.getId() > 0);
        

    }

    /**
     * Test of udpateUser method, of class UserServiceImpl.
     */
    @Test
    public void testUdpateUser() {
                
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        
        User user =  userServiceImpl.getListUser().get(1);

        String name = "change";
        user.setName(name);
        
        
        User result = userServiceImpl.udpateUser(user);
        assertEquals(name, result.getName());
        
        
    }

    /**
     * Test of deleteUser method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteUser_User() {
//        System.out.println("deleteUser");
//        User user = null;
//        UserServiceImpl instance = new UserServiceImpl();
//        Boolean expResult = null;
//        Boolean result = instance.deleteUser(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserServiceImpl.
     */
    @Test
    public void testDeleteUser_Integer() {
//        System.out.println("deleteUser");
//        Integer id = null;
//        UserServiceImpl instance = new UserServiceImpl();
//        Boolean expResult = null;
//        Boolean result = instance.deleteUser(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserServiceImpl.
     */
    @Test
    public void testGetUser_User() {
//        System.out.println("getUser");
//        User user = null;
//        UserServiceImpl instance = new UserServiceImpl();
//        User expResult = null;
//        User result = instance.getUser(user);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserServiceImpl.
     */
    @Test
    public void testGetUser_Integer() {
        
        Integer id = 1;
        UserServiceImpl instance = new UserServiceImpl();
        
        User result = instance.getUser(id);
        
        assertEquals(id, result.getId());

        
    }

    /**
     * Test of getListUser method, of class UserServiceImpl.
     */
    @Test
    public void testGetListUser() {
        System.out.println("getListUser");
        
        UserServiceImpl instance = new UserServiceImpl();
        List<User> expResult = null;
        List<User> result = instance.getListUser();
        
        assertTrue(result.size() > 0);
        
        
    }

    /**
     * Test of getUserByToken method, of class UserServiceImpl.
     */
    @Test
    public void testGetUserByToken() {
        System.out.println("getUserByToken");
        
        UserServiceImpl serviceImpl = new UserServiceImpl();
        List<User> list = serviceImpl.getListUser();
        
        User user = list.get(0);
        
        String token = user.getToken();
        
        
        User result = serviceImpl.getUserByToken(token);
        
        assertEquals(user.getToken(), result.getToken());
        
    }
    
}
