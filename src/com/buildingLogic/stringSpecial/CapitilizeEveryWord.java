package com.buildingLogic.stringSpecial;

/**
 *  Problem: Alpha has taken a new liking to social media. Alpha is now very fond of writing quotes on 
 *  social media. 
	However there is a uniqueness to Alpha's quotes, he takes a quote and converts the first alphabet of
	each word to uppercase. 
	For example if he chooses to upload the quote 'Happy coding with dcoder' it would appear as 
	'Happy Coding With Dcoder'.
	Input: Input contains the quote (string) written in a general manner.
	Output: Output contains the quote (string) with first alphabet of each word capitalized.
	
	Constraints: 
	
	Sample Input: A great artist is a great man in a great child.
	
	Sample Output: 
	A Great Artist Is A Great Man In A Great Child.
 * 
 * @author Raju Rockzz :P
 *
 */
public class CapitilizeEveryWord {/*

	public static void main(String[] args) {
		String inputSentence="A great, artist is a great man in a great child";
		String outputSentence=capitalizeEachWordOfSentence(inputSentence);
		System.out.println(outputSentence);
		
	}

	private static String capitalizeEachWordOfSentence(String inputSentence) {
		String outputSentence="";
		String[] words=inputSentence.split(" ");
		int wordsLength=words.length;
		for(int i=0;i < wordsLength ;++i){
			char firstChar=words[i].charAt(0);
			if(isSmall(firstChar)){
				char replacedChar=(char)(firstChar-32);
				words[i]=words[i].replace(firstChar, replacedChar);
			}
		}
		
		for (int i = 0; i < wordsLength ; ++i) {
			outputSentence+=" "+words[i];
		}
		return outputSentence;
	}

	private static boolean isSmall(char c) {
		// TODO Auto-generated method stub
		if(c >= 95 || c <= 122){
			return true;
		}
		
		return false;
	}

	

*/

	public static void main(String[] args) {
	       String s = "A great artist is a great man in a great child.";
	       makeAllFirstCaps(s);
		}
		static void makeAllFirstCaps(String s){
			int len = s.length();
			char[] ch = s.toCharArray();
			
			for(int i =0; i<len; i++){
				if(ch[i]==' '){
					int intChr=ch[i+1];
				    ch[i+1]=(char) (intChr-32);
				}
			}
			for(int i=0; i<ch.length;i++){
				System.out.print(ch[i]);
			}
			
		}

}
