/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author melissa
 */
public class DatabaseAdder {
    private final MongoDatabase database;
    
    public DatabaseAdder(MongoDatabase database){
        this.database = database;
    }
    
    public void add(String type, Object obj){
        MongoCollection<Document> collec = database.getCollection(type);
        
        
    }
}
