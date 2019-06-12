/* @author Audrey Kim 
 * 
 */



package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)	{
	    // Add your command loop here
		Scanner sc = new Scanner(System.in); 					// creates scanner 
		System.out.println("nani ");							// prompts user for command 
    	String input = sc.nextLine(); 				    		// takes in input 
    	Spreadsheet sheet = new Spreadsheet();					// constructs new spreadsheet 
    	while(!input.equalsIgnoreCase("quit")) {        		// program runs until user input = quit 
    		System.out.println(sheet.processCommand(input));	// print out output of produceAnswer using user input 
    		System.out.println("nani ");						// prompts user for command 
    		input = sc.nextLine(); 								// scanner asks user for next line of input 
    	}
    	sc.close(); 											//closes the scanner 
    	
	}
	
	public static String fullCellText(String str) {
		return "\"" + str + "\"";
	}
	
//	public static String abbreviatedCellText(String str) {
//		String stri = str[0:10];
//		return stri;
//	}
}
