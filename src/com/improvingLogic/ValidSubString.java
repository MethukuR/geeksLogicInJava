package com.improvingLogic;
/*
 * Length of the longest valid substring
Given a string consisting of opening and closing parenthesis, find length of the longest valid 
parenthesis substring.

Examples:

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(()))


A Simple Approach is to find all the substrings of given string. For every string, check if it is 
a valid string or not. If valid and length is more than maximum length so far, then update maximum
length. We can check whether a substring is valid or not in linear time using a stack . Time 
complexity of this solution is O(n^2).

An Efficient Solution can solve this problem in O(n) time. The idea is to store indexes of previous
starting brackets in a stack. The first element of stack is a special element that provides index
before beginning of valid substring (base for next valid string).


1) Create an empty stack and push -1 to it. The first element
   of stack is used to provide base for next valid string. 

2) Initialize result as 0.

3) If the character is '(' i.e. str[i] == '('), push index 
   'i' to the stack. 
   
2) Else (if the character is ')')
   a) Pop an item from stack (Most of the time an opening bracket)
   b) If stack is not empty, then find length of current valid
      substring by taking difference between current index and
      top of the stack. If current length is more than result,
      then update the result.
   c) If stack is empty, push current index as base for next
      valid substring.

3) Return result.
 */
import java.util.Stack;

public class ValidSubString {

	public static void main(String[] args) {
		String strOne = "((()()";
		System.out.println("Longest Valid SubString : "+findMaxSubString(strOne));
		
	    String strTwo = "()(()))))";
	    System.out.println("Longest Valid SubString : "+findMaxSubString(strTwo));

	}
	
	static int findMaxSubString(String inputString){
		// Initialize result
		int result=0;
		
		int inputStringLength=inputString.length();
		char[] inputCharArray=inputString.toCharArray();
		
		// Create a stack and push -1 as initial index to it.
		Stack<Integer> tempStack=new Stack<Integer>();
		tempStack.push(-1);
		
		// Traverse all characters of given string
		for(int index=0;index<inputStringLength;++index){
			// If opening bracket, push index of it
			if(inputCharArray[index]=='('){
				tempStack.push(index);
			}
			// If closing bracket, i.e.,str[i] = ')'
			else{
				// Pop the previous opening bracket's index
				tempStack.pop();
				
				// Check if this length formed with base of
	            // current valid substring is more than max 
	            // so far
				if(!tempStack.empty()){
					int temp= index-tempStack.peek();
					result=Math.max(result, temp);
				}
				
				// If stack is empty. push current index as 
	            // base for next valid substring (if any)
				else{
					tempStack.push(index);
				}
			}
		}
		return result;
	}

}
