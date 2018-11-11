package com.buildingLogic.arraySpecial;

import java.util.Stack;

public class GamesOfBrackets {

	public static void main(String[] args) {
		String s=")((((()))())";
		//char[] ch=s.toCharArray();
		
		Stack<Character> stack= new Stack<Character>();
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(0)=='('){
			  stack.push(s.charAt(i));
			  //System.out.println("push"+stack);
		
			  if(s.charAt(i)==')'){
			   stack.pop();
			   stack.pop();
			   //System.out.println("pop"+stack);
			  }
			}
			
			else{
				 stack.push(s.charAt(i));
			     //System.out.println("push"+stack);
			
				 if(s.charAt(i)==')'){
				  stack.pop();
				 // System.out.println("pop"+stack);
				
				 }
			}
		}
		if(stack.isEmpty()){
			System.out.println("yes");
		}
		else{
			System.out.println("No");
		}
	
		
	}
}
