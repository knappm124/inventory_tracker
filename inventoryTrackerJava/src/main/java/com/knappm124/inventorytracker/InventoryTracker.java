/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.knappm124.inventorytracker;

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
        
        Location l = new Location("General Store");
        
        DatabaseConnector dc = new DatabaseConnector(uri);
        dc.updateCollection(l);
        dc.getCollection();
        dc.print();
    }
}
