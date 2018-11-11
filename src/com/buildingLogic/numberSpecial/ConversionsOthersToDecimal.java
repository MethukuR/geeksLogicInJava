package com.buildingLogic.numberSpecial;
import java.util.Scanner;

/**
 * Convert from Binary, Octal or Hex to Decimal using Integer.parseInt(String input, int radix)

 * Use Integer.parseInt(String input, int radix) to convert from any type of number to an Integer.
 * 
 * @author Raju Rockzzz :P
 *
 */
public class ConversionsOthersToDecimal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		 
		System.out.println("Enter value : ");
		String radixValue=scn.next();
		
		System.out.println("Enter radix : ");
		int radix =scn.nextInt();
		scn.close();
		int decimalValue=-1;
		
		decimalValue=convertRadixValueToDecimalOne(radixValue,radix);
		System.out.println("Decimal value of "+radixValue + " in Base "+radix+" : " +decimalValue );
		
		decimalValue=convertRadixValueToDecimalTwo(radixValue,radix);
		System.out.println("Decimal value of "+radixValue + " in Base "+radix+" : " +decimalValue );
		
	}
	
	static int convertRadixValueToDecimalOne(String radixValue, int radix){
		int decimalValue=0;
		int radixValueLength=radixValue.length();
		
		for (int i = radixValueLength-1; i >= 0; --i) {
			int charValue=(int)radixValue.charAt(i)-48;
			if(charValue >= 17 && charValue <= 21){
				charValue-=7;
			}
			else if(charValue >=49 && charValue <= 53){
				charValue-=39;
			}
			decimalValue+=charValue*(Math.pow(radix, radixValueLength-i-1));
		}
		return decimalValue;
	}
	
	static int convertRadixValueToDecimalTwo(String radixValue, int radix){
		int decimalValue=Integer.parseInt(radixValue,radix);
		return decimalValue;
	}
}
