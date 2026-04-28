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
        locationId = IdMaker.newId();
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
