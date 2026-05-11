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
import java.util.ArrayList;
import java.util.HashMap;
import org.bson.Document;

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

    }

    public void updateCollection(Item i) {

    }

    public void updateCollection(Location l) {

    }

    public void removeItem(Item i) {

    }

    public void removeTag(Tag t) {

    }

    public void removeLocation(Location l) {

    }

    public void print() {
        System.out.println(collections.getAllItems());
        System.out.println(collections.getTags());
        System.out.println(collections.getLocations());
    }
}
