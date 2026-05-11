/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author melissa
 */
public class LocationTest {
    private static Location l;
    
    @BeforeAll
    public static void globalSetUp(){
        l = new Location("General Store");
        l.setId("256");
    }

    /**
     * Test of getLocationId method, of class Location.
     */
    @Test
    public void testGetId() {
        String result = l.getId();
        String expResult = "256";
        assertEquals(result,expResult);
    }

    /**
     * Test of getName method, of class Location.
     */
    @Test
    public void testGetName() {
        l.setName("Home");
        String result = l.getName();
        String expResult = "Home";
        assertEquals(result,expResult);
    }

    /**
     * Test of setName method, of class Location.
     */
    @Test
    public void testSetName() {
        String result = l.getName();
        String expResult = "Home";
        assertEquals(result,expResult);
        l.setName("Etsy");
        expResult = "Etsy";
        result = l.getName();
        assertEquals(result,expResult);
    }
    
}
