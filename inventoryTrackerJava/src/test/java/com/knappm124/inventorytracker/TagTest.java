/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author melissa
 */
public class TagTest {
    
    public TagTest() {
    }

    /**
     * Test of getTagId method, of class Tag.
     */
    @Test
    public void testGetTagId() {
        System.out.println("getTagId");
        Tag instance = null;
        int expResult = 0;
        int result = instance.getTagId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTagId method, of class Tag.
     */
    @Test
    public void testSetTagId() {
        System.out.println("setTagId");
        int id = 0;
        Tag instance = null;
        instance.setTagId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Tag.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Tag instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Tag.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String newName = "";
        Tag instance = null;
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOptions method, of class Tag.
     */
    @Test
    public void testGetOptions() {
        System.out.println("getOptions");
        Tag instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getOptions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOption method, of class Tag.
     */
    @Test
    public void testAddOption() {
        System.out.println("addOption");
        String newOption = "";
        Tag instance = null;
        instance.addOption(newOption);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOption method, of class Tag.
     */
    @Test
    public void testRemoveOption() {
        System.out.println("removeOption");
        String option = "";
        Tag instance = null;
        instance.removeOption(option);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
