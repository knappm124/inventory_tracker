/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.knappm124.inventorytracker;

import com.knappm124.inventorytracker.collections.Tag;
import com.knappm124.inventorytracker.database.DatabaseConnector;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author melissa
 */
public class InventoryTracker {

    public static void main(String[] args)  {
        String uri = "mongodb+srv://";

        uri = uri + System.getenv("DBUSR");
        uri = uri + System.getenv("DBPWD");
        uri = uri + System.getenv("DBCLSTR");
        
        ArrayList<String> options = new ArrayList<>();
        options.add("Red");
        options.add("Orange");
        options.add("Yellow");
        options.add("Green");
        options.add("Blue");
        options.add("Purple");
        Tag t = new Tag.TagBuilder("Colors").withOptions(options).build();
        
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Blue");
        options2.add("Red");
        options2.add("Green");
        options2.add("Gold");
        Tag t2 = new Tag.TagBuilder("Color").withOptions(options2).build();
        t2.setTagId("69fe5e96e4bb6f816ad47bb5");
        
        try {
            MongoClient mc = MongoClients.create(uri);
            MongoDatabase database = mc.getDatabase("Inventory");
            DatabaseConnector dc = new DatabaseConnector(database);
            dc.getCollection();
            dc.update(t2, t);
            dc.getCollection();
            dc.print();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
