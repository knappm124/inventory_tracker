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
    
    public Tag(int tagId, String name, ArrayList<String> options){
        this.tagId = tagId;
        this.name = name;
        this.options = options;
    }
    
    public Tag(int tagId, String name) {
        this.tagId = tagId;
        this.name = name;
        this.options = new ArrayList();
    }
    
    public int getTagId() {
        return tagId;
    }
    
    public void setTagId(int id) {
        tagId = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public ArrayList<String> getOptions(){
        return options;
    }
    
    public void addOption(String newOption) {
        if(options.indexOf(newOption) != -1) {
            throw new IllegalArgumentException("This option already exists for this tag");
        } else {
            options.add(newOption);
        }
    }
    
    public void removeOption(String option) {
        if(options.indexOf(option) == -1){
            throw new IllegalArgumentException("This option does not exist");
        } else {
            options.remove(option);
        }
    }
}
