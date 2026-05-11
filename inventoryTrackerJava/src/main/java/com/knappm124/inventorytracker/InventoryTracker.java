/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.knappm124.inventorytracker;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author melissa
 */
public class InventoryTracker {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String uri = "mongodb+srv://";

        uri = uri + System.getenv("DBUSR");
        uri = uri + System.getenv("DBPWD");
        uri = uri + System.getenv("DBCLSTR");
        System.out.println(uri);

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Inventory");
            MongoCollection<Document> collection = database.getCollection("items");
            Document doc = collection.find(eq("name", "Bird Egg")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
    
            Document doc2 = new Document("name","New Egg")
                                .append("price", 30)
                                .append("status", "Listed");

            InsertOneResult result = collection.insertOne(doc2);
            
            Document doc3 = collection.find(eq("name", "New Egg")).first();
            if (doc != null) {
                System.out.println(doc3.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
