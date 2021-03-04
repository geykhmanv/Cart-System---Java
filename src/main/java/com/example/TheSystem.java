package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
   
    protected HashMap<String, Item> itemCollection;  
    

    TheSystem() {
//         initialize itemCollection with empty HashMap
        this.itemCollection = new HashMap<String, Item>();
        
//        check if AppSystem is invoking constructor TheSystem(), 
//        read contents of sample.txt, add contents to itemCollection
        if(getClass().getSimpleName().equals("AppSystem")) loadSampleData();
    }//TheSystem()
    
    private void loadSampleData() {   	
         try{
             File sample = new File("./resources/sample.txt");
             Scanner scan = new Scanner(sample);
             while(scan.hasNextLine()){
                 String itemDataLine = scan.nextLine();
                 String[] itemInfo = itemDataLine.split("\s ");
                 Item currentItem = new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]));
                 this.itemCollection.put(currentItem.getItemName(), currentItem);
             }// while(scan.hasNextLine())
             scan.close();
         }catch(FileNotFoundException e){
             System.out.println(e.getMessage());
             e.printStackTrace();
         }//catch(FileNotFoundException e)
    }//public void readFile()
    
    //getter for itemCollection
    public HashMap<String, Item> getItemCollection() {
        return this.itemCollection;
    }//public HashMap<String, Item> getItemCollection()
    
    //setter for itemCollection
    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }//public void setItemCollection(HashMap<String, Item> itemCollection)
    
    public Boolean checkAvailability(Item item) {   	
       
        if(item.getQuantity() >= item.getAvailableQuantity()) {
        	System.out.println("System is unable to add " + item.getItemName() + " to the cart.  "
        			+ "System only has " + item.getAvailableQuantity() + " " + item.getItemName()+ "s.");
        	return false;
        }       
        
        return true;
    }//public Boolean checkAvailability(Item item) 
    
    public Boolean add(Item item) {
        if(item == null) return false;
        
        if(this.itemCollection.containsKey(item.getItemName()) && checkAvailability(item)) {
        	item.setQuantity(item.getQuantity() + 1);
        	return true;
        }
        
        else if(!this.itemCollection.containsKey(item.getItemName())) {
        	this.itemCollection.put(item.getItemName(), item);
        	return true;
        }
        
        return false;
    }//public Boolean add(Item item)

    public Item remove(String itemName) {
        if(this.itemCollection.containsKey(itemName)) {
        	Item removedItem = this.itemCollection.remove(itemName);
        	return removedItem;
        }
        return null;
    }// public Item remove(String itemName)

    public abstract void display();
    
}//public abstract class TheSystem
