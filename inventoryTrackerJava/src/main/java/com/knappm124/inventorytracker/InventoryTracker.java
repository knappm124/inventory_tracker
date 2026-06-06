/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.knappm124.inventorytracker;

import Interactions.Adder;
import Interactions.Remover;
import Interactions.Updater;
import com.knappm124.inventorytracker.collections.Collections;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author melissa
 */
public class InventoryTracker {

    public static void main(String[] args) throws IOException  {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice != 10){
            Collections c = new Collections();
            Adder a = new Adder(c);
            Remover r = new Remover(c);
            Updater u = new Updater(c);
            try {
                c.read();
            } catch (Exception e){
               
            }
            System.out.println("What do you want to do?");
            System.out.println("1. Add a new location");
            System.out.println("2. Add a new tag");
            System.out.println("3. Add a new item");
            System.out.println("4. Edit existing location");
            System.out.println("5. Edit existing tag");
            System.out.println("6. Edit existing item");
            System.out.println("7. Delete existing location");
            System.out.println("8. Delete existing tag");
            System.out.println("9. Delete existing item");
            System.out.println("10. Exit");
            
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    c = a.addLocation();
                    r.updateCollection(c);
                    u.updateCollection(c);
                    choice = 0;
                case 2:
                    c = a.addTag();
                    r.updateCollection(c);
                    u.updateCollection(c);
                    choice = 0;
                case 3:
                    c = a.addLocation();
                    r.updateCollection(c);
                    u.updateCollection(c);
                    choice = 0;
                case 4:
                    c = u.updateLocation();
                    a.updateCollection(c);
                    r.updateCollection(c);
                    choice = 0;
                case 5:
                    c = u.updateTag();
                    a.updateCollection(c);
                    r.updateCollection(c);
                    choice = 0;
                case 6:
                    c = u.updateItem();
                    a.updateCollection(c);
                    r.updateCollection(c);
                    choice = 0;
                case 7:
                    c = r.removeLocation();
                    u.updateCollection(c);
                    a.updateCollection(c);
                    choice = 0;
                case 8:
                    c = r.removeTag();
                    u.updateCollection(c);
                    a.updateCollection(c);
                    choice = 0;
                case 9:
                    c = r.removeItem();
                    u.updateCollection(c);
                    a.updateCollection(c);
                    choice = 0;
                case 10:
                    break;
            }
        }
    }
}
