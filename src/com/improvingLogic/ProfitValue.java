package com.improvingLogic;

import java.util.Scanner;
import java.util.TreeMap;

public class ProfitValue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int output = 0;
        //int ip1_size = 0;
        //ip1_size = Integer.parseInt(in.nextLine().trim());
        //String[] ip1 = new String[ip1_size];
        String[] ip1 = {"6AM#8AM","11AM#1PM","7AM#3PM","7AM#10AM","10AM#12PM","2PM#4PM","1PM#4PM","8AM#9AM"};
        /*String ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            try {
            	ip1_item = in.nextLine();
            } catch (Exception e) {
            	ip1_item = null;
            }
            ip1[ip1_i] = ip1_item;
        }*/
        output = profitValue(ip1);
        System.out.println(String.valueOf(output));
        in.close();
	}

	private static int profitValue(String[] ip1) {
		TreeMap<Integer,Integer> timeMap= new TreeMap<>();
		int profit=500;
		int tempProfit=500;
		for (String time : ip1) {
			String[] timings=time.split("#");
			for (int i=0; i < 2; ++i) {
				int x=Integer.parseInt(timings[0].substring(0, timings[0].length()-2));
				int y=Integer.parseInt(timings[1].substring(0, timings[1].length()-2));
				if(timings[0].endsWith("PM")){
					 x=x+12;
				}
				if(timings[1].endsWith("PM")){
					y=y+12;
				}
				timeMap.put(x, y);
			}
		}
		System.out.println(timeMap.keySet());
		System.out.println(timeMap.values());
		
		int[] keys= new int[timeMap.keySet().size()];
		//boolean[] keyVisited= new boolean[timeMap.keySet().size()];
		int[] values= new int[timeMap.values().size()];
		int k=0;
		int length=keys.length;
		for (int i : timeMap.keySet()) {
			keys[k]=i;
			//keyVisited[i]=false;
			++k;
		}
		k=0;
		for (int i : timeMap.values()) {
			values[k]=i;
			++k;
		}
		int i=0;
		while(i < length-1){
			int value=values[i];
			//keyVisited[i]=true;
			System.out.println("Key :: "+i+" "+keys[i]);
			System.out.println("value :: "+i+" "+value);
			int j = i+1;
			while (j < length ) {
				if(keys[j] >= value){
					System.out.println("Key :: "+i+" "+keys[j]);
					tempProfit+=500;
					value=values[j];
					j=j+1;
					System.out.println("value :: "+i+" "+value);
				}
				++j;
			}
			if(tempProfit > profit){
				profit=tempProfit;
			}
			tempProfit=0;
			++i;
		}
		return profit;
	}

}
