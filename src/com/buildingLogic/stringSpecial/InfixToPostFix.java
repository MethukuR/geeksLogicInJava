package com.buildingLogic.stringSpecial;

import java.util.Stack;

/**
 *  Infix expression:The expression of the form a op b. When an operator is in-between 
 *  				 every pair of operands.
	Postfix expression:The expression of the form a b op. When an operator is followed 
	                   for every pair of operands.
	Why postfix representation of the expression?
	---------------------------------------------
	The compiler scans the expression either from left to right or from right to left.
	Consider the below expression: a op1 b op2 c op3 d
	If op1 = +, op2 = *, op3 = +
	The compiler first scans the expression to evaluate the expression b * c, then again 
	scan the expression to add a to it. The result is then added to d after another scan.
	The repeated scanning makes it very in-efficient. It is better to convert the 
	expression to postfix(or prefix) form before evaluation.
	The corresponding expression in postfix form is: abc*d++. The postfix expressions can 
	be evaluated easily using a stack. 
	
	Algorithm:
	---------
	1. Scan the infix expression from left to right.
	2. If the scanned character is an operand, output it.
	3. Else,
	…..3.1 If the precedence of the scanned operator is greater than the precedence of 
	       the operator in the stack(or the stack is empty), push it.
	…..3.2 Else, Pop the operator from the stack until the precedence of the scanned 
	       operator is less-equal to the precedence of the operator residing on the top of 
	       the stack. Push the scanned operator to the stack.
	4. If the scanned character is an ‘(‘, push it to the stack.
	5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is 
	   encountered.
	6. Repeat steps 2-6 until infix expression is scanned.
	7. Pop and output from the stack until it is not empty.
===========================================================================================	
	1.Scan the Infix string from left to right.
	2.Initialise an empty stack.
	3.If the scannned character is an operand, add it to the Postfix string. If the scanned 
		character is an operator and if the stack is empty Push the character tostack.
	4.If the scanned character is an Operand and the stack is not empty, compare the 
		precedence of the character with the element on top of the stack(topStack). If 
		topStack has higher precedence over the scanned character Popthe stack else Push the 
	    scanned character to stack. Repeat this step as long as stack is not empty and 
		topStack has precedence over the character.
		(After all characters are scanned, we have to add any character that the stackmay 
		have to the Postfix string.) If stack is not empty add topStack to Postfix string
		and Pop the stack. Repeat this step as long as stack is not empty.
	5.Return the Postfix string.
 
 * @author Raju Rockzz :P
 *
 */
public class InfixToPostFix {

	public static void main(String[] args) {
		String infixExpression="a+b*(c^d-e)^(f+g*h)-i";
		convertInfixToPostFix(infixExpression);
	}
	
	private static void convertInfixToPostFix(String infixExpression) {
		Stack<String> postFixStack= new Stack<String>();
		int expLength=infixExpression.length();
		String postFix="";
		for (int i = 0; i < expLength; ++i) {
			char curChar=infixExpression.charAt(i);
			String curString=String.valueOf(curChar);
			if(isAlphabet(curChar)){
				postFix+=curString;
			}
			else if(curString.equals("(")){
				postFixStack.push(curString);
			}
			else if (curString.equals(")")) {
                String peek = postFixStack.peek();
                while (!(peek.equals('(')) && !(postFixStack.isEmpty())) {
                    postFix += peek;
                    postFixStack.pop();
                    peek=postFixStack.peek();
                }
                postFixStack.pop();
			}
			/*else if(postFixStack.isEmpty() || (operatorPrecedence(curString) > operatorPrecedence(postFixStack.peek())) ){
				postFixStack.push(curString);
			}*/
			else if(!postFixStack.isEmpty() && operatorPrecedence(curString) <= operatorPrecedence(postFixStack.peek())){
				while(operatorPrecedence(curString) > operatorPrecedence(postFixStack.peek())){
					postFix+=postFixStack.peek();
					postFixStack.pop();
				}
				postFixStack.push(curString);
			}
		}
		
		while(!postFixStack.isEmpty()){
			postFix+=postFixStack.peek();
			postFixStack.pop();
		}
		
		System.out.println("postFix "+postFix);
	}

	private static boolean isAlphabet(char term) {
		if((term >= 'A' && term <= 'Z') || (term >= 'a' && term <= 'z')){
			return true;
		}
		return false;
	}
	
	private static int operatorPrecedence(String s){
		if(s == "^"){
			return 3;
		}
		else if(s == "*" || s== "/"){
			return 2;
		}
		else if(s == "+" || s== "-"){
			return 1;
	    }
		
		return -1;
	}

}
