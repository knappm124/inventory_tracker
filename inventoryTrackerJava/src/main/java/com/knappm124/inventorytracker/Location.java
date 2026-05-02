/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;
import java.io.Serializable;

/**
 *
 * @author melissa
 */
public class Location implements Serializable {
    private int locationId;
    private String name;
    private static final long serialVersionUID = 1L;
    
    public Location(String name){
        this.name = name;
        locationId = IdMaker.newId();
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
    
    public int getLocationId(){
        return locationId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
}
