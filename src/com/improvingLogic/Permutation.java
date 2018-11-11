package com.improvingLogic;

import java.util.HashSet;

class Permutation {
    
    
    static HashSet<String> h= new HashSet<String>();
    public static void main (String args[]){
    	long N=1213;
       
        System.out.println(findCount(N));
    }
    
    static int findCount( long N)
    {	String inputString=String.valueOf(N);
        int inputStrLength = inputString.length();
        boolean[ ] alreadyUsed = new boolean[ inputStrLength ];
        StringBuffer permutation = new StringBuffer();
        char[ ] inputChar = inputString.toCharArray( );
        findPermutations ( permutation, inputChar, alreadyUsed, inputStrLength, 0 );
        return h.size();
        
    }
    
    public static  void findPermutations (StringBuffer permutation,char[ ] inputChar,  boolean[ ] alreadyUsed, int inputStrLength, int position){
        if( position == inputStrLength) {
        	h.add(permutation.toString());
            return;
        }
        
        for( int i = 0; i < inputStrLength; ++i ){
            if( alreadyUsed[i] ){
            	continue;
            } 
            permutation.append( inputChar[i] );
            alreadyUsed[i] = true;
            findPermutations( permutation,inputChar, alreadyUsed, inputStrLength, position + 1 );
            permutation.setLength(permutation.length() - 1);
            alreadyUsed[i] = false;
        }
    }
    
}