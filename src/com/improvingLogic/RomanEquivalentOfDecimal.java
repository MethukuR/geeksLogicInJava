package com.improvingLogic;

import java.util.Scanner;

/**
 * Java Program To Find Roman Equivalent Of A Decimal Number
 * 
 * What Are Roman Numerals?

Roman numerals are the number system used in ancient Rome. This whole number system is 
based on 7 symbols. They are,

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Symbols I, X, C and M can be repeated maximum 3 times, not more than that. And symbols 
D, L and V can not be repeated. For example, 150 is written as CL (Not LLL since L can not 
be repeated) and 444 is written as CDXLIV (Not CCCCXXXXIIII since C, X and I can not be 
repeated more than 3 times). Below are some more roman equivalents of some decimal numbers.

How It Works?

Let inputNumber = 1546

1st Iteration : for i = 0

Inside the while loop,

As 1546 > 1000(decimals[0])

inputNumber = inputNumber – decimals[0] = 1546 – 1000 = 546
roman = roman + romanSymbols[0] = “”+”M” = “M”

As 546 < 1000(decimals[0])

break while loop

2nd Iteration : for i = 1

Inside the while loop,

As 546 < 900(decimals[1])

break while loop

3rd Iteration : for i = 2

Inside the while loop,

As 546 > 500(decimals[2])

inputNumber = inputNumber – decimals[2] = 546 – 500 = 46
roman = roman + romanSymbols[2] = “M” + “D” = “MD”

As 46 < 500(decimals[2])

break while loop

4th Iteration : for i = 3

Inside the while loop,

As 46 < 400(decimals[3])

break while loop

5th Iteration : for i = 4

Inside the while loop,

As 46 < 100(decimals[4])

break while loop

6th Iteration : for i = 5

Inside the while loop,

As 46 < 90(decimals[5])

break while loop

7th Iteration : for i = 6

Inside the while loop,

As 46 < 50(decimals[6])

break while loop

8th Iteration : for i = 7

Inside the while loop,

As 46 > 40(decimals[7])

inputNumber = inputNumber – decimals[7] = 46 – 40 = 6
roman = roman + romanSymbols[7] = “MD” + “XL” = “MDXL”

As 6 < 40(decimals[7])

break while loop

9th Iteration : for i = 8

Inside the while loop,

As 6 < 10(decimals[8])

break while loop

10th Iteration : for i = 9

Inside the while loop,

As 6 < 9(decimals[9])

break while loop

11th Iteration : for i = 10

Inside the while loop,

As 6 > 5(decimals[10])

inputNumber = inputNumber – decimals[10] = 6 – 5 = 1
roman = roman + romanSymbols[10] = “MDXL” + “V” = “MDXLV”

As 1 < 5(decimals[10])

break while loop

12th Iteration : for i = 11

Inside the while loop,

As 1 < 4(decimals[11])

break while loop

13th Iteration : for i = 12

Inside the while loop,

As 1 = 1(decimals[12])

inputNumber = inputNumber – decimals[12] = 1 – 1 = 0
roman = roman + romanSymbols[12] = “MDXLV” + “I” = “MDXLVI”

As 0 < 1(decimals[12])

break while loop

No more iterations. Break the for loop.

So, roman equivalent of 1546 is MDXLVI


 * @author Raju Rockzz :P
 *
 */
public class RomanEquivalentOfDecimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter The Decimal Number Between 1 and 3999");		
		int decimalValue=scn.nextInt();
		
		String romanEquivalent= calculateRomanEquivalent(decimalValue);
		if(!romanEquivalent.isEmpty()){
			System.out.println("Roman equivalent of "+decimalValue+" is "+romanEquivalent);
		}
		else{
			System.out.println("Invalid number");
		}
		
		scn.close();
	}
	
	static String calculateRomanEquivalent(int decimalValue){
		String romanEquivalent="";
		
		 //String array containing 13 roman symbols
        
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
         
        //int array containing 13 decimal numbers
        int[] decimals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        if(decimalValue >= 1 && decimalValue <= 3999){
        	for (int i = 0; i < 13; ++i) {
				while(decimalValue >= decimals[i]){
					romanEquivalent+=romanSymbols[i];
					decimalValue-=decimals[i];
				}
			}
        }
        return romanEquivalent;
	}

}
