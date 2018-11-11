package com.improvingLogic;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TenDigitPermutations {

	public static void main(String[] args) {
		Set<String> perm=permutationFinder("0123456789");
		//System.out.println(perm);
		Set<Long> sortedSet=sortPermutations(perm);
		System.out.println(sortedSet);
		//Long[] arr = sortedSet.toArray(new Long[sortedSet.size()]);
	}

	private static Set<Long> sortPermutations(Set<String> perm) {
		Set<Long> sortedSet= new TreeSet<>();
		for (String string : perm) {
			sortedSet.add(Long.parseLong(string));
		}
		return sortedSet;
	}

	private static Set<String> permutationFinder(String string) {
		Set<String> perm = new HashSet<>();
		
		if(null == string){
			return null;
		}else if(string.length() == 0){
			perm.add("");
			return perm;
		}
		
		char firstChar=string.charAt(0);
		String rem=string.substring(1);
		
		Set<String> words=permutationFinder(rem);
		
		for (String word : words) {
			for (int i = 0; i <= word.length(); ++i) {
				perm.add(formWord(firstChar,word,i));
			}
		}
		return perm;
	}

	private static String formWord(char firstChar, String word, int i) {
		String begin = word.substring(0,i);
		String end = word.substring(i);
		return begin+firstChar+end;
	}
}
