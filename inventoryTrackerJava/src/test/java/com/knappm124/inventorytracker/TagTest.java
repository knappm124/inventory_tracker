/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.knappm124.inventorytracker;

import com.knappm124.inventorytracker.collections.Tag;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author melissa
 */
public class TagTest {
    private static Tag t;
    
    @BeforeAll
    public static void globalSetUp(){
        ArrayList<String> options = new ArrayList<>();
        options.add("Blue");
        options.add("Red");
        t = new Tag.TagBuilder("Color").withOptions(options).build();
        t.setTagId("326");
    }

    /**
     * Test of getTagId method, of class Tag.
     */
    @Test
    public void testGetTagId() {
        String expResult = "326";
        String result = t.getTagId();
        assertEquals(result,expResult);
    }

    /**
     * Test of getName method, of class Tag.
     */
    @Test
    public void testGetName() {
        String expResult = "Color";
        String result = t.getName();
        assertEquals(result,expResult);
    }

    /**
     * Test of setName method, of class Tag.
     */
    @Test
    public void testSetName() {
        t.setName("Season");
        String expResult = "Season";
        String result = t.getName();
        assertEquals(result,expResult);
    }

    /**
     * Test of getOptions method, of class Tag.
     */
    @Test
    public void testGetOptions() {
        ArrayList<String> result = t.getOptions();
        System.out.println(result);
        assertTrue(result.contains("Blue"));
        assertTrue(result.contains("Red"));
    }

    /**
     * Test of addOption method, of class Tag.
     */
    @Test
    public void testAddOption() {
        t.addOption("Green");
        ArrayList<String> result = t.getOptions();
        assertTrue(result.contains("Green"));
    }

    /**
     * Test of removeOption method, of class Tag.
     */
    @Test
    public void testRemoveOption() {
        t.removeOption("Blue");
        ArrayList<String> result = t.getOptions();
        assertTrue(result.contains("Red"));
        assertFalse(result.contains("Blue"));
    }
    
}
