/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import com.knappm124.inventorytracker.collections.Location;
import java.util.UUID;
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
        UUID id = UUID.fromString("fa7e2f91-1e90-4a04-aeb0-690b6776fdfb");
        l.setId(id);
    }

    /**
     * Test of getLocationId method, of class Location.
     */
    @Test
    public void testGetId() {
        String result = l.getId().toString();
        String expResult = "fa7e2f91-1e90-4a04-aeb0-690b6776fdfb";
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
