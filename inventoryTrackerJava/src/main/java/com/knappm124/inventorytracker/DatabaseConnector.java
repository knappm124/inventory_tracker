/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author melissa
 */
public class DatabaseConnector {

    String uri;
    Collections collections;

    public DatabaseConnector(String uri) {
        this.uri = uri;
        collections = new Collections();
    }

    public void getCollection() {
        collections = new Collections();

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            FindIterable<Document> docs = collec.find();
            for (Document d : docs) {
                String tag_id = d.get("_id").toString();
                String name = (String) d.get("name");
                ArrayList<String> options = (ArrayList) d.get("options");
                Tag t = new Tag.TagBuilder(name).withOptions(options).build();
                t.setTagId(tag_id);
                collections.addTag(t);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("items");
            FindIterable<Document> docs = collec.find();
            for (Document d : docs) {
                String name = (String) d.get("name");
                String itemId = d.get("_id").toString();
                Double price = (Double) d.get("price");
                String status = (String) d.get("status");
                ArrayList<Document> doc = (ArrayList<Document>) d.get("tags");
                if (doc == null) {
                    doc = new ArrayList<>();
                }
                HashMap<Tag, ArrayList<String>> tag = new HashMap<>();
                for (Document d2 : doc) {
                    String tag_id = (String) d2.get("tag_id");
                    String selected = (String) d2.get("selected");
                    Tag t = collections.getTag(tag_id);
                    if (tag.containsKey(t)) {
                        ArrayList<String> tagSelection = tag.get(t);
                        tagSelection.add(selected);
                        tag.replace(t, tagSelection);
                    } else {
                        ArrayList<String> tagSelection = new ArrayList<>();
                        tagSelection.add(selected);
                        tag.put(t, tagSelection);
                    }
                }
                Item i = new Item.ItemBuilder(name)
                        .withPrice(price)
                        .withStatus(Status.valueOf(status.toUpperCase()))
                        //                      .withImage(img_src)
                        .withTags(tag).build();
                i.setItemId(itemId);
                collections.addItem(i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("locations");
            FindIterable<Document> docs = collec.find();
            for (Document d : docs) {
                String name = (String) d.get("name");
                String id = d.get("_id").toString();
                Location l = new Location(name);
                l.setId(id);
                collections.addLocation(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCollection(Tag t) {
        String name = t.getName();
        ArrayList<String> options =  t.getOptions();
        Document doc = new Document("name",name);
        doc.append("options",options);
        
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            t.setTagId(id);
            collections.addTag(t);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void updateCollection(Item i) {
        Document doc = new Document("name",i.getName());
        doc.append("price",i.getPrice());
        doc.append("status",i.getStatus());
        HashMap<Tag, ArrayList<String>> tags = i.getTags();
        ArrayList<Document> docs = new ArrayList<>();
        for(Map.Entry<Tag,ArrayList<String>> e : tags.entrySet()){
            String id = e.getKey().getTagId();
            ArrayList<String> options = e.getValue();
            for(String s : options){
                Document d2 = new Document(id,s);
                docs.add(d2);
            }
        }
        doc.append("tags",Arrays.asList(docs));
        
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("items");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            i.setItemId(id);
            collections.addItem(i);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void updateCollection(Location l) {
        String name = l.getName();
        Document doc = new Document("name",name);
        
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("locations");
            InsertOneResult result = collec.insertOne(doc);
            String id = result.getInsertedId().toString();
            l.setId(id);
            collections.addLocation(l);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void removeItem(Item i) {
        String id = i.getItemId();
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("items");
            Bson filter = Filters.eq("_id", oid);
            DeleteResult result = collec.deleteOne(filter);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void removeTag(Tag t) {
        String id = t.getTagId();
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("tags");
            Bson filter = Filters.eq("_id", oid);
            DeleteResult result = collec.deleteOne(filter);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void removeLocation(Location l) {
        String id = l.getId();
        ObjectId oid = new ObjectId(id);
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collec = database.getCollection("locations");
            Bson filter = Filters.eq("_id", oid);
            DeleteResult result = collec.deleteOne(filter);
        } catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void print() {
        System.out.println(collections.getAllItems());
        System.out.println(collections.getTags());
        System.out.println(collections.getLocations());
    }
}
