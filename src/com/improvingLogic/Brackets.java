package com.improvingLogic;

public class Brackets {
	
	public int solutionTwo(String str){
		int k=-1;
		int strLength=str.length();
		int i=0;
		int j=strLength-1;
		int openCount=0;
		int closedCount=0;
		boolean checkOpened=true;
		boolean checkClosed=true;
		boolean alreadyEqual=false;
		
		for (int index = 0; index < strLength; index++) {
			if(str.charAt(i) == '(' && checkOpened){
				++openCount;
			}
			if(str.charAt(j) == ')' && checkClosed){
				++closedCount;
			}
			
			if(i >= j ){
				if(alreadyEqual){
					k=j+1;
					break;
				}
			}
			else if(openCount > closedCount){
				--j;
				checkOpened=false;
				checkClosed=true;
			}
			else if( openCount < closedCount){
				++i;
				checkOpened=true;
				checkClosed=false;
			}
			else if(openCount == closedCount){
				++i;
				--j;
				alreadyEqual=true;
				checkOpened=true;
				checkClosed=true;
			}
		}
		return k;
	}
	public int solution(String S) {
		int k=-1;
		char[] charArr=S.toCharArray();
		int charArrLength=charArr.length;
		for (int i = 0; i < charArrLength; ++i) {
			int countOpen=countOpenBraces(0,i,charArr);
			int countClosed=countClosedBraces(i+1,charArrLength-1,charArr);
			if(countOpen == countClosed ){
				k=i+1;
			}
		}
		return k;
    }
	
	static int countOpenBraces(int start,int end,char[] charArr){
		int count=0;
		for (int i = start; i <= end; ++i) {
			if(charArr[i] == '('){
				++count;
			}
		}
		return count;
	}
	
	static int countClosedBraces(int start,int end,char[] charArr){
		int count=0;
		for (int i = start; i <= end; ++i) {
			if(charArr[i] == ')'){
				++count;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Brackets b= new Brackets();
		String S="((";
		System.out.println(b.solutionTwo(S));
	}

}
