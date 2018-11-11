package com.buildingLogic.stringSpecial;
/**
 * Input : "position 1 @ durga is This"
 * output: "This is durga @ 1 position"
 * @author Raju Rockzz :P
 *
 */
public class ReverseSentence {
	
	static StringBuffer inputSentence = new StringBuffer("position            1 @       durga is This   ");
	
	public static void main(String[] args) {
		int index=0;
		int startIndex=0;
		int lastIndex=0;
		int inpSentenceLength=inputSentence.length();
		
		while(index < inpSentenceLength ){
			//index==inpSentenceLength-1 takes care when we reach end of sentence
			if(inputSentence.charAt(index) == ' ' || index==inpSentenceLength-1){
				lastIndex=index;
				if(index != inpSentenceLength-1){
					--lastIndex;
				}
				swap(startIndex,lastIndex);//swapping each word in the sentence 
				startIndex=index+1;
			}
			
			++index;
		}
		
		swap(0,inpSentenceLength-1);//swapping whole sentence
		System.out.println("inputSentence::"+inputSentence);

	}
	
	static void swap(int startIndex, int lastIndex){
		while(startIndex<lastIndex){
			char temp= inputSentence.charAt(startIndex);
			inputSentence.setCharAt(startIndex, inputSentence.charAt(lastIndex));
			inputSentence.setCharAt(lastIndex, temp);
			++startIndex;
			--lastIndex;
		}
	}

}
