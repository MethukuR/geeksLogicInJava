package com.buildingLogic.numberSpecial;
/*
 * Convert from any base to decimal and vice versa
Given a number and its base, convert it to decimal. The base of number can be anything such 
that all digits can be represented using 0 to 9 and A to Z. Value of A is 10, value of B is 
11 and so on. Write a function to convert the number to decimal.

Input number is given as string and output is an integer.

Input: str = "1100", base = 2 
Output: 12

Input: str = "11A", base = 16
Output: 282

Input: str = "123",  base = 8
Output: 83 

We can always use below formula to convert from any base to decimal.

"str" is input number as string 
"base" is base of input number.

Decimal Equivalent is,
  1*str[len-1] + base*str[len-2] + (base)2*str[len-2] + ...
  
  How to do reverse?
Let the given input decimal number be “inputNum” and target base be “base”. We repeatedly 
divide inputNum by base and store the remainder. We finally reverse the obtained string. 
 */
public class BaseDecimalConversion {

	public static void main(String[] args) {
		//String inputNumber="123";
		int inputNumber=282;
		//char[] inputChar=inputNumber.toCharArray();
		int base=16;
		//toDecimal(inputChar,base);
		fromDeci(inputNumber,base);
	}
	static int val(char c){
		if(c >= '0' && c <= '9'){
			return (int)c - '0';
		}
		else{
			return (int)c - 'A'+10;
		}
	}
	static void toDecimal(char[] inputChar, int base){
		int inputCharLength=inputChar.length;
		int decimalNumber=0;
		int power=1;
		for(int index=inputCharLength-1;index>=0;--index){
			if(val(inputChar[index])>base){
				System.out.println("Input Number is not valid");
				return;
			}
			else{
				decimalNumber+=power*val(inputChar[index]);
				power*=base;
			}
		}
		System.out.println("Decimal value is "+decimalNumber);
	}
	
	static char reVal(int i){
		if(i > 0 && i < 9){
			return (char)(i+'0');
		}
		else{
			return (char)(i-10+'A');
		}
	} 
	
	static char[] strRev(char[] inputArray, int resLength){
		for(int index=0;index<(resLength/2);++index){
			char temp=inputArray[index];
			inputArray[index]=inputArray[resLength-index-1];
			inputArray[resLength-index-1]=temp;
		}
		return inputArray;
	}
	static void fromDeci(int inputNumber, int base){
		
		char[] result= new char[100];
		int index=0;
		while(inputNumber>0){
			result[index++]=reVal(inputNumber%base);
			inputNumber/=base;
		}
		String interResult=String.valueOf(result);
		int strLenIndex=0;
		int resLength=interResult.length();
		for(strLenIndex=0;strLenIndex<resLength;++strLenIndex){
			if(result[strLenIndex]== 0){
				break;
			}
		}
		System.out.println(strLenIndex);
		char[] finalRes=strRev(result,strLenIndex);
		String finalResult=String.valueOf(finalRes);
		System.out.println("Final Result "+finalResult);
	}
}
