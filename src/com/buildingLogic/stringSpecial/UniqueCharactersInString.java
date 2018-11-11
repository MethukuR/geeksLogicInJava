package com.buildingLogic.stringSpecial;

public class UniqueCharactersInString {
	
	public static String inputStr="durgadurgadurgadurga";
	public static StringBuffer finalStr= new StringBuffer();
	
	public static void main(String[] args) {
		
		int inputStrLen=inputStr.length();
		int index=0;
		int repeatedCharCount=0;
		while(index < inputStrLen){
			char inputCh=inputStr.charAt(index);
			boolean isInputCharRepeated=formFinalStr(inputCh);
			if(isInputCharRepeated){
				++repeatedCharCount;
			}//if(isInputCharRepeated)
			if(repeatedCharCount==4){
				System.out.println("Fourth repeated Character is "+inputCh +"\t at index \t"+index);
			}//if(repeatedCharCount==4)
			++index;
		}//while(index < inputStrLen)
		System.out.println("Final Unique String :"+finalStr);
	}//main()
	
	static boolean formFinalStr(char ch){
		int finalStrIndex=0;
		int finalStrLen=finalStr.length();
		boolean exists=false;
		if(null != finalStr){
			while(finalStrIndex < finalStrLen){
				char finalStrChar=finalStr.charAt(finalStrIndex);
				if(finalStrChar == ch){
					exists=true;
					break;
				}//if(finalStrChar == ch)
				
				++finalStrIndex;
			}//while(finalStrIndex < finalStrLen)
		}//if(null != finalStr)
		if(!exists){
			//String temp= new String(new char[]{ch});
			finalStr.append(ch);
			return true;
		}//if(!exists)
		else{
			return false;
		}//else(!exists)
		
		
	}//formFinalStr(char ch)

}//UniquesCharectersInString
