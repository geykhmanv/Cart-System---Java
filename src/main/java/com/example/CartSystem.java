package com.example;

import java.util.Collection;

public class CartSystem extends TheSystem {
	
    CartSystem() {
    }

    @Override
    public void display() {
    	
     System.out.println("Cart:");
//     System.out.println("-----------------------------------------------------------------------------------------");
     System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "Name", "Description", "Price", "Quantity", "Sub Total");
//     System.out.println("-----------------------------------------------------------------------------------------");
     
     
     double itemSubtotal = 0;
     double preTaxTotal = 0;
     Collection<Item> items = itemCollection.values();
     for(Item item : items) {
    	itemSubtotal = item.getQuantity() * item.getItemPrice();
    	preTaxTotal += itemSubtotal;
     	System.out.format("%-20s %-20s %-10.2f %-10d %-10.2f%n", item.getItemName(), 
     			item.getItemDesc(), item.getItemPrice(), item.getQuantity(), itemSubtotal);
     }//  for(Item item : items)
//     System.out.println(" ");
//     System.out.println("-----------------------------------------------------------------------------------------");
     
     double tax = preTaxTotal*.05;
     double total = preTaxTotal + tax;
     
     System.out.printf("%-20s ", "Pre-tax Total");
     System.out.format("%-20.2f%n", preTaxTotal);
//     System.out.println("---------------------------------------------");
     System.out.printf("%-20s ", "Tax");
     System.out.format("%-20.2f%n", tax);
//     System.out.println("---------------------------------------------");
     System.out.printf("%-20s ", "Total");
     System.out.format("%-20.2f%n", total);
    	
    }//public void display()
   
}//public class CartSystem extends TheSystem
