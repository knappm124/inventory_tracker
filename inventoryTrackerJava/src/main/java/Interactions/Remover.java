/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interactions;

import com.knappm124.inventorytracker.collections.Collections;
import com.knappm124.inventorytracker.collections.Item;
import com.knappm124.inventorytracker.collections.Location;
import com.knappm124.inventorytracker.collections.Tag;
import java.util.HashMap;

/**
 *
 * @author melissa
 */
public class Remover {
    private HashMap<Integer, Tag> tags = new HashMap<>();
    private HashMap<Integer, Location> locations = new HashMap<>();
    private HashMap<Integer, Item> items = new HashMap<>();
    private Collections c;
    
    public Remover(Collections c){
        this.c = c;
        int counter = 1;
        for (Item i : c.getAllItems()) {
            items.put(counter, i);
            counter++;
        }
        counter = 1;
        for (Tag t : c.getTags()) {
            tags.put(counter, t);
            counter++;
        }
        counter = 1;
        for (Location l : c.getLocations()) {
            locations.put(counter, l);
            counter++;
        }
    }
    
    public Collections removeTag(){
        return c;
    }
    
    public Collections removeLocation(){
        return c;
    }
    
    public Collections removeItem(){
        return c;
    }
    
    public void updateCollection(Collections c){
        this.c = c;
    }
}
