package com.buildingLogic.arraySpecial;


import java.util.Arrays;

public class Reputation {

	public static void main(String[] args) {
		int[] boys={1,1};
		int[] girls={-1,-1};
		int m=2;
		int result=maxReputations(boys,girls, m);

		System.out.println(result);

	}
	static int maxReputations(int[] s_boys, int[] s_girls, int m){
		int maxReputation=calculationReputation(s_boys, s_girls);
		int length=s_boys.length;
		int[] tempArr;
		int tempReputation=0;
		tempArr=Arrays.copyOf(s_boys,length);
		for(int index=0; index<length; ++index){
			for (int i = 1; i <= m; i++) {
				tempArr[index]+=m;
				tempReputation=calculationReputation(tempArr, s_girls);
				if(tempReputation > maxReputation ){
					maxReputation=tempReputation;
				}
				tempArr=Arrays.copyOf(s_boys,length);
			}
			    
		}
		
		tempArr=Arrays.copyOf(s_girls,length);

		for(int index=0; index < length; ++index){
			for (int i = 1; i <=m; i++) {
				tempArr[index]+=m;
				tempReputation=calculationReputation(s_boys, tempArr);
				if(tempReputation > maxReputation ){
					maxReputation=tempReputation;
				}
				tempArr=Arrays.copyOf(s_girls,length);
			}
			    		}
		return maxReputation;
	}
	 static int calculationReputation(int[] sBoys, int[] sGirls){
		 int reputation=0;
			int length=sBoys.length;
			for(int i=0; i< length; ++i){
				for(int j=0; (j < length) ; ++j){
					if((i==j)){
					 reputation=reputation+(sBoys[i]*sGirls[i]);
					}
				}
			}
			return reputation;
		 
	 }

}
