/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.knappm124.inventorytracker.collections.Collections;
import com.knappm124.inventorytracker.collections.Item;
import com.knappm124.inventorytracker.collections.Location;
import com.knappm124.inventorytracker.collections.Tag;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author melissa
 */
public class DatabaseConnector {

    private Collections collections;
    private final DatabaseRemover dbremover;
    private final DatabaseAdder dbadder;
    private final DatabaseUpdater dbupdater;
    private final DatabaseGetter dbgetter;

    public DatabaseConnector(MongoDatabase database) {
        collections = new Collections();
        dbremover = new DatabaseRemover(database);
        dbadder = new DatabaseAdder(database);
        dbupdater = new DatabaseUpdater(database);
        dbgetter = new DatabaseGetter(database);
    }

    public void getCollection() {
        collections = dbgetter.get();
    }
    
    public Object get(String id){
        return dbgetter.get(id);
    }
   
    public void add(Object obj){
        switch (obj) {
            case Location l -> dbadder.add("locations",l.getId());
            case Item i -> dbadder.add("items",i.getItemId());
            case Tag t -> dbadder.add("tag",t.getTagId());
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }
  
    public void update(Object obj, Object obj2){
        switch (obj) {
            case Location l -> dbupdater.update("locations",l.getId(),obj2);
            case Item i -> dbupdater.update("items",i.getItemId(),obj2);
            case Tag t -> dbupdater.update("tags",t.getTagId(),obj2);
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }

    public void remove(Object obj) {
        switch (obj) {
            case Location l -> dbremover.remove("locations",l.getId());
            case Item i -> dbremover.remove("items",i.getItemId());
            case Tag t -> dbremover.remove("tag",t.getTagId());
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }
    
    public void print() {
        System.out.println(collections.getAllItems());
        System.out.println(collections.getTags());
        System.out.println(collections.getLocations());
    }
}
