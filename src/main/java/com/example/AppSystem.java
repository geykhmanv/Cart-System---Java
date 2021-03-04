package com.example;

import java.util.Collection;


public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
//        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %-10s%n", "Name", "Description", "Price", "Available Quantity");
//        System.out.println("------------------------------------------------------------------------------");
        
        //output the items in the App System in a table
        Collection<Item> items = itemCollection.values();
        for(Item item : items) {
        	System.out.format("%-20s %-20s %-10.2f %-10d%n", item.getItemName(), 
        			item.getItemDesc(), item.getItemPrice(), item.getAvailableQuantity());
        }//  for(Item item : items)
//        System.out.println(" ");
    }//public void display()

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if(item == null) return false;
        if(this.itemCollection.containsKey(item.getItemName())){
        	System.out.println(item.getItemName() + " is already in the App System");
        	return false;
        }
        else {
        	this.itemCollection.put(item.getItemName(), item);
        	return true;
        }
    }//public Boolean add(Item item)

    public Item reduceAvailableQuantity(String item_name) {
		Item currentItem = this.itemCollection.get(item_name);  //if item is not in collection null is returned
		if( currentItem == null )
			return null;
	
		currentItem.setAvailableQuantity(currentItem.getAvailableQuantity() - 1);	
		if( currentItem.getAvailableQuantity() == 0) {
			remove(item_name);
			return null;
		}
		return currentItem;
    }// public Item reduceAvailableQuantity(String item_name) 



}//public class AppSystem extends TheSystem
