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
import java.util.Scanner;

/**
 *
 * @author melissa
 */
public class Adder {
    private HashMap<Integer, Tag> tags = new HashMap<>();
    private HashMap<Integer, Location> locations = new HashMap<>();
    private HashMap<Integer, Item> items = new HashMap<>();
    private Collections c;

    public Adder(Collections c) {
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

    public Collections addItem() {
        return c;
    }
    
    public Collections addLocation() {
        System.out.println("What is the name of the new location?");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        Location l = new Location(temp);
        l = c.addLocation(l);
        int n = getHighestLocationKey(locations);
        n++;
        locations.put(n, l);
        return c;
    }
    
    public Collections addTag(){
        return c;
    }
    
    public int getHighestLocationKey(HashMap<Integer, Location> map){
        int m = 0;
        for(int n : map.keySet()){
            if (n > m){
                m = n;
            }
        }
        return m;
    }
    public int getHighestTagKey(HashMap<Integer, Tag> map){
        int m = 0;
        for(int n : map.keySet()){
            if (n > m){
                m = n;
            }
        }
        return m;
    }
    public int getHighestItemKey(HashMap<Integer, Item> map){
        int m = 0;
        for(int n : map.keySet()){
            if (n > m){
                m = n;
            }
        }
        return m;
    }
    
    public void updateCollection(Collections c){
        this.c = c;
    }
}
