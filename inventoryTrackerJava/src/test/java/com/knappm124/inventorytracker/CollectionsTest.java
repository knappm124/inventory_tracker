/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.List;
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
        Collections c = new Collections();
        Location l = new Location("General Store");
        c.addLocation(l);
        Location result = c.getLocation("General Store");
        assertEquals(result,l);
        Location l2 = new Location("Etsy");
        assertNotEquals(result,l2);
    }

    /**
     * Test of getLocations method, of class Collections.
     */
    @Test
    public void testGetLocations() {
        Collections c = new Collections();
        Location l = new Location("General Store");
        c.addLocation(l);
        ArrayList<Location> result = c.getLocations();
        ArrayList<Location> expResult = new ArrayList<>();
        assertNotEquals(result,expResult);
        expResult.add(l);
        assertEquals(result,expResult);
    }

    /**
     * Test of getLocation method, of class Collections.
     */
    @Test
    public void testGetLocation() {
        Collections c = new Collections();
        Location l = new Location("General Store");
        c.addLocation(l);
        Location result = c.getLocation("General Store");
        assertEquals(result,l);
        try {
            c.getLocation("Etsy");
        } catch (Exception e){
            assertEquals(e.getMessage(),"Location doesn't exist");
        }
    }

    /**
     * Test of getTags method, of class Collections.
     */
    @Test
    public void testGetTags() {
        Collections c = new Collections();
        Tag t = new Tag.TagBuilder("Color").build();
        Tag t2 = new Tag.TagBuilder("Season").build();
        Tag t3 = new Tag.TagBuilder("Divides").build();
        c.addTag(t);
        c.addTag(t2);
        ArrayList<Tag> tags = c.getTags();
        assertTrue(tags.contains(t));
        assertTrue(tags.contains(t2));
        assertFalse(tags.contains(t3));
    }

    /**
     * Test of addTag method, of class Collections.
     */
    @Test
    public void testAddTag() {
        Collections c = new Collections();
        ArrayList<String> l = new ArrayList<>();
        l.add("Green");
        l.add("Blue");
        Tag t = new Tag.TagBuilder("Color").withOptions(l).build();
        c.addTag(t);
        ArrayList<Tag> tags = c.getTags();
        ArrayList<Tag> expResult = new ArrayList<>();
        expResult.add(t);
        assertEquals(expResult,tags);
        Tag t2 = new Tag.TagBuilder("Color").build();
        try {
            c.addTag(t2);
        } catch (Exception e){
            assertEquals(e.getMessage(),"This tag already exists");
        }
        
    }

    /**
     * Test of removeTag method, of class Collections.
     */
    @Test
    public void testRemoveTag() {
        Collections c = new Collections();
        Tag t = new Tag.TagBuilder("Color").build();
        Tag t2 = new Tag.TagBuilder("Season").build();
        Tag t3 = new Tag.TagBuilder("Divides").build();
        c.addTag(t);
        c.addTag(t2);
        c.removeTag(t2);
        ArrayList<Tag> tags = c.getTags();
        assertTrue(tags.contains(t));
        assertFalse(tags.contains(t2));
        try {
            c.removeTag(t3);
        } catch (Exception e) {
            String message = e.getMessage();
            assertEquals(message,"Tag does not exist");
        }
    }

    /**
     * Test of removeItem method, of class Collections.
     */
    @Test
    public void testRemoveItem() {
        
    }

    /**
     * Test of getItem method, of class Collections.
     */
    @Test
    public void testGetItem() {
        
    }

    /**
     * Test of getAllItems method, of class Collections.
     */
    @Test
    public void testGetAllItems() {
        
    }

    /**
     * Test of addItem method, of class Collections.
     */
    @Test
    public void testAddItem() {
        
    }

    /**
     * Test of save method, of class Collections.
     */
    @Test
    public void testSave() {
        
    }
    
    public void testRead() {
        
    }
    
}
