/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author melissa
 */
public class Tag implements Serializable {

    private String tagId;
    private String name;
    private final ArrayList<String> options;
    private static final long serialVersionUID = 1L;

    private Tag(TagBuilder builder) {
        this.tagId = builder.tagId;
        this.name = builder.name;
        this.options = builder.options;
    }

    public void setTagId(String tagId){
        this.tagId = tagId;
    }
    
    public String getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
    
    @Override
    public boolean equals(Object obj){
        Tag t = (Tag) obj;
        return name.equals(t.getName()) && options.equals(t.getOptions());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.options);
        return hash;
    }
    
    public boolean contains(String option){
        return options.contains(option);
    }

    public void addOption(String newOption) {
        if (options.indexOf(newOption) != -1) {
            throw new IllegalArgumentException("This option already exists for this tag");
        } else {
            options.add(newOption);
        }
    }

    public void removeOption(String option) {
        if (options.indexOf(option) == -1) {
            throw new IllegalArgumentException("This option does not exist for this tag");
        } else {
            options.remove(option);
        }
    }
    
    @Override
    public String toString(){
        String tag = "Tag ";
        tag = tag + tagId;
        tag = tag + " is called ";
        tag = tag + name;
        tag = tag + " and has options: ";
        for(String s : options){
            tag = tag + s;
            tag = tag + ", ";
        }
        tag = tag.substring(0,tag.length() -2);
        return tag;
    }

    public static class TagBuilder {

        private String tagId;
        private String name;
        private ArrayList<String> options;
        
        public TagBuilder(String name){
            this.name = name;
            this.options = new ArrayList();
        }
        
        public TagBuilder withOptions(ArrayList<String> options){
            this.options = options;
            return this;
        }
        
        public Tag build(){
            return new Tag(this);
        }
    }
}
