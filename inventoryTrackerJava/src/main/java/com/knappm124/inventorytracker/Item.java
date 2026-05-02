/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;

/**
 *
 * @author melissa
 */
public class Item implements Serializable {

    private int itemId;
    private String name;
    private double price;
    private HashMap<Tag, ArrayList<String>> tags = new HashMap();
    private int locationId;
    private Status itemStatus;
    private static final long serialVersionUID = 1L;

    private Item(ItemBuilder builder) {
        this.itemId = builder.itemId;
        this.name = builder.name;
        this.price = builder.price;
        this.tags = builder.tags;
        this.locationId = builder.locationId;
        this.itemStatus = builder.itemStatus;
    }

    public String getName() {
        return name;
    }

    public String setName(String newName) {
        return name = newName;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double newPrice) {
        return price = newPrice;
    }

    public Status getStatus() {
        return itemStatus;
    }

    public Status setStatus(Status newStatus) {
        return itemStatus = newStatus;
    }

    public int getLocationId() {
        return locationId;
    }

    public int setLocationId(int newLocationId) {
        return locationId = newLocationId;
    }

    public int getItemId() {
        return itemId;
    }

    public HashMap<Tag, ArrayList<String>> addTag(Tag t, String option) {
        if (t.getOptions().contains(option)) {
            if (tags.containsKey(t)) {
                if (tags.get(t).contains(option)) {
                    throw new IllegalArgumentException(option + " is already chosen for tag " + t);
                } else {
                    tags.get(t).add(option);
                    return tags;
                }
            } else {
                throw new IllegalArgumentException(t + " is not a valid tag");
            }
        } else {
            throw new IllegalArgumentException("Invalid option chosen for tag " + t);
        }
    }

    public HashMap<Tag, ArrayList<String>> removeTag(Tag t, String option) {
        if (t.getOptions().contains(option)) {
            if (tags.containsKey(t)) {
                if (tags.get(t).contains(option)) {
                    tags.get(t).remove(option);
                    return tags;
                } else {
                    throw new IllegalArgumentException(option + " is not set for tag " + t);
                }
            } else {
                throw new IllegalArgumentException(t + " is not a valid tag");
            }
        } else {
            throw new IllegalArgumentException("Invalid option chosen for tag " + t);
        }
    }

    public class ItemBuilder {

        private int itemId;
        private String name;
        private double price;
        private HashMap<Tag, ArrayList<String>> tags = new HashMap();
        private int locationId;
        private Status itemStatus;

        public ItemBuilder(String name) {
            itemId = IdMaker.newId();
            this.name = name;
        }

        public ItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withLocation(int locationId) {
            this.locationId = locationId;
            return this;
        }
        
        public ItemBuilder withStatus(Status itemStatus){
            this.itemStatus = itemStatus;
            return this;
        }
        
        public ItemBuilder withTags(HashMap<Tag,ArrayList<String>> tags){
            this.tags = tags;
            return this;
        }
        
        public Item build() {
            return new Item(this);
        }

    }
}
