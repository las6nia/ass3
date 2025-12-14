package package1;
import java.util.Scanner;
public class Ass3display {

	static String [ ] itemNames = new String[25]; 
	static double [ ][ ] itemInfo = new double[25][5]; 

	static int itemCount = 0;
	static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
	}


	public static void ProcessDisplayCommand()
	{
		// 显示表头
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
	}
}