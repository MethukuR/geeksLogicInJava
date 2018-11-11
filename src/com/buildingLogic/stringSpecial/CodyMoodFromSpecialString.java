package com.buildingLogic.stringSpecial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Problem: Cody is a serious coder, he works as problem setter at Dcoder.He usually stays ^_^ but when 
 *  his codes doesn't work he becomes -_- .You are given a string which consist of Cody's mood emojis, 
 *  what you have to do is tell us whether cody is happy with coding on an average or sad?
	Input: Input contains a string which has ^_^ and -_-
	Output: Print "Cody is happy with Dcoder" if occurrence of ^_^ is more than that of -_- else "Cody 
	wants to leave job" without quotes.In case of draw output "Cody doesn't know what to do"
	Constraints: 1 ≤ length of string ≤ 100
	Sample Input: ^_^_^-_-
	Sample Output: 
	Cody is happy with Dcoder
	
 * @author Dangal Raju Rockzz :P
 *
 */
public class CodyMoodFromSpecialString {

	public static void main(String[] args) {
		String inputString="^_^_^_^_^-_-_-_-";
		
		String codyMood= findCodyMoodOne(inputString);
		
		System.out.println(codyMood);
		
        //codyMood= findCodyMoodTwo(inputString);
		
		//System.out.println(codyMood);
	}
	
	// NOT WORKING
	/*private static String findCodyMoodTwo(String inputString) {
        String codyMood;
		
		String goodMoodString="^_^";
		int goodMoodCount=0;
		
		
		String badMoodString="-_-";
		int badMoodCount=0;
		
		Pattern goodMoodPattern= Pattern.compile(goodMoodString);
		Matcher goodMoodMatcher=goodMoodPattern.matcher(inputString);
		
		while(goodMoodMatcher.find()){
			++goodMoodCount;
		}
		
		Pattern badMoodPattern= Pattern.compile(badMoodString);
		Matcher badMoodMatcher=badMoodPattern.matcher(inputString);
		
		while(badMoodMatcher.find()){
			++badMoodCount;
		}
		
		System.out.println("goodMoodCount : "+goodMoodCount);
		System.out.println("badMoodCount : "+goodMoodCount);
		if(goodMoodCount > badMoodCount){
			codyMood="Cody is happy with Dcoder";
		}
		else{
			codyMood= "Cody wants to leave job";
		}
		return codyMood;
	}*/

	private static String findCodyMoodOne(String inputString) {
		String codyMood;
		
		String goodMoodString="^_^";
		int goodMoodCount=0;
		
		
		String badMoodString="-_-";
		int badMoodCount=0;
		
		int index=0;
		
		while(index != -1){
			index=inputString.indexOf(goodMoodString,index);
			if(index != -1){
				++goodMoodCount;
				index=index+2;
			}
		}
		
		index=0;
		
		while(index != -1){
			index=inputString.indexOf(badMoodString,index);
			if(index != -1){
				++badMoodCount;
				index=index+2;
			}
		}
		
		if(goodMoodCount > badMoodCount){
			codyMood="Cody is happy with Dcoder";
		}
		else{
			codyMood= "Cody wants to leave job";
		}
		
		return codyMood;
	}

}
