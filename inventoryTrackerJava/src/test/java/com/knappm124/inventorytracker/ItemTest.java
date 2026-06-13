/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;


import com.knappm124.inventorytracker.collections.Tag;
import com.knappm124.inventorytracker.collections.Status;
import com.knappm124.inventorytracker.collections.Item;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author melissa
 */
public class ItemTest {
    private Item i;
    private Tag t;
    
    @BeforeEach
    public void setUp() {
        i = new Item.ItemBuilder("Test Egg").withPrice(25.00).withStatus(Status.SOLD).build();
        UUID id = UUID.fromString("fa7e2f91-1e90-4a04-aeb0-690b6776fdfb");
        i.setItemId(id);
        ArrayList<String> s = new ArrayList<>();
        s.add("Red");
        s.add("Blue");
        Tag t = new Tag.TagBuilder("Color").withOptions(s).build();
        i.addTag(t,"Blue");
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        String result = i.getName();
        String expResult = "Test Egg";
        assertEquals(result,expResult);
    }

    /**
     * Test of setName method, of class Item.
     */
    @Test
    public void testSetName() {
        i.setName("Bird Egg");
        String result = i.getName();
        String expResult = "Bird Egg";
        assertEquals(result,expResult);
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        String result = String.format("%.2f", i.getPrice());
        String expResult = "25.00";
        assertEquals(result,expResult);
    }

    /**
     * Test of setPrice method, of class Item.
     */
    @Test
    public void testSetPrice() {
        i.setPrice(30.00);
        String result = String.format("%.2f", i.getPrice());
        String expResult = "30.00";
        assertEquals(result,expResult);
    }

    /**
     * Test of getStatus method, of class Item.
     */
    @Test
    public void testGetStatus() {
        Status result = i.getStatus();
        Status expResult = Status.SOLD;
        assertEquals(result,expResult);
    }

    /**
     * Test of setStatus method, of class Item.
     */
    @Test
    public void testSetStatus() {
        i.setStatus(Status.WIP);
        Status result = i.getStatus();
        Status expResult = Status.WIP;
        assertEquals(result,expResult);
    }


    /**
     * Test of getItemId method, of class Item.
     */
    @Test
    public void testGetItemId() {
        String result = i.getItemId().toString();
        String expResult = "fa7e2f91-1e90-4a04-aeb0-690b6776fdfb";
        assertEquals(result,expResult);
    }

    /**
     * Test of addTag method, of class Item.
     */
    @Test
    public void testAddTag() {
        ArrayList<String> s = new ArrayList<>();
        s.add("Easter");
        s.add("Christmas");
        Tag testTag = new Tag.TagBuilder("Season").withOptions(s).build();
        i.addTag(testTag,"Easter");
        assertTrue(i.containsTag(testTag));
    }

    /**
     * Test of removeTag method, of class Item.
     */
    @Test
    public void testRemoveOption() {
        ArrayList<String> s = new ArrayList<>();
        s.add("Red");
        s.add("Blue");
        Tag testTag = new Tag.TagBuilder("Color").withOptions(s).build();
        i.removeOption(testTag,"Blue");
        s = i.getOptions("Color");
        assertFalse(s.contains("Blue"));
    }

    /**
     * Test of toString method, of class Item.
     */
    @Test
    public void testToString() {
        String result = i.toString();
        String expResult = "Test Egg has a price of 25.00 is sold and is categorized as Blue";
        assertEquals(result,expResult);
    }
    
}
