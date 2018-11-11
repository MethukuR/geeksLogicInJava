package com.buildingLogic.stringSpecial;
/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He 
 * found a magazine and wants to know if he can cut out whole words from it and use 
 * them to create an untraceable replica of his ransom note. The words in his note are 
 * case-sensitive and he must use whole words available in the magazine, meaning he 
 * cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can 
replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format

The first line contains two space-separated integers describing the respective values 
of  (the number of words in the magazine) and  (the number of words in the ransom note). 
The second line contains  space-separated strings denoting the words present in the 
magazine. 
The third line contains  space-separated strings denoting the words present in the 
ransom note.

Each word consists of English alphabetic letters (i.e.,  to  and  to ).
The words in the note and magazine are case-sensitive.
Output Format

Print Yes if he can use the magazine to create an untraceable replica of his ransom 
note; otherwise, print No.

Sample Input

6 4
give me one grand today night
give one grand today
Sample Output

Yes
Explanation

All four words needed to write an untraceable replica of the ransom note are present 
in the magazine, so we print Yes as our answer.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
	Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) {
        
    	
        String[] x=magazine.split(" ");
        int len=x.length;
        this.magazineMap=new HashMap<String, Integer>(len);
        
        for(int i=0 ; i < len ; ++i){
            if(this.magazineMap.containsKey(x[i])){
                this.magazineMap.put(x[i],this.magazineMap.get(x[i])+1);
            }else{
                this.magazineMap.put(x[i],1);
            }
        }
        
         
        x=note.split(" ");
        len=x.length;
        this.noteMap=new HashMap<String, Integer>(len);
        for(int i=0 ; i < len ; ++i){
            if(this.noteMap.containsKey(x[i])){
                this.noteMap.put(x[i],this.noteMap.get(x[i])+1);
            }else{
                this.noteMap.put(x[i],1);
            }
        }
    }
    
    public boolean solve() {
        for(String key:this.noteMap.keySet()){
            if(!this.magazineMap.containsKey(key) || this.magazineMap.get(key) < this.noteMap.get(key)){
                return false;
            }
           
        }
         return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        boolean answer=false;
        if( m < n){
        	answer=false;
        }else{
        	answer = s.solve();
        }
        
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
