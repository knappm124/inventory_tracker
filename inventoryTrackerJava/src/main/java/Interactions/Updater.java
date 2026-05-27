/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interactions;

import com.knappm124.inventorytracker.collections.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author melissa
 */
public class Updater {

    private HashMap<Integer, Tag> tags = new HashMap<>();
    private HashMap<Integer, Location> locations = new HashMap<>();
    private HashMap<Integer, Item> items = new HashMap<>();
    private Collections c;

    public Updater(Collections c) {
        this.c = c;
        int counter = 1;
        for (Item i : c.getAllItems()) {
            items.put(counter, i);
            counter++;
        }
        counter = 1;
        for (Tag t : c.getTags()) {
            tags.put(counter, t);
            counter++;
        }
        counter = 1;
        for (Location l : c.getLocations()) {
            locations.put(counter, l);
            counter++;
        }
    }

    public Collections updateItem() throws IOException {
        System.out.println("Which item do you want to update?");
        for (int n : items.keySet()) {
            System.out.println(n + ". " + items.get(n).toString());
        }
        int n = System.in.read();
        String s = items.get(n).getItemId();
        Item i = c.getItem(s);
        int m = 0;
        while (0 >= m || m >= 6) {
            System.out.println("What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Price");
            System.out.println("3. Status");
            System.out.println("4. Location");
            System.out.println("5. Tags");
            m = System.in.read();
            Item temp;
            switch (m) {
                case 1:
                    temp = updateItemName(i);
                    items.put(n, temp);
                    c.updateItem(i, temp);
                    break;
                case 2:
                    temp = updateItemPrice(i);
                    items.put(n, temp);
                    c.updateItem(i, temp);
                    break;
                case 3:
                    temp = updateItemStatus(i);
                    items.put(n, temp);
                    c.updateItem(i, temp);
                    break;
                case 4:
                    updateItemLocation(i);
                    break;
                case 5:
                    updateItemTag(i);
                    break;
                default:
                    System.out.println("Invalid choice selected");
            }
        }
        return c;
    }

    public Collections updateTag() {
        return c;
    }

    public Collections updateLocation() throws IOException {
        while (true) {
            System.out.println("Which location do you want to update?");
            for (int i : locations.keySet()) {
                System.out.println(i + ". " + locations.get(i));
            }
            int n = System.in.read();
            if (locations.containsKey(n)) {
                System.out.println("This location is currently called " + locations.get(n));
                System.out.println("What should the new name be?");
                Scanner sc = new Scanner(System.in);
                String temp = sc.nextLine();
                sc.close();
                Location l = locations.get(n);
                c.updateLocation(l, temp);
                locations.put(n, l);
                break;
            } else {
                System.out.println(n + " is not a valid location");
            }
        }
        return c;
    }

    public void updateItemTag(Item i) {

    }

    public Item updateItemPrice(Item i) {
        while (true) {
            System.out.println("Current price is " + i.getPrice());
            System.out.println("What should the price be?");
            Scanner sc = new Scanner(System.in);
            Double temp = sc.nextDouble();
            if (temp > 0) {
                i.setPrice(temp);
                break;
            } else {
                System.out.println(temp + " is not a valid price");
            }
        }
        return i;
    }

    public Item updateItemName(Item i) {
        System.out.println("Current name is " + i.getName());
        System.out.println("What should the name be?");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        i.setName(temp);
        return i;
    }

    public Item updateItemStatus(Item i) {
        System.out.println("Current status is " + i.getStatus());
        System.out.println("What should the status be?");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        temp = temp.toUpperCase();
        if (temp == "SOLD" || temp == "WIP" || temp == "RETURNED" || temp == "LISTED");
        Status s = Status.valueOf(temp);
        i.setStatus(s);
        return i;
    }

    public void updateItemLocation(Item i) throws IOException {
        Boolean found = false;
        String name = "";
        for (Location l : c.getLocations()) {
            if (l.getId().equals(i.getLocationId())) {
                name = l.getName();
                found = true;
            }
        }
        if (found) {
            System.out.println("Item is currently at " + name);
            System.out.println("Where do you want to move it to?");
            for (int n : locations.keySet()) {
                System.out.println(n + ". " + locations.get(n).getName());
            }
            while (true) {
                int n = System.in.read();
                if (locations.containsKey(n)) {
                    String locationId = locations.get(n).getId();
                    Item temp = items.get(n);
                    temp.setLocationId(locationId);
                    items.put(n, temp);
                    c.updateItem(i, temp);
                    break;
                }
            }
        } else {
            System.out.println("Error, location not found");
        }

    }
    
    public void updateCollection(Collections c){
        this.c = c;
    }
}
