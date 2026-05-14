/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author melissa
 */
public class DatabaseRemover {
    private final MongoDatabase database;
    
    public DatabaseRemover(MongoDatabase database){
        this.database = database;
    }
    
    public void remove(String type, String id){
        ObjectId oid = new ObjectId(id);
        MongoCollection<Document> collec = database.getCollection(type);
        Bson filter = Filters.eq("_id", oid);
        collec.deleteOne(filter);

    }
}
