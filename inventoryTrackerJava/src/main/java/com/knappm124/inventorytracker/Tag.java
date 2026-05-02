/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.util.ArrayList;

/**
 *
 * @author melissa
 */
public class Tag {

    private int tagId;
    private String name;
    private final ArrayList<String> options;

    private Tag(TagBuilder builder) {
        this.tagId = builder.tagId;
        this.name = builder.name;
        this.options = builder.options;
    }

    public int getTagId() {
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

    public void addOption(String newOption) {
        if (options.indexOf(newOption) != -1) {
            throw new IllegalArgumentException("This option already exists for this tag");
        } else {
            options.add(newOption);
        }
    }

    public void removeOption(String option) {
        if (options.indexOf(option) == -1) {
            throw new IllegalArgumentException("This option does not exist");
        } else {
            options.remove(option);
        }
    }

    public static class TagBuilder {

        private int tagId;
        private String name;
        private ArrayList<String> options;
        
        public TagBuilder(String name){
            tagId = IdMaker.newId();
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
