/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author melissa
 */
public class LocationTest {
    
    public LocationTest() {
    }

    /**
     * Test of getLocationId method, of class Location.
     */
    @Test
    public void testGetLocationId() {
        System.out.println("getLocationId");
        Location instance = new Location();
        int expResult = 0;
        int result = instance.getLocationId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocationId method, of class Location.
     */
    @Test
    public void testSetLocationId() {
        System.out.println("setLocationId");
        int id = 0;
        Location instance = new Location();
        instance.setLocationId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Location.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Location instance = new Location();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Location.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Location instance = new Location();
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
