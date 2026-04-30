/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author melissa
 */
public class ItemTest {
    
    public ItemTest() {
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Item instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Item.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Item instance = null;
        String expResult = "";
        String result = instance.setName(newName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Item.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double newPrice = 0.0;
        Item instance = null;
        double expResult = 0.0;
        double result = instance.setPrice(newPrice);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Item.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Item instance = null;
        Status expResult = null;
        Status result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Item.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        Status newStatus = null;
        Item instance = null;
        Status expResult = null;
        Status result = instance.setStatus(newStatus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocationId method, of class Item.
     */
    @Test
    public void testGetLocationId() {
        System.out.println("getLocationId");
        Item instance = null;
        int expResult = 0;
        int result = instance.getLocationId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocationId method, of class Item.
     */
    @Test
    public void testSetLocationId() {
        System.out.println("setLocationId");
        int newLocationId = 0;
        Item instance = null;
        int expResult = 0;
        int result = instance.setLocationId(newLocationId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemId method, of class Item.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        Item instance = null;
        int expResult = 0;
        int result = instance.getItemId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTag method, of class Item.
     */
    @Test
    public void testAddTag() {
        System.out.println("addTag");
        Tag t = null;
        String option = "";
        Item instance = null;
        HashMap<Tag, ArrayList<String>> expResult = null;
        HashMap<Tag, ArrayList<String>> result = instance.addTag(t, option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTag method, of class Item.
     */
    @Test
    public void testRemoveTag() {
        System.out.println("removeTag");
        Tag t = null;
        String option = "";
        Item instance = null;
        HashMap<Tag, ArrayList<String>> expResult = null;
        HashMap<Tag, ArrayList<String>> result = instance.removeTag(t, option);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
