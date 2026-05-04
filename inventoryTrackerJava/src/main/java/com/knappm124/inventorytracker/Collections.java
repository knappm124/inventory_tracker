/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 *
 * @author melissa
 */
public class Collections {
    ArrayList<Location> locations;
    ArrayList<Tag> tags;
    ArrayList<Item> items;
    private static final long serialVersionUID = 1L;
    
    public Collections() {
        locations = new ArrayList();
        tags = new ArrayList();
        items = new ArrayList();
    }
    
    public Collections(ArrayList<Location> locations, ArrayList<Tag> tags, ArrayList<Item> items) {
        this.locations = locations;
        this.tags = tags;
        this.items = items;
    }
    
    public ArrayList<Location> addLocation(Location l) {
        for (var location : locations){
            if (l.getName().equals(location.getName())){
                throw new IllegalArgumentException("Location already exists");
            }
        }
        locations.add(l);
        return locations;
    }
    
    public ArrayList<Location> getLocations() {
        return locations;
    }
    
    public Location getLocation(String name) {
        for(var location : locations) {
            if(location.getName().equals(name)){
                return location;
            }
        }
        throw new IllegalArgumentException("Location doesn't exist");
    }
    
    public ArrayList<Tag> getTags() {
        return tags;
    }
    
    public ArrayList<Tag> addTag(Tag t) {
        for (var tag : tags){
            if(tag.getName().equals(t.getName())){
                throw new IllegalArgumentException("This tag already exists");
            }
        }
        tags.add(t);
        return tags;
    }
    
    public ArrayList<Tag> removeTag(Tag t) {
        for (var tag : tags){
            if(tag.getName().equals(t.getName())){
                tags.remove(t);
                return tags;
            }
        }
        throw new IllegalArgumentException("Tag does not exist");
    }
    
    public ArrayList<Item> removeItem(Item oldItem){
        for(Item i : items){
            if(i.getItemId() == oldItem.getItemId()){
                items.remove(oldItem);
                return items;
            }
        }
        throw new IllegalArgumentException("Item with id " + oldItem.getItemId() + " does not exist");
    }
    
    public Item getItem(int itemId){
        for(Item i : items){
            if(i.getItemId() == itemId){
                return i;
            }
        }
        throw new IllegalArgumentException("Item with id " + itemId + " does not exist");
    }
    
    public ArrayList<Item> getAllItems(){
        return items;
    }
    
    public ArrayList<Item> addItem(Item i){
        items.add(i);
        return items;
    }
}
