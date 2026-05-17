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

    
    public void execute(String type){
        switch(type){
            case "PRINT" -> print();
            case "GETALL" -> getCollection();
            default -> throw new IllegalArgumentException("Execution type is invalid");
        }
    }
    
    public Object execute(String type, String id){
        if(type.equals("GET")){
            return get(id);
        } else {
            throw new IllegalArgumentException("Execution type is invalid or input is incorrect");
        }
    }
    
    public void execute(String type, Object obj){
        switch (type){
            case "ADD" -> add(obj);
            case "REMOVE" -> remove(obj);
            default -> throw new IllegalArgumentException("Execution type is invalid");
        }
    }
    
    public void execute(String type, Object obj1, Object obj2) {
        if(type.equals("UPDATE") && obj1.getClass().equals(obj2.getClass())){
            update(obj1,obj2);
        } else {
            throw new IllegalArgumentException("Execution type is invalid or inputs are not of the same type");
        }
    }
    
    private Object get(String id){
        return dbgetter.get(id);
    }
   
    private void getCollection() {
        collections = dbgetter.get();
    }
    
    private void add(Object obj){
        switch (obj) {
            case Location l -> dbadder.add("locations",l.getId());
            case Item i -> dbadder.add("items",i.getItemId());
            case Tag t -> dbadder.add("tag",t.getTagId());
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }
  
    private void update(Object obj, Object obj2){
        switch (obj) {
            case Location l -> dbupdater.update("locations",l.getId(),obj2);
            case Item i -> dbupdater.update("items",i.getItemId(),obj2);
            case Tag t -> dbupdater.update("tags",t.getTagId(),obj2);
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }

    private void remove(Object obj) {
        switch (obj) {
            case Location l -> dbremover.remove("locations",l.getId());
            case Item i -> dbremover.remove("items",i.getItemId());
            case Tag t -> dbremover.remove("tag",t.getTagId());
            default -> throw new IllegalArgumentException("Object is not of valid type");
        }
    }
    
    private void print() {
        System.out.println(collections.getAllItems());
        System.out.println(collections.getTags());
        System.out.println(collections.getLocations());
    }
}
