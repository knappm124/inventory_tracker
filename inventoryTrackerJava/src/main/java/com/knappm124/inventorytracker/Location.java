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
    
    public int getLocationId(){
        return locationId;
    }
    
    public void setLocationId(int id){
        locationId = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
}
