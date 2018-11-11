package com.improvingLogic;

import java.util.TreeSet;

/**
 * 
 * @author Ranger Raju :P
 *
 */
public class AttackOnArmyTroops {

	public static void main(String[] args) {
		String[] inpArr={
				"1#2",
				"1#5",
				"2#5",
				"2#3",
				"3#4",
				"4#5",
				"4#6"

		};
		System.out.println(minRoads(inpArr));

	}
	
	public static int minRoads(String[] input)
    {	
		
		int inpLen=input.length;
		
		TreeSet<Integer> routes = new TreeSet<>();
		for (String string : input) {
			String[] routeNo=string.split("#");
			routes.add(Integer.parseInt(routeNo[0]));
			routes.add(Integer.parseInt(routeNo[1]));
		}
		int baseStationOne= routes.first();
		int baseStationTwo= routes.last();
		
		int[][] routeMap = formRouteMap(input,baseStationTwo);
		int minRoads=0;
		for (int i = 0; i < baseStationTwo; i++) {
			if(routeMap[i][baseStationTwo-1] == 1){
				++minRoads;
			}
			
			if(routeMap[baseStationTwo-1][i] == 1){
				++minRoads;
			}
		}
		return minRoads;
    }
	
private static int[][] formRouteMap(String[] strArr,int baseStationTwo) {
		
		int[][] routeMap= new int[baseStationTwo][baseStationTwo];
		for (int i = 0; i < baseStationTwo ; ++i) {
			for (int j = 0; j < baseStationTwo; ++j) {
				routeMap[i][j]=0;
			}
		}
		
		for (String route : strArr) {
			String[] routeNo=route.split("#");
			routeMap[Integer.parseInt(routeNo[0])-1][Integer.parseInt(routeNo[1])-1]=1;
		}
		
		for (int i = 0; i < baseStationTwo ; ++i) {
			for (int j = 0; j < baseStationTwo; ++j) {
				System.out.print(routeMap[i][j]+"\t");
			}
			System.out.println();
		}
		return routeMap;
	}


}
