package com.improvingLogic;
/**
 * Rich Farmer:
 * ===========
	An old rich farmer has several farms of different area size. He wants to divide all his farms between his two sons. He wants to 
	allot each farm to either of his sons but doesn t want to divide a farm into two parts. To keep this division of land fair, he 
	wants to divide it as equally as possible i.e. reduce the difference between the total lands allotted to both the sons.
	
	Given area of all the farms, we want to find out whether the farmer can anyhow divide his land between his sons equally or not.
	
	Input Format:
	You will be given a function which contains array of integers as single argument. Each element of the array represent the farm 
	area (in Acres).
	
	Output Format:
	You need to return the yes/no/invalid (in lowercase) from the given function.
	yes: if allocation is possible
	no: if allocation is not possible
	invalid: if the farm area given in array is invalid
	
	
	Sample Test Case 1:
	==================
	Sample Input
	2
	2
	2
	
	Sample Output:
	yes
	
	Explanation
	Suppose the farmer has farms of area 2, 2; then it is possible to divide his lands between his sons equally (Each son gets one 
	farm.)
	
	
	Sample Test Case 2:
	==================
	Sample Input:
	4
	4
	3
	3
	3
	
	Sample Output:
	no
	
	Explanation:
	If the farmer has farms of area 4, 3, 3, 3; then it is impossible to divide them equally between the farmer s sons.
	
	
	Sample Test Case 3:
	==================
	Sample Input:
	6
	3
	7
	5
	8
	4
	3
	
	Sample Output:
	yes
	
	Explanation:
	If the farmer has farms of area 3,7,5,8,4,3; then it is possible to divide his land between his sons equally (one of the gets 
	farms of area 8,7 and other get farms of area 3,3,5,4; making to be 15 units with each ).
	
	
	Sample Test Case 4:
	==================
	Sample Input:
	5
	4
	3
	3
	3
	-1
	
	Sample Output:
	invalid
	
	Explanation:
	If the farmer has farms of area 4,3,3,3,-1; -1 can't be area of any ; then it is impossible to divide them equally between the 
	farmer s son and output will be invalid.
	
 * @author Ranger Raju:P
 *
 */
public class RichFarmer {

	public static void main(String[] args) {
		int[] inpArr={};
		System.out.println(farms_division(inpArr));
	}
	
	public static String farms_division(int[] input1){
	    int leftSum=0;
	    int len=input1.length;
	    
	    for(int i =0 ; i < len; ++i){
	        if(input1[i] >= 0){
	            leftSum+=input1[i];
	        }else{
	            return "invalid";
	        }
	        
	    }
	    
	    int rightSum=0;
	    for(int i =len-1 ; i >= 0; --i){
	        rightSum+=input1[i];
	        
	        leftSum-=input1[i];
	        
	        if(leftSum == rightSum){
	            return "yes";
	        }
	    }
	    
	    return "no";
    }

}
