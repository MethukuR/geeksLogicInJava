package com.buildingLogic.stringSpecial;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class MonkeysDamage {

	public static void main(String[] args) {
		int rows=6;
		int cols=7;
		int noOfPlantsDestroyed=14;
		String damagePoints="((2,1),(6,6),(4,2),(2,5),(2,6),(2,7),(3,4),(6,1),(6,2),(2,3),(6,3),(6,4),(6,5),(6,7))";
		int result=findMaxNoOfPlantsDestroyed(rows,cols,noOfPlantsDestroyed,damagePoints);
	}

	private static int findMaxNoOfPlantsDestroyed(int rows,int cols,int noOfPlantsDestroyed,String damagePoints) {
		damagePoints=damagePoints.substring(1,damagePoints.length()-1);
		System.out.println(damagePoints);
		String[] points=damagePoints.split("\\),\\(");
		int pointsLen=points.length;
		int[] x=new int[noOfPlantsDestroyed];
		int[] y=new int[noOfPlantsDestroyed];
		for (int i = 0; i < pointsLen; ++i) {
			String p= points[i];
			if(p.startsWith("(")){
				x[i]=Integer.parseInt(p.substring(1,2));
				y[i]=Integer.parseInt(p.substring(3,4));
			}
			else{
				x[i]=Integer.parseInt(p.substring(0,1));
				y[i]=Integer.parseInt(p.substring(2,3));
			}
		}
		for (int i = 0; i < y.length; i++) {
			System.out.println(x[i]+"\t"+y[i]);
		}
		return 0;
	}
	
	public static int maxPoints(int X[], int Y[],int N) {
	     Map<Integer,Integer> xcount=new HashMap<>();
	     for(int x : X)
	     {
	         if(!xcount.containsKey(x))
	            xcount.put(x,1);
	        else
	            xcount.put(x,xcount.get(x)+1);
	     }
	     int xmax=0,ymax=0;
	     for(int x : xcount.values())
	     {
	         xmax=xmax>x? xmax : x;
	     }
	      
	     Map<Integer,Integer> ycount=new HashMap<>();
	     for(int x : Y)
	     {
	         if(!ycount.containsKey(x))
	            ycount.put(x,1);
	        else
	            ycount.put(x,ycount.get(x)+1);
	     }
	      for(int x : ycount.values())
	     {
	         ymax=ymax>x? ymax : x;
	     }
	     if(xmax>ymax)
	        return xmax;
	    return ymax;
	}        
}