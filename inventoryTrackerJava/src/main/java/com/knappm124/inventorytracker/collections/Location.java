/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.collections;

import java.util.UUID;

/**
 *
 * @author melissa
 */
public class Location {
    private UUID locationId;
    private String name;
    private static final long serialVersionUID = 1L;
    
    public Location(String name){
        this.name = name;
        locationId = UUID.randomUUID();
    }
    
    public boolean equals(Location l){
       if(l.getId().equals(this.locationId)){
           return l.name.equals(name);
       } else {
           return false;
       }
    }
    
    @Override
    public String toString(){
        return "Location " + locationId + ": " + name;
    }
    
    public UUID getId(){
        return locationId;
    }
    
    public void setId(UUID locationId){
        this.locationId = locationId; 
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
}
