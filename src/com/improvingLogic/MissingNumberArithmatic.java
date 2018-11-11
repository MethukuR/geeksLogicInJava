package com.improvingLogic;

public class MissingNumberArithmatic {

	public static void main(String[] args) {
		//int[] sequence={2, 6, 8, 10, 12, 14,16};
		//int[] sequence={2, 4, 8, 10, 12, 14,16};
		int[] sequence={2,4, 6, 8, 10,12,14,16,18};
		int seqLength=sequence.length;
		int calSum=0;
		for(int index:sequence){
			calSum=calSum+index;
		}
		
		int actualSum=(seqLength/2)*(2*sequence[0]+((seqLength-1)*(sequence[1]-sequence[0])));
		System.out.println("actualSum:"+actualSum);
		System.out.println("calSum:"+calSum);
		if(calSum==actualSum){
			System.out.println("Given sequence ha no number missing");
		}
		else{
			int missingNumber=calculateMissingNumber(sequence,seqLength);
			System.out.println("Missing Number :"+missingNumber);
		}
			
	}

	
	static int calculateMissingNumber(int[] sequence,int length){
		
		int first=0;
		int last=length-1;		
		int middle=first+(last-first)/2;
		int difference=0;
		int diff1=sequence[1]-sequence[0];
		int diff2=sequence[length-1]-sequence[length-2];
		int diff3=sequence[middle]-sequence[middle-1];
		if(diff1==diff2){
			difference=diff1;
		}
		else if(diff2==diff3){
				difference=diff2;
		}
		else if(diff1 == diff3){
			difference=diff1;
		}
		
		int calMidNumber=sequence[first]+(middle)*difference;
		int actualMidNumber=sequence[middle];
		int missingNumber=0;
		while(first<last){	
				if(sequence[middle+1]-sequence[middle]!=difference){
				missingNumber=sequence[middle]+difference;
				break;
			}
			else if(sequence[middle]-sequence[middle-1]!=difference){
				missingNumber=sequence[middle]-difference;
				break;
			}
			else if(calMidNumber==actualMidNumber){
				first=middle+1;
				last=length;
				middle=(last+first)/2;
				actualMidNumber=sequence[middle];
				calMidNumber=sequence[first]+(middle)*difference;
			}
			else{
				first=0;
				last=middle-1;
				middle=(last+first)/2;
				actualMidNumber=sequence[middle];
				calMidNumber=sequence[first]+(middle)*difference;
			}
		}
		System.out.println("missing Number:"+missingNumber);
		
		return missingNumber;
		
	}

}
