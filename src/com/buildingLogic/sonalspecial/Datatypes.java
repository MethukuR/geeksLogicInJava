package com.buildingLogic.sonalspecial;

public class Datatypes {

	public static void main(String[] args) {
		char c = 'c';
		char ch = 99;//0 to 65,536 (unsigned) //default value = '\u0000' // size= 2 bytes = 16 bits
		System.out.println(c);
		System.out.println(ch);
		
		byte b = 24; // -128 to 127 === 2^8 //default value = 0 // size = 1byte = 8 bits
		short s = 256; // -32,768 to 32,767 === 2^16 //default value = 0 // size = 2bytes = 16 bits
		int  i = 2566; //-2,147,483,648 to 2,147,483,647 === 2^32 //default value = 0 // size = 4 bytes = 32 bits
		long l = 234567; //  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,80 === 2^64 // default value = 0 // 8 bytes = 64 bits
		
		float f = 25.6434567f; //4 bytes 7 decimal digits //default value = 0.0f // size = 4 bytes = 32bits
		double d = 345.4563456767787897; //8 bytes 16 decimal digits //default value = 0.0d
		
		boolean bo = false; //default value = false
		
		String str = "ab";
	}

}
