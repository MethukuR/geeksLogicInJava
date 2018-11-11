package com.buildingLogic.stringSpecial;
/**
 *  Title: Password Validator!
 *  ==========================
	Problem: While making a website, you were tasked to validate user passwords. Your 
	job today is to write a code that will return whether the entered password is a 
	valid one or not. 
	The conditions to check the validity of a password are: 
	The Password should be 8 to 20 character long.
	It should contain at least one uppercase letter(A-Z).
	It shoud have at least one lowercase letter(a-z) .
	It should have at leat one numerical character(0-9).
	It should have at leat one special character($@$!%*?&).
	
	Input: First line of input will contain 'n' that is the number of test cases. 
	The following n lines will contain the password string each.
	Output: For each case the output will return 'True' if the password is valid, and 
	'False' otherwise in new line.
	
	Constraints: 
	
	Number of test cases = n and 0 < n < 50. 
	
	Sample Input: 
	
	2
	Dcoder51
	wrongpass4
	
	Sample Output: 
	True
	False
	
	@author Ranger Raju :P
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

	public static void main(String[] args) {
		String input="Decoder@@1234";
		
		if(isValidPassword(input)){
			System.out.println(true);
		}
		else{
			System.out.println(false);
		}

	}

	private static boolean isValidPassword(String input) {
		
		Pattern p=Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z[0-9]$@$!%*?&]{8,20}");
		
		Matcher m=p.matcher(input);
		if(m.find()){
			return true;
		}
		return false;
	}

}
