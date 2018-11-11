package com.buildingLogic.stringSpecial;

import java.util.Stack;

/**
	Evaluation Of PostFix Notation:
	----------------------------
	In pseudo-code, the algorithm uses a stack to push and pop values in the expression 
	and then evaluate according to the operator in the expression:
	
	1.First we scan the expression from left to right.
	2.foreach symbol or character in the expression…
	3.if operand (value), then push the value onto stack
	4.if operator (like +, -, *, /), then pop the two values and evaluate, and then push 
	the current result from evaluation onto stack
	5.return top of stack to display final result
	
 * @author Raju Rockzz :P
 *
 */
public class EvaluationOfPostFixNotation {

	public static void main(String[] args) {
		String postFixNotation="235+4*/";
		
		int result= evaluatePostFixExpression(postFixNotation);
		System.out.println(result);
	}

	private static int evaluatePostFixExpression(String postFixNotation) {
		char[] postFixArr=postFixNotation.toCharArray();
		
		Stack<String> evalStack= new Stack<String>();
		for(char term:postFixArr){
			if(isNumber(term)){
				evalStack.push(String.valueOf(term));
			}
			else{
				int secondOperand;
				int firstOperand;
				
			    secondOperand=Integer.parseInt(evalStack.pop());
				firstOperand=Integer.parseInt(evalStack.pop());
				
				int result;
				if(term == '+'){
					result=firstOperand+secondOperand;
					
					evalStack.push(String.valueOf(result));
					System.out.println("top "+evalStack.peek());
				}
				else if(term == '-'){
					result=firstOperand-secondOperand;
					evalStack.push(String.valueOf(result));
					System.out.println("top "+evalStack.peek());
				}
				else if(term == '*'){
					result=firstOperand*secondOperand;
					evalStack.push(String.valueOf(result));
					System.out.println("top "+evalStack.peek());
				}
				else if(term == '/'){
					result=firstOperand/secondOperand;
					evalStack.push(String.valueOf(result));
					System.out.println("top "+evalStack.peek());
				}
				else if(term == '^'){
					result=(int) Math.pow(firstOperand, secondOperand);
					evalStack.push(String.valueOf(result));
					System.out.println("top "+evalStack.peek());
				}
			}
		}
		return Integer.parseInt(String.valueOf(evalStack.peek()));
	}

	private static boolean isNumber(char term) {
		try{
			Integer.parseInt(String.valueOf(term));
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}

}
