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
public class IdMakerTest {
    
    public IdMakerTest() {
    }

    /**
     * Test of newId method, of class IdMaker.
     */
    @Test
    public void testNewId() {
        System.out.println("newId");
        int expResult = 0;
        int result = IdMaker.newId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCounter method, of class IdMaker.
     */
    @Test
    public void testUpdateCounter() {
        System.out.println("updateCounter");
        IdMaker.updateCounter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCounter method, of class IdMaker.
     */
    @Test
    public void testSaveCounter() {
        System.out.println("saveCounter");
        IdMaker.saveCounter();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
