package com.improvingLogic;

import java.util.Scanner;

public class RadiusOfSphere {

	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String output;
        /*int ip1_size = 0;
        ip1_size = Integer.parseInt(in.nextLine().trim());
        int[] ip1 = new int[ip1_size];
        int ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            ip1_item = Integer.parseInt(in.nextLine().trim());
            ip1[ip1_i] = ip1_item;
        }*/
        
        int[] ip1={1000,999,998,5,5,6};
        output = getRadius(ip1);
        System.out.println(String.valueOf(output));
    

	}

	private static String getRadius(int[] input1) {   
        int t=input1.length;
	    double u=input1[0],v=input1[1],w=input1[2],x=input1[3],y=input1[4],z=input1[5];
	    double a=0,b=0,l=0,m=0,n=0,o=0,p=0,q=0;
	    double r=0,s=0,vol=0;
	    if(u == 0 && v== 0 && w== 0 && x== 0 && y== 0 && z== 0 ){
	        return String.valueOf("0.0000");
	    }
	    if(t > 0){
                s=0;
            	l=input1[0]*input1[0];
            	m=input1[1]*input1[1];
            	n=input1[2]*input1[2];
            	o=input1[3]*input1[3];
            	p=input1[4]*input1[4];
            	q=input1[5]*input1[5];
            	a=((o+q)*(l*n+m*p))+((o+p)*(m*n+l*q))+((p+q)*(n*o+l*m));
                b=(n*o*(n+o))+(m*p*(m+p))+(l*q*(l+q))+(o*(l*m+p*q))+(n*(l*p+m*q));
            	vol=Math.sqrt(a-b)/12;
            	s=area(u,v,x)+area(w,y,u)+area(v,w,z)+area(x,y,z);
            	r=((3.0)*vol)/(s);
            	System.out.println(r);
              }
        return String.format("%.4g%n", r);
    }
	static double area(double a,double b,double c){
        double e=0;
        double d=0;
        d=(a+b+c)/2;
        e=Math.sqrt(d*(d-a)*(d-b)*(d-c));
        return e;
    }
	
}
