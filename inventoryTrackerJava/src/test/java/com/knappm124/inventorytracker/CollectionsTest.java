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
public class CollectionsTest {
    
    public CollectionsTest() {
    }

    /**
     * Test of addLocation method, of class Collections.
     */
    @Test
    public void testAddLocation() {
        System.out.println("addLocation");
        Location l = null;
        Collections instance = new Collections();
        ArrayList<Location> expResult = null;
        ArrayList<Location> result = instance.addLocation(l);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocations method, of class Collections.
     */
    @Test
    public void testGetLocations() {
        System.out.println("getLocations");
        Collections instance = new Collections();
        ArrayList<Location> expResult = null;
        ArrayList<Location> result = instance.getLocations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Collections.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        String name = "";
        Collections instance = new Collections();
        Location expResult = null;
        Location result = instance.getLocation(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTags method, of class Collections.
     */
    @Test
    public void testGetTags() {
        System.out.println("getTags");
        Collections instance = new Collections();
        ArrayList<Tag> expResult = null;
        ArrayList<Tag> result = instance.getTags();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTag method, of class Collections.
     */
    @Test
    public void testAddTag() {
        System.out.println("addTag");
        Tag t = null;
        Collections instance = new Collections();
        ArrayList<Tag> expResult = null;
        ArrayList<Tag> result = instance.addTag(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTag method, of class Collections.
     */
    @Test
    public void testRemoveTag() {
        System.out.println("removeTag");
        Tag t = null;
        Collections instance = new Collections();
        ArrayList<Tag> expResult = null;
        ArrayList<Tag> result = instance.removeTag(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItem method, of class Collections.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item oldItem = null;
        Collections instance = new Collections();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.removeItem(oldItem);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Collections.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        int itemId = 0;
        Collections instance = new Collections();
        Item expResult = null;
        Item result = instance.getItem(itemId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllItems method, of class Collections.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        Collections instance = new Collections();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItem method, of class Collections.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item i = null;
        Collections instance = new Collections();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.addItem(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class Collections.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Collections instance = new Collections();
        instance.save();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
