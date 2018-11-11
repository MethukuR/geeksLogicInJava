package com.buildingLogic.arraySpecial;
public class MissingNumberInGP {
	public static void main(String[] args) {
		 int[] inputArr={3, 9, 27, 243};
		 
		 int actualNumberOfElements=inputArr.length;
		 int expectedNoOfElements=actualNumberOfElements+1;
		 
		 int actualProduct=calculateActualProduct(inputArr, actualNumberOfElements);
		 
		 int expectedProduct=calculateExpectedProduct(inputArr, expectedNoOfElements);
		 
		 int missingNumber=expectedProduct/actualProduct;
		 
		 System.out.println("Missing Number :"+missingNumber);
		
	}
	
	static int calculateActualProduct(int[] inputArr, int actualNumberOfElements){
		int actualProduct=1;
		for (int index = 0; index < actualNumberOfElements; index++) {
			actualProduct *= inputArr[index];
		}
		return actualProduct;
	}
	
	static int calculateExpectedProduct(int[] inputArr, int expectedNoOfElements){
		int ratioOne=inputArr[1]/inputArr[0];
		int ratioTwo=inputArr[expectedNoOfElements-2]/inputArr[expectedNoOfElements-3];
		int ratioThree=inputArr[expectedNoOfElements/2]/inputArr[(expectedNoOfElements/2)-1];
		int ratio=0;
		if(ratioOne == ratioTwo){
			ratio=ratioTwo;
		}
		else if(ratioOne == ratioThree){
			ratio=ratioOne;
		}
		else if(ratioTwo == ratioThree){
			ratio=ratioThree;
		}
		else{
			return -1;
		}
		int expectedProduct=1;
		
		for (int i = 1; i <= expectedNoOfElements ; ++i) {
			expectedProduct*=((inputArr[0])*Math.pow(ratio, i-1));
		}
		System.out.println(expectedProduct);
		return expectedProduct;
		
	}
}