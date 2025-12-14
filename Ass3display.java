package package1;
    import java.util.Scanner;
    public class Ass3display {
    	

    	//arrays needed
    	static String [ ] itemNames = new String[25];  //first array
    	static double [ ][ ] itemInfo = new double[25][5];  //second array
    	static Scanner input = new Scanner (System.in);
    	
    	
    	public static void main(String[] args) { //start of main    		
        
        String itemName; //self explanatory :D
		int pOrdered; //number of pieces ordered
		int pInStore; //number of pieces currently in the store
		int pSold; //number of pieces sold
		double manufPrice; //manufacturer’s price for the item
		double sellingPrice; //store’s selling price
		ProcessCommands();
		
		
		
		
        
        
    
    	
    	
    	
    	
    	
    	} // end of main
    
    	

//----------------------------------------------------------------- 
//The Find function takes a name as the parameter. It determines 
// whether an item with that name is in the itemNames list. If so, 
// it returns the index of where the item is stored. If there is no // item in the list with that name, it returns -1.
//params: (String) 

public static int FindIndexOfItem(String lookUpItem)
{//start FinIndexOfItem method
	 	for (int i = 0; i < itemNames.length; i++) {
	       if (itemNames[i] == null) 
	    	   break;

	        if (itemNames[i].equalsIgnoreCase(lookUpItem)) { //ifnoring if capital or lower
	            return i; //(index)
	        }
	    }
	    return -1;
	
	
	
}//end FinIndexOfItem method


//----------------------------------------------------------------- 
//The function reads and processes user’s commands. After reading a 
// command, the next step is to call the corresponding method for each 
// command. The method uses switch statements for that.
//params: (none) 

public static void ProcessCommands( )
{//start of ProcessCommands method
 
	String command;
	command = input.next();
	while (! (command.equalsIgnoreCase("Quit"))) 
	{ // start of while loop (option)
		switch ( command.toLowerCase())
		{
			case "add":
				ProcessAddCommand( ); 
				break;
			case "output":
				//ProcessOutputCommand( ); 
				break;
			case "sell": 
				//ProcessSellCommand( ); 
				break;
			case "display": 
				//ProcessDisplayCommand( ); 
				break;
			default:
				System.out.println("Bad command.");
				input.nextLine(); //////// skip the rest of the line
				break;
		} // end switch
		
		command = input.next(); // read the next command ----come back---- why a second command?
	} // end while loop
} // end of method ProcessCommands

    
//----------------------------------------------------------------- 
//The method processes add commands. It adds a new item into the
//store’s database. The method reads in the itemName, pOrdered,
//manufPrice, and sellingPrice. 
				//The new item must be added to the end 
// of the list if an item with that name doesn't already exist. The 
// name will be a string, while other values are of type double. 
			// The method doesn't need to check this. 
//Note that the method should set 
// the number of pieces (of an item) in the store as the same as the 
// number of pieces ordered, and it should set the number of pieces of 
// the item sold is zero. If the item is already in the list, the
//method should print an appropriate message.
//params: (none) 
public static void ProcessAddCommand()
{//start of ProcessAddComment method
	String itemName;
	double  pOrdered;
	double manufPrice;
	double sellingPrice;

//System.out.print("\nEnter name of item to add: ");										//this is my testing to check my input - lra
	itemName = input.next();
	pOrdered = input.nextDouble();
	manufPrice = input.nextDouble();
	sellingPrice = input.nextDouble();
	
	int index = FindIndexOfItem(itemName);
	if (index != -1) {
		System.out.printf("\ncannot add, %s already in list!\n", itemName);
		return;
		
	}
	
	int itemList = 0;
	
	while (itemList <itemNames.length && itemNames [itemList] != null) {
		itemList++;
	}
	
	if (itemList == itemNames.length) {
		System.out.println("\nCannot add, the list is full.");
		return;
	}
	itemNames [itemList] = itemName;
	itemInfo[itemList][1] = pOrdered;
	itemInfo[itemList][2] = manufPrice;	
	itemInfo[itemList][3] = sellingPrice;
	System.out.printf("\n%s has been added successfully!", itemName);

}//end of ProcessAddComment method

   
//----------------------------------------------------------------- 
//The method processes output commands. The method reads in the
//itemName and then output the item with that name. The method should 
// display the item name along with the number of pieces ordered p,
//number of pieces currently in the store, number of pieces sold,
//manufacturer’s price, and the store’s selling price for the item. 
// If the item doesn't exist, the method should print an appropriate 
// message.
//params: (none) 
public static void ProcessOutputCommand( )
{//start of ProcessOutputCommand method
	String itemName;
	double pOrdered;
	
	
	
}//end of ProcessOutputCommand method

//-----------------------------------------------------------------
//The method processes sell commands. The method reads in the
//itemName and the number of pieces sold in this command (Transaction) 
// If the item does exist in the list, the method updates the
//appropriate counts of the sold item. If the item doesn't exist, the 
// method should print an appropriate message.
//params: (none) 

public static void ProcessSellCommand( )
{//start of ProcessSellCommand method
	 //copied from Mark's github
	String itemName = input.next();
    double soldPieces = input.nextDouble();

          int index = FindIndexOfItem(itemName);
          if (index == -1) {
              System.out.printf("Cannot finish this transaction. %s is not in the list!", itemName);
              return;
          }
          
          // Update pInStore and pSold
          itemInfo[index][1] -= soldPieces;  // pInStore
          itemInfo[index][2] += soldPieces;  // pSold

          // IMPORTANT: manufPrice and sellingPrice are NEVER changed here,
          // which keeps CircularSaw’s prices fixed, matching your correction.
          System.out.printf("%.0f pieces of %s have been sold successfully!\n", soldPieces, itemName);
      


	
}//end of ProcessSellCommand method

//----------------------------------------------------------------- 
//The method processes display commands. The method should display a 
// report of all items in the store and their information in a tabular 
// format. Also, you should display the total inventory (the total
//selling value of all of the items currently in the store) and the
//total number of items (the sum of the number of pieces of all of the 
// items in the store). For instance, total inventory equals the sum of 
// (sellingPrice*pInStore) of all of the items currently in the store 
// params: (none) 
public static void ProcessDisplayCommand( )
{//start of ProcessDisplayCommand method
	System.out.println("Friendly Hardware Store, Green Bay, WI, 54311");
	System.out.println("itemName  pOrdered  pInStore  pSold  manufPrice  sellingPrice");
	System.out.println("--------  --------  --------  -----  ----------  ------------");

	double totalInventory = 0;
	double totalItems = 0;

	for (int index = 0; index < itemCount; index++)
	{
		System.out.printf("%10s  %8.2f  %8.2f  %6.2f  %10.2f  %12.2f%n",
				itemNames[index],
				itemInfo[index][0],  
				itemInfo[index][1],  
				itemInfo[index][2], 
				itemInfo[index][3],  
				itemInfo[index][4]   
				);

		// 统计总数
		totalInventory += itemInfo[index][4] * itemInfo[index][1];
		totalItems += itemInfo[index][1];
	}

	System.out.printf("Total Inventory: $%.2f%n", totalInventory);
	System.out.printf("Total number of items in the store: %.2f%n", totalItems);
	
	
}//end of ProcessDisplayCommand method

//----------------------------------------------------------------- 
}//end class 
