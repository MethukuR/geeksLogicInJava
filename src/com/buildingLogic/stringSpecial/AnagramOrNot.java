package com.buildingLogic.stringSpecial;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two strings are called anagrams if they contain same set of characters but in different order. For 
 * example, �Dormitory � Dirty Room�, �keep � peek�,  �School Master � The Classroom� are some anagrams.
	
   Anagram Program In Java Using HashMap:
   --------------------------------------

   In this method, we construct one HashMap object with character as Key and character occurrences as 
   Value. We increment character count by 1 if the character is present in first string and decrement it 
   by 1 if that character is present in second string. At last, we check character count for each character 
   in the map. If any count is not equal to 0, then given strings are not anagrams.
 
 * @author Raju :)
 *
 */
public class AnagramOrNot {

	public static void main(String[] args) {
		String sOne="keep";
		String sTwo="PeeK";
		boolean status;
	    status=isAnagramHashMap(sOne,sTwo);
	    status=isAnagramSort(sOne,sTwo);
		
		if(status){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}

	private static boolean isAnagramSort(String sOne, String sTwo) {
		//Removing all white spaces from s1 and s2
		 
        String copyOfs1 = sOne.replaceAll("\\s", "");
 
        String copyOfs2 = sTwo.replaceAll("\\s", "");
 
        //Initially setting status as true
 
        boolean status;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status=false;
        }
        else{
            //Changing the case of characters of both copyOfs1 and copyOfs2 and 
        	//converting them to char array
 
            char[] s1Array = copyOfs1.toLowerCase().toCharArray();
 
            char[] s2Array = copyOfs2.toLowerCase().toCharArray();
 
            //Sorting both s1Array and s2Array
 
            Arrays.sort(s1Array);
 
            Arrays.sort(s2Array);
 
            //Checking whether s1Array and s2Array are equal
 
            status = Arrays.equals(s1Array, s2Array);
            
        }
		return status;
	}

	private static boolean isAnagramHashMap(String sOne, String sTwo) {
		String copyOfs1 = sOne.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = sTwo.replaceAll("\\s", "").toLowerCase();
        
        int sOneLength=copyOfs1.length();
        int sTwoLength=copyOfs2.length();
        
        if(sOneLength != sTwoLength){
        	return false;
        }
        
        HashMap<Character,Integer> hm= new HashMap<Character,Integer>(sOneLength+sTwoLength);
        boolean isAnagram = true;
        for (int i = 0; i < sOneLength; ++i) {
			char cur=copyOfs1.charAt(i);
			
			if(hm.containsKey(cur)){
				hm.put(cur, hm.get(cur)+1);
			}
			else{
				hm.put(cur,1);
			}
		}
        
        for (int i = 0; i < sTwoLength; ++i) {
			char cur=copyOfs2.charAt(i);
			
			if(hm.containsKey(cur)){
				hm.put(cur, hm.get(cur)-1);
			}
			else{
				isAnagram = false;
				break;
			}
		}
        
        for (int value : hm.values()){
            if(value != 0){
                //If character count is not equal to 0, then setting status as false
				isAnagram = false;
                break;
            }
        }
        return isAnagram;
	}

}
