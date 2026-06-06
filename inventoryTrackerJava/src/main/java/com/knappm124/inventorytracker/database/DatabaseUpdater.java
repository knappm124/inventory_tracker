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
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.UUID;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author melissa
 */
public class DatabaseUpdater {

    private final MongoDatabase database;

    public DatabaseUpdater(MongoDatabase database) {
        this.database = database;
    }

    public void update(String type, UUID id, Object obj) {
        MongoCollection<Document> collec = database.getCollection(type);
        ObjectId oid = new ObjectId(id.toString());
        Bson filter = Filters.eq("_id",oid);
        Document d;
        switch (type) {
            case "tags" -> {
                if (obj.getClass() == Tag.class) {
                    Tag t = (Tag) obj;
                    d = new Document("name", t.getName());
                    d.append("options", t.getOptions());
                } else {
                    throw new IllegalArgumentException("Type is invalid");
                }
            }
            case "locations" -> {
                if (obj.getClass() == Location.class) {
                    Location l = (Location) obj;
                    d = new Document("name", l.getName());
                } else {
                    throw new IllegalArgumentException("Type is invalid");
                }
            }
            case "items" -> {
                if (obj.getClass() == Item.class) {
                    Item i = (Item) obj;
                    d = new Document("name", i.getName());
                    d.append("price", i.getPrice());
                    d.append("status", i.getStatus());
                    ArrayList<Document> docs = new ArrayList<>();
                    for (Tag t2 : i.getTags().keySet()) {
                        Document d2 = new Document("tag_id", t2.getTagId());
                        d2.append("selected", i.getTags().get(t2));
                        docs.add(d2);
                    }
                    d.append("tags", docs);
                } else {
                    throw new IllegalArgumentException("Type is invalid");
                }
            }
            default -> throw new IllegalArgumentException("Type is invalid");
        }
        collec.replaceOne(filter,d);
    }
}
