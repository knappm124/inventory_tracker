/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.knappm124.inventorytracker;

import java.io.FileNotFoundException;
import java.io.IOException;

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

        
        DatabaseConnector dc = new DatabaseConnector(uri);
        dc.getCollection();
        
    }
}
