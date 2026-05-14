/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author melissa
 */
public class DatabaseUpdater {
    private final MongoDatabase database;
    
    public DatabaseUpdater(MongoDatabase database){
        this.database = database;
    }
    
    public void update(String type, String id, Object obj){
        
    }
}
