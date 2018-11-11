package com.buildingLogic.stringSpecial;
/**
 *  link: https://simpledevcode.wordpress.com/2014/03/07/using-stacks-to-evaluate-prefix-postfix-notation-expressions-polish-notation/
 * 
 *  Prefix notation (for those that do not know), is a way of writing a mathematical 
 *  expression without the use of parenthesis or brackets. Also known as “Polish notation” 
 *  (which was created by Jan Łukasiewicz to simplify sentential logic), it provides an 
 *  easy way for computers to evaluate order of operations expressions without the use of 
 *  brackets.
 *  
	To start, a prefix notation example is “+34”, which would evaluate to 7 because the 
	expression is 3+4, just in polish notation. Accordingly, there are a lot more examples 
	of polish notation, and for the sample code posted, the algorithm will evaluate the 
	prefix notation from a string array. 
	
	In pseudo-code, the algorithm uses a stack to push and pop values in the expression 
	and then evaluate according to the operator in the expression:
	
	1.First we scan the expression from right to left.
	2.foreach symbol or character in the expression…
	3.if operand (value), then push the value onto stack
	4.if operator (like +, -, *, /), then pop the two values and evaluate, and then push 
	the current result from evaluation onto stack
	5.return top of stack to display final result
	
 * @author Raju Rockzz :P
 *
 */
import java.util.Stack;

public class EvaluationOfPreFixNotation {

	public static void main(String[] args) {
        String preFixExpression="/*572";
		
		int result= evaluatePreFixExpression(preFixExpression);
		System.out.println(result);

	}

	private static int evaluatePreFixExpression(String preFixExpression) {

		char[] preFixArr=preFixExpression.toCharArray();
		int preFixArrLength=preFixArr.length;
		Stack<String> evalStack= new Stack<String>();
		for(int i=preFixArrLength-1; i >= 0 ;--i){
			char term=preFixArr[i];
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
