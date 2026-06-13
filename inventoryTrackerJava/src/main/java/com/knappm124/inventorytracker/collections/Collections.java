/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 *
 * @author melissa
 */
public class Collections implements Serializable {

    ArrayList<Location> locations;
    ArrayList<Tag> tags;
    ArrayList<Item> items;
    private static final long serialVersionUID = 1L;

    public Collections() {
        locations = new ArrayList();
        Location l = new Location("Home");
        Location l2 = new Location("General Store");
        Location l3 = new Location("Etsy");
        locations.add(l);
        locations.add(l2);
        locations.add(l3);
        
        tags = new ArrayList();
        ArrayList<String> options = new ArrayList<>(Arrays.asList("Red","Orange","Yellow","Green","Blue","Purple","Pink","Brown","Black"));
        Tag t = new Tag.TagBuilder("Colors").withOptions(options).build();
        ArrayList<String> options2 = new ArrayList<>(Arrays.asList("Quail","Pullet","Chicken","Duck","Goose","Rhea","Ostrich"));
        Tag t2 = new Tag.TagBuilder("Size").withOptions(options2).build();
        ArrayList<String> options3 = new ArrayList<>(Arrays.asList("Baby","Christmas","Easter","Fall","Spring","Wedding"));
        Tag t3 = new Tag.TagBuilder("Occassion").withOptions(options3).build();
        ArrayList<String> options4 = new ArrayList<>(Arrays.asList("Animal","Person","Plant","Religious","Star"));
        Tag t4 = new Tag.TagBuilder("Symbols").withOptions(options4).build();
        ArrayList<String> options5 = new ArrayList<>(Arrays.asList("Band","Circles","Diagonal Band","Four Panels","Star","Triangles"));
        Tag t5 = new Tag.TagBuilder("Division").withOptions(options5).build();
        tags.add(t);
        tags.add(t2);
        tags.add(t3);
        tags.add(t4);
        tags.add(t5);
        
        items = new ArrayList();
    }

    public Collections(ArrayList<Location> locations, ArrayList<Tag> tags, ArrayList<Item> items) {
        this.locations = locations;
        this.tags = tags;
        this.items = items;
    }

    public Location addLocation(Location l) {
        for (var location : locations) {
            if (l.getName().equals(location.getName())) {
                throw new IllegalArgumentException("Location already exists");
            }
        }
        locations.add(l);
        return l;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public Location getLocation(String name) {
        for (var location : locations) {
            if (location.getName().equals(name)) {
                return location;
            }
        }
        throw new IllegalArgumentException("Location doesn't exist");
    }

    public void updateLocation(Location l, String name){
        int i = locations.indexOf(l);
        l.setName(name);
        locations.set(i,l);
    }
    
    public void removeLocation(Location l){
        locations.remove(l);
    }
    
    public ArrayList<Tag> getTags() {
        return tags;
    }

    public Tag getTag(String tag_id) {
        for (var tag : tags) {
            if (tag.getTagId().equals(tag_id)) {
                return tag;
            }
        }
        throw new IllegalArgumentException("Location doesn't exist");
    }

    public ArrayList<Tag> addTag(Tag t) {
        for (var tag : tags) {
            if (tag.getName().equals(t.getName())) {
                throw new IllegalArgumentException("This tag already exists");
            }
        }
        tags.add(t);
        return tags;
    }

    public ArrayList<Tag> removeTag(Tag t) {
        for (var tag : tags) {
            if (tag.getName().equals(t.getName())) {
                tags.remove(t);
                return tags;
            }
        }
        throw new IllegalArgumentException("Tag does not exist");
    }
    
    public void updateTag(Tag t, Tag t2){
        int i = tags.indexOf(t);
        tags.add(i,t2);
    }

    public ArrayList<Item> removeItem(UUID itemID) {
        for (Item i : items) {
            if (i.getItemId().toString().equals(itemID.toString())) {
                items.remove(i);
                return items;
            }
        }
        throw new IllegalArgumentException("Item with id " + itemID.toString() + " does not exist");
    }

    public Item getItem(UUID itemId) {
        for (Item i : items) {
            if (i.getItemId().equals(itemId)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Item with id " + itemId + " does not exist");
    }

    public ArrayList<Item> getAllItems() {
        return items;
    }

    public ArrayList<Item> addItem(Item i) {
        items.add(i);
        return items;
    }

    public void updateItem(Item i, Item i2){
        int n = items.indexOf(i);
        items.set(n,i2);
    }
    
    public void read() throws FileNotFoundException, IOException {
        while (true) {
            try {
                FileInputStream file = new FileInputStream("tags.svr");
                ObjectInputStream stream = new ObjectInputStream(file);
                Tag t = (Tag) stream.readObject();
                tags.add(t);
            } catch (Exception e) {
                break;
            }
        }
        while (true) {
            try {
                FileInputStream file = new FileInputStream("locations.svr");
                ObjectInputStream stream = new ObjectInputStream(file);
                Location l = (Location) stream.readObject();
                locations.add(l);
            } catch (Exception e) {
                break;
            }
        }
        while (true) {
            try {
                FileInputStream file = new FileInputStream("items.svr");
                ObjectInputStream stream = new ObjectInputStream(file);
                Item i = (Item) stream.readObject();
                items.add(i);
            } catch (Exception e) {
                break;
            }
        }
        FileInputStream file = new FileInputStream("counter.svr");
        ObjectInputStream stream = new ObjectInputStream(file);

    }

    public void save() throws IOException {
        FileOutputStream file = new FileOutputStream("tags.svr");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        for (Tag t : tags) {
            stream.writeObject(t);
        }
        stream.close();

        FileOutputStream file2 = new FileOutputStream("locations.svr");
        ObjectOutputStream stream2 = new ObjectOutputStream(file2);
        for (Location l : locations) {
            stream2.writeObject(l);
        }
        stream2.close();

        FileOutputStream file3 = new FileOutputStream("items.svr");
        ObjectOutputStream stream3 = new ObjectOutputStream(file3);
        for (Item i : items) {
            stream2.writeObject(i);
        }
        stream3.close();

        FileOutputStream file4 = new FileOutputStream("counter.svr");
        ObjectOutputStream stream4 = new ObjectOutputStream(file4);
        stream4.close();

    }
}
