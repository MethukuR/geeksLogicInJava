package com.buildingLogic.stringSpecial;
/*

public class StringVowel {

	public static void main(String[] args) {
		String s="abcd";
		int result=score(s);
		System.out.println(result);
	}
		
	 static int score(String s)
	 {   int score=0;
		 int sLength=s.length();
		 char[] tempArr=new char[sLength];
		 int tempIndex=0;
		 for(int index=0; index<sLength; ++index){
			 
			 
				if(!alreadyExists(tempArr, tempIndex, s.charAt(index))){
					if(s.charAt(index)=='a'|| s.charAt(index)=='e'||s.charAt(index)=='i'|| s.charAt(index)=='o'||s.charAt(index)=='u'){
						 score+=1;
						 ++tempIndex;
					}
					else{
						 score+=2;
					 }
				}
				
			 
			 
		 }
		 return score;
	 }
	 static boolean alreadyExists(int tempValue, int[] tempArr,int tempIndex){
			boolean status = false;
			int tempArrLength=tempArr.length;
			for (int i = 0; i < tempArrLength && (i!=tempIndex); ++i) {
				if(tempArr[i] == tempValue){
					status=true;
					break;
				}
			}
			return status;
		}

	}

*/