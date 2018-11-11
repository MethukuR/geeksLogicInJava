package com.buildingLogic.stringSpecial;
/**
 * To Check given string is valid IP Address or not.
 * 
 * @author Ranger Raju :)
 *
 */
public class ValidIPAddress {

	public static void main(String[] args) {
		String ipAddress="255.255.255.255";
		if(isValidIP(ipAddress)){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

	private static boolean isValidIP(String ipAddress) {
		String[] parts=ipAddress.split("\\.");
		int noOfParts=parts.length;
		if(noOfParts == 4){
			for (int i = 0; i < noOfParts; ++i) {
				if(!isInGivenRange(parts[i])){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private static boolean isInGivenRange(String string) {
		int part=Integer.parseInt(string);
		if(part >= 0 && part <= 255){
			return true;
		}
		return false;
	}

}
