package com.buildingLogic.stringSpecial;
/*
 * Given a string and number of rows ‘n’. Print the string formed by 
 * concatenating n rows when input string is written in row-wise Zig-Zag 
 * fashion.

Examples:

Input: str = "ABCDEFGH"
       n = 2
Output: "ACEGBDFH"
Explanation: Let us write input string in Zig-Zag fashion
             in 2 rows.
A   C   E   G   
  B   D   F   H
Now concatenate the two rows and ignore spaces 
in every row. We get "ACEGBDFH"

Input: str = "GEEKSFORGEEKS"
       n = 3
Output: GSGSEKFREKEOE
Explanation: Let us write input string in Zig-Zag fashion
             in 3 rows.
G       S       G       S
  E   K   F   R   E   K
    E       O       E
Now concatenate the two rows and ignore spaces 
in every row. We get "GSGSEKFREKEOE"
 */
import java.util.Arrays;

public class ZigZagString {

	public static void main(String[] args) {
		    String str = "GEEKSFORGEEKS";
		    int n = 3;
		    printZigZagConcat(str, n);

	}
	
    static void printZigZagConcat(String str, int n){	
    	String[] strRows = new String[n];
    	
    	for(int strIndex=0;strIndex<n ;++strIndex){
    		strRows[strIndex]=" ";
    	}
    	
	    // Corner Case (Only one row)
	    if (n == 1){
	        System.out.println(str);
	        return;
	    }   
	 
	    // Find length of string
	    int len = str.length();		   
	  	int rowNumber=0;    
	    // Traverse through given string
	    for (int index = 0; index < len ; ++index)
	    {
	    	strRows[rowNumber]=strRows[rowNumber]+"\t"+str.charAt(index);
	       
	    	if(rowNumber < n-1){
	    		++rowNumber;
	    	}
	    	else if(rowNumber == n-1){
	    		rowNumber=0;
	    	}	 	       
	    }
	    
	 
	    // Print concatenation of all rows
	       String zigZagString=Arrays.toString(strRows);
	       //System.out.println("zigZagString unformatted::"+zigZagString);
	       zigZagString = zigZagString.substring(1, zigZagString.length()-1).replaceAll(",", "");
	       //System.out.println("zigZagString:\n"+zigZagString);
	    
	       for(String strIndex: strRows){
	    	   System.out.println(strIndex);
	       }
	}

}
