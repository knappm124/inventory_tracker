/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.collections;

import java.io.Serializable;

/**
 *
 * @author melissa
 */
public class Location implements Serializable{
    private String locationId;
    private String name;
    private static final long serialVersionUID = 1L;
    
    public Location(String name){
        this.name = name;
    }
    
    public boolean equals(Location l){
       if(l.locationId.contains(locationId)){
           return l.name.equals(name);
       } else {
           return false;
       }
    }
    
    @Override
    public String toString(){
        return "Location " + locationId + ": " + name;
    }
    
    public String getId(){
        return locationId;
    }
    
    public Location setId(String locationId){
        this.locationId = locationId; 
        return this;
    }
    
    public String getName() {
        return name;
    }
    
    public Location setName(String newName) {
        name = newName;
        return this;
    }
}
