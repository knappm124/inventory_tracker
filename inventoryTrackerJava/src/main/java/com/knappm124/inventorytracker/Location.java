/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

/**
 *
 * @author melissa
 */
public class Location {
    private int locationId;
    private String name;
    
    public Location(String name){
        this.name = name;
    }
    
    public boolean equals(Location l){
       if(l.locationId == locationId){
           return l.name.equals(name);
       } else {
           return false;
       }
    }
    
    @Override
    public String toString(){
        return "Location " + locationId + ": " + name;
    }
    
    public int getId(){
        return locationId;
    }
    
    public void setId(int locationId){
        this.locationId = locationId; 
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
}
