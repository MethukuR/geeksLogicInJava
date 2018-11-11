package com.improvingLogic;

import java.util.Scanner;

/**
 * Convert from Decimal to Binary, Octal or Hex using Integer.toString(int input, int radix)
 * Use Integer.toString(int input, int radix) to convert from an Integer to any type of base number.
 * 
 * @author Raju Rockzz :P
 *
 */
public class ConverstionsDecimalToOther {
 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
 
		System.out.println("Enter Decimal Value : ");
		int decimalValue=scn.nextInt();
 
		System.out.println("Enter radix : ");
		int radix =scn.nextInt();
 
		scn.close();
		String radixValue="";
 
		radixValue=convertDecimalToGivenRadixOne(decimalValue,radix);
		System.out.println(decimalValue + " in Base "+radix+" : " +radixValue ); 
 
		radixValue=convertDecimalToGivenRadixTwo(decimalValue,radix);
		System.out.println(decimalValue + " in Base "+radix+" : " +radixValue );
 
		radixValue=convertDecimalToGivenRadixThree(decimalValue,radix);
		System.out.println(decimalValue + " in Base "+radix+" : " +radixValue );
 
 
	}
 
	static String convertDecimalToGivenRadixOne(int decimalValue, int radix){
		String radixValue=" ";
		int remainder;
		while(decimalValue != 0){
			remainder=decimalValue % radix;
			if(remainder >= 10){
				remainder+=87;
				radixValue=(char)remainder+radixValue;
			} 
			else{
				radixValue=remainder+radixValue;
			}
			decimalValue/=radix;
		}
		return radixValue;
	}
 
	static String convertDecimalToGivenRadixTwo(int decimalValue, int radix){
		String radixValue=Integer.toString(decimalValue, radix);
		return radixValue;
	}
 
	static String convertDecimalToGivenRadixThree(int decimalValue, int radix){
		String radixValue="";
 
		if(radix == 2){
			radixValue=Integer.toBinaryString(decimalValue);
		}
		else if(radix == 8){
			radixValue=Integer.toOctalString(decimalValue);
		}
		else if(radix == 16){
			radixValue=Integer.toHexString(decimalValue);
		}
		return radixValue;
	}
 
}
 

