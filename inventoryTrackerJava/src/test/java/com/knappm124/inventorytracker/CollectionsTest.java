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
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author melissa
 */
public class CollectionsTest {
    
    private static Collections c;
    
    @BeforeAll
    public static void globalSetUp(){
        c = new Collections();
        
        Location l = new Location("General Store");
        c.addLocation(l);
        
        Tag t = new Tag.TagBuilder("Divides").build();
        c.addTag(t);
        
        Tag t2 = new Tag.TagBuilder("Season").build();
        c.addTag(t2);
        
        Item i = new Item.ItemBuilder("Test Egg").withPrice(5.00).build();
        i.setItemId(256);
        c.addItem(i);
        
        Item i2 = new Item.ItemBuilder("Chicken Egg").withPrice(10.00).build();
        i2.setItemId(526);
        c.addItem(i2);
    }

    /**
     * Test of addLocation method, of class Collections.
     */
    @Test
    public void testAddLocation() { 
        Location l = new Location("Other");
        c.addLocation(l);
        assertTrue(c.getLocations().contains(l));
    }

    /**
     * Test of getLocations method, of class Collections.
     */
    @Test
    public void testGetLocations() {
        Location l = new Location("Etsy");
        c.addLocation(l);
        ArrayList<Location> result = c.getLocations();
        ArrayList<Location> expResult = new ArrayList<>();
        assertNotEquals(result,expResult);
        assertTrue(result.contains(l));
    }

    /**
     * Test of getLocation method, of class Collections.
     */
    @Test
    public void testGetLocation() {
        Location l = new Location("Home");
        c.addLocation(l);
        Location result = c.getLocation("Home");
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
        Tag t = new Tag.TagBuilder("Divides").build();
        Tag t2 = new Tag.TagBuilder("Season").build();
        Tag t3 = new Tag.TagBuilder("Other").build();
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
        Tag t = new Tag.TagBuilder("Color").build();
        c.addTag(t);
        ArrayList<Tag> tags = c.getTags();
        assertTrue(tags.contains(t));
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
        Tag t = new Tag.TagBuilder("Season").build();
        Tag t2 = new Tag.TagBuilder("Divides").build();
        Tag t3 = new Tag.TagBuilder("Other").build();
        c.removeTag(t);
        ArrayList<Tag> tags = c.getTags();
        assertTrue(tags.contains(t2));
        assertFalse(tags.contains(t));
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
        Item i = new Item.ItemBuilder("Test Egg").withPrice(5.00).build();
        c.removeItem(i);
        assertFalse(c.getAllItems().contains(i));
    }

    /**
     * Test of getItem method, of class Collections.
     */
    @Test
    public void testGetItem() {
        Item i = c.getItem(256);
        String result = i.getName();
        String expResult = "Test Egg";
        Double result2 = i.getPrice();
        Double expResult2 = 5.00;
        assertEquals(result,expResult);
        assertEquals(result2,expResult2);
    }

    /**
     * Test of getAllItems method, of class Collections.
     */
    @Test
    public void testGetAllItems() {
        ArrayList<Item> items = c.getAllItems();
        for(Item i : items){
            if(i.getItemId() == 256){
                String expResult = "Test Egg";
                assertEquals(i.getName(),expResult);
                double expResult2 = 5.00;
                assertEquals(i.getPrice(),expResult2);
            } else if(i.getItemId() == 526){
                String expResult = "Chicken Egg";
                assertEquals(i.getName(),expResult);
                double expResult2 = 10.00;
                assertEquals(i.getPrice(),expResult2);
            }
        }
    }

    /**
     * Test of addItem method, of class Collections.
     */
    @Test
    public void testAddItem() {
        Item i = new Item.ItemBuilder("Bird Egg").withPrice(10.00).build();
        c.addItem(i);
        ArrayList<Item> items = c.getAllItems();
        assertTrue(items.contains(i));
    }
}
