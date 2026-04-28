/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;

/**
 *
 * @author melissa
 */
public class Collections {
    ArrayList<Location> locations;
    ArrayList<Tag> tags;
    
    public Collections() {
        locations = new ArrayList();
        tags = new ArrayList();
    }
    
    public Collections(ArrayList<Location> locations, ArrayList<Tag> tags) {
        this.locations = locations;
        this.tags = tags;
    }
    
    public void addLocation(Location l) {
        for (var location : locations){
            if (l.getName().equals(location.getName())){
                throw new IllegalArgumentException("Location already exists");
            }
        }
        locations.add(l);
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
    
    public void addTag(Tag t) {
        for (var tag : tags){
            if(tag.getName().equals(t.getName())){
                throw new IllegalArgumentException("This tag already exists");
            }
        }
        tags.add(t);
    }
    
    public void removeTag(Tag t) {
        for (var tag : tags){
            if(tag.getName().equals(t.getName())){
                tags.remove(t);
                return;
            }
        }
        throw new IllegalArgumentException("Tag does not exist");
    }
    
    public void save() {
    //TODO: Write saving logic    
    }
}
