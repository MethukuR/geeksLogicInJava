package com.improvingLogic;

import java.util.Scanner;

public class LongestWord {

	public static void main(String[] args) {
		 Scanner scn =  new Scanner(System.in);
		 
		 System.out.println("Enter the String: ");
		 String s = scn.next();
	
		 findLongestWordRaju("Hello I'm your Stringggg");
	}
	static void findLongestWord(String s){
		 
		int sLength = s.length();
		//String[] words = StringUtils.split("Hello I'm your String");;
		String sw = " ", lw = " ";
		int l=0;
		String str = " Hello I'm your String";
		String[] words = str.split("\\s+");
		System.out.println(words.length);
		for(int i =0; i< words.length; i++){
			System.out.println(words[i]);
		/*for(String word : words){
			
			if(word.length()<sLength){
				sw = word;
			}
			else if(word.length()>l){
				lw = word;
			}*/
			
		}
		//System.out.println("Short"+sw);
		//System.out.println("Long"+lw);
		
		
	}
	
	static void findLongestWordRaju(String s){
		int sLength=s.length();
		StringBuffer  outputStr= new StringBuffer();
		StringBuffer tempStr= new StringBuffer();
		int tempMax=0;
		int max=0;
		
		
		for (int i = 0; i < sLength; ++i) {
			int charValue=s.charAt(i);
			
			if((charValue >= 65 && charValue <= 90) || (charValue >= 97 && charValue <= 122)){
				tempStr.append((char)charValue);
				tempMax++;
			}
			else{
				tempMax=0;
				tempStr=new StringBuffer();
			}
			
			if(tempMax > max){
				max=tempMax;
				outputStr=tempStr;
			}
		}
		System.out.println("out :"+outputStr);
	}
}
