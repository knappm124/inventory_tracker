/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.knappm124.inventorytracker.collections.Item;
import com.knappm124.inventorytracker.collections.Location;
import com.knappm124.inventorytracker.collections.Tag;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
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
        Document d;
        switch (type){
            case "tag" -> {
                Tag t = (Tag) obj;
                d = new Document("name",t.getName());
                d.append("options",t.getOptions());
            }
            case "location" -> {
                Location l = (Location) obj;
                d = new Document("name",l.getName());
            }
            case "item" -> {
                Item i = (Item) obj;
                d = new Document("name",i.getName());
                d.append("price",i.getPrice());
                d.append("status",i.getStatus());
                ArrayList<Document> docs = new ArrayList<>();
                for (Tag t2 : i.getTags().keySet()){
                    Document d2 = new Document("tag_id",t2.getTagId());
                    d2.append("selected",i.getTags().get(t2));
                    docs.add(d2);
                }
                d.append("tags",docs);
            }
            default -> throw new IllegalArgumentException("Object is of incorrect type");
        }
        collec.insertOne(d);
        
    }
}
