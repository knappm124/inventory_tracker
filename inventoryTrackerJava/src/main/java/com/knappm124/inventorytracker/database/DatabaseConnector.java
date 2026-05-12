/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.database;

import com.knappm124.inventorytracker.collections.Collections;
import com.knappm124.inventorytracker.collections.Item;
import com.knappm124.inventorytracker.collections.Location;
import com.knappm124.inventorytracker.collections.Tag;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author melissa
 */
public class DatabaseConnector {

    private final String uri;
    private final Collections collections;
    private final DatabaseRemover dbremover;
    private final DatabaseAdder dbadder;
    private final DatabaseUpdater dbupdater;
    private final DatabaseGetter dbgetter;

    public DatabaseConnector(String uri) {
        this.uri = uri;
        collections = new Collections();
        dbremover = new DatabaseRemover(uri);
        dbadder = new DatabaseAdder();
        dbupdater = new DatabaseUpdater();
        dbgetter = new DatabaseGetter(uri);
    }

    public Collections getCollection() {
        return dbgetter.get();
    }
    
    public Object get(String id){
        return dbgetter.get(id);
    }
   

    
    public void addTag(Tag t) {
        String name = t.getName();
        ArrayList<String> options = t.getOptions();
        Document doc = new Document("name", name);
        doc.append("options", options);

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            t.setTagId(id);
            collections.addTag(t);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void addItem(Item i) {
        Document doc = new Document("name", i.getName());
        doc.append("price", i.getPrice());
        doc.append("status", i.getStatus());
        //doc.append("imgSrc",i.getImage());
        HashMap<Tag, ArrayList<String>> tags = i.getTags();
        ArrayList<Document> docs = new ArrayList<>();
        for (Map.Entry<Tag, ArrayList<String>> e : tags.entrySet()) {
            String id = e.getKey().getTagId();
            ArrayList<String> options = e.getValue();
            for (String s : options) {
                Document d2 = new Document(id, s);
                docs.add(d2);
            }
        }
        doc.append("tags", Arrays.asList(docs));

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("items");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            i.setItemId(id);
            collections.addItem(i);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
        public void addLocation(Location l) {
        String name = l.getName();
        Document doc = new Document("name", name);

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("locations");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            l.setId(id);
            collections.addLocation(l);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void updateTag(Tag t){
        Bson update = combine(set("name", t.getName()),set("options",t.getOptions()));
        String id = t.getTagId();
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            Bson filter = Filters.eq("_id", oid);
            collec.updateOne(filter, update);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void updateItem(Item i){
        String id = i.getItemId();
        ArrayList<Document> docs = new ArrayList<>();
        for (Map.Entry<Tag, ArrayList<String>> e : i.getTags().entrySet()) {
            String tagId = e.getKey().getTagId();
            ArrayList<String> options = e.getValue();
            for (String s : options) {
                Document d2 = new Document(tagId, s);
                docs.add(d2);
            }
        }
        Bson update = combine(set("name",i.getName()),
                set("status",i.getStatus()),
                set("price",i.getPrice()),
                //set("imgSrc,i.getImage())
                set("tags",docs));
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("locations");
            Bson filter = Filters.eq("_id", oid);
            collec.updateOne(filter, update);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void updateLocation(Location l){
        Bson update = set("name", l.getName());
        String id = l.getId();
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            Bson filter = Filters.eq("_id", oid);
            collec.updateOne(filter, update);
        } catch (Exception e) {
            System.out.print(e.getMessage());
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
