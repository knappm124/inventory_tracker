/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 *
 * @author melissa
 */
  

    public class Item implements Serializable {

        private UUID itemId;
        private String name;
        private double price;
        private HashMap<Tag, ArrayList<String>> tags = new HashMap();
        private Status itemStatus;
        private UUID locationId;
//        private String imgSrc;
        private static final long serialVersionUID = 1L;

        private Item(ItemBuilder builder) {
            itemId = UUID.randomUUID();
            this.name = builder.name;
            this.price = builder.price;
            this.tags = builder.tags;
            this.locationId = builder.locationId;
            this.itemStatus = builder.itemStatus;
//            this.imgSrc = builder.imgSrc;
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

        public UUID getLocation(){
            return locationId;
        }
        
        public void setLocation(UUID locationId){
            this.locationId = locationId;
        }
        
        public UUID getItemId() {
            return itemId;
        }

        //for testing only
        public void setItemId(UUID id) {
            itemId = id;
        }
        
        public UUID getLocationId(){
            return locationId;
        }
        
        public void setLocationId(UUID locationId){
            this.locationId = locationId;
        }
        
        public HashMap<Tag, ArrayList<String>> addTag(Tag t, String option) {
            if (t.getOptions().contains(option)) {
                if (tags.containsKey(t)) {
                    if (tags.get(t).contains(option)) {
                        throw new IllegalArgumentException(option + " is already chosen for tag " + t);
                    } else {
                        tags.get(t).add(option);
                    }
                } else {
                    if (t.contains(option)) {
                        ArrayList<String> s = new ArrayList<>();
                        s.add(option);
                        tags.put(t, s);
                    } else {
                        throw new IllegalArgumentException("Invalid option chosen for tag " + t);
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid option chosen for tag " + t);
            }
            return tags;
        }

        public HashMap<Tag, ArrayList<String>> removeOption(Tag tag, String option) {
            for (Tag t : tags.keySet()) {
                if (t.equals(tag)) {
                    System.out.println(tags.get(t).contains(option));
                    if (tags.get(t).contains(option)) {
                        tags.get(t).remove(option);
                        return tags;
                    } else {
                        throw new IllegalArgumentException(option + " is not set for tag " + tag);
                    }
                } else {
                    System.out.println("Equals is false");
                }
            }
            throw new IllegalArgumentException(tag + "is not a valid tag");
        }
    

    public boolean containsTag(Tag tag) {
        return tags.containsKey(tag);
    }

    public HashMap<Tag,ArrayList<String>> getTags(){
        return tags;
    }
    
    public ArrayList<String> getOptions(String name) {
        for(Tag t : tags.keySet()) {
            if(t.getName().equals(name)){
                return tags.get(t);
            }
        }
        throw new IllegalArgumentException(name + " is not a valid tag");
    }
    
//    public String getImage(){
//        return imgSrc;
//    }
//    
//    public void setImage(String imgSrc){
//        this.imgSrc = imgSrc;
//    }

    @Override
    public String toString() {
        String temp = "";
        switch (itemStatus) {
            case Status.LISTED:
                temp = "listed";
                break;
            case Status.RETURNED:
                temp = "returned";
                break;
            case Status.SOLD:
                temp = "sold";
                break;
            case Status.WIP:
                temp = "in progress";
                break;
        }

        StringBuilder sb = new StringBuilder(name);
        sb.append(" has a price of ");
        String cost = String.format("%.2f", price);
        sb.append(cost);
        sb.append(" is ");
        sb.append(temp);
        sb.append(" and is categorized as ");
        for (ArrayList<String> a : tags.values()) {
            for (String s : a) {
                sb.append(s);
                sb.append(", ");
            }
        }
        int end = sb.length();
        sb.delete(end - 2, end);

        return sb.toString();
    }  

    public static class ItemBuilder {
        private String name;
        private double price;
        private HashMap<Tag, ArrayList<String>> tags = new HashMap();
        private Status itemStatus;
        private UUID locationId;
      //  private String imgSrc;

        public ItemBuilder(String name) {
            this.name = name;
        }

        public ItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withStatus(Status itemStatus) {
            this.itemStatus = itemStatus;
            return this;
        }
        
        public ItemBuilder withStatus(String status){
            status = status.toUpperCase();
            this.itemStatus = Status.valueOf(status);
            return this;
        }

        public ItemBuilder withTags(HashMap<Tag, ArrayList<String>> tags) {
            this.tags = tags;
            return this;
        }
//        
        public ItemBuilder withLocationId(UUID locationId){
            this.locationId = locationId;
            return this;
        }
        
//        public ItemBuilder withImage(String imSrc){
//            this.imgSrc = imgSrc;
//            return this;
//        }
        
        public ItemBuilder withLocationId(String locationId){
            this.locationId = UUID.fromString(locationId);
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }
}
