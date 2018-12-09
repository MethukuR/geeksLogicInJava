/*package com.improvingLogic;



import org.jfugue.Pattern;
import org.jfugue.Player;

public class AnniversaireVoeux {
	public static void main(String[] args) {
		Player player =  new Player();
		Pattern pattern = new Pattern("Ci D C F Ew Ci D C G Fw Ci C6 A F E Dw Bb Bb A F G Fw Ci D C F Ew Ci D C G Fw Ci C6 A F E Dw Bb Bb A F G Fw Ci D C F Ew Ci D C G Fw Ci C6 A F E Dw Bb Bb A F G Fw");
		System.out.println("Playing piano...");
		System.out.println();
		
		  printH(5);
		  System.out.println();
		  printB(5);
		  System.out.println();

		  printA(5);
		  System.out.println();


		  printN(5);
		  System.out.println();


		  printK(5);
		  System.out.println();


		  printI(5);
		  System.out.println();


		  printT(5);
		  System.out.println();

		  printA(5);
		  System.out.println();


		
		player.play(pattern);
		System.out.println(":-)");
		System.exit(0);
	}
	
	 static void printH(int row){

			for (int i = 0; i < row; ++i) {
				if(i == Math.ceil(row/2)){
					for (int j = 0; j < row; ++j) {
						System.out.print("*");
					}
				}
				else{
					for (int j = 0; j < row; ++j) {
						if(j == 0 || j == row-1){
							System.out.print("*");
						}
						else{
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		
	 }
	 
	 static void printB(int row){

			for (int i = 0; i < row; ++i) {
				if(i == 0 || i == Math.ceil(row/2) || i == row-1){
					for (int j = 0; j < row; ++j) {
						System.out.print("*");
					}
				}
				else{
					for (int j = 0; j < row+1; ++j) {
						if(j == 0 || j == row){
							System.out.print("*");
						}
						else{
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		
	 }
	 
	 static void printA(int row){
	        
	        if(row%2==0)
	        	row++;
	        for(int i=0;i<row;i++)
	        {
	            char ch = ' ';
	            for(int j=0;j<row-i;j++)
	            {
	                if(j==row-(i+1))
	                System.out.print("*");
	                else
	                System.out.print(" ");
	            }
	            if(i==(row/2))
	            ch='*';
	            for(int k=0;k<(i*2)-1;k++)
	            System.out.print(ch);
	            ch=' ';
	            for(int l=0;l<row-i;l++)
	            {
	                if(i==0)
	                continue;
	                if(l==0)
	                System.out.print("*");
	                else
	                System.out.print(" ");
	            }
	            System.out.print("\n");
	        }
	    
	 }
	 
	 static void printN(int rows){

			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < rows; ++j) {
					if( j ==0 || j == i || j == rows-1){
						System.out.print("*");
					}
					else{
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		
	 }
	 
	 static void printK(int row){
		 row/=2;
		 
		 for (int i = -row; i <= row; i++) {
			for (int j = -row; j <= 0; j++) {
				if((j == -row) || (Math.abs(i)+Math.abs(j)==row) ){
					System.out.print("* ");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	 }
	 
	 static void printI(int rows){

			for (int i = 0; i < rows; ++i) {
				if(i == 0 || i == rows-1){
					for (int j = 0; j < rows; ++j) {
						System.out.print("*");
					}
				}
				else{
					for (int j = 0; j < rows; ++j) {
						if(j == Math.ceil(rows/2)){
							System.out.print("*");
						}
						else{
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		
	 }
	 
	 
	 
	 static void printT(int rows){

			for (int i = 0; i < rows; ++i) {
				if(i == 0){
					for (int j = 0; j < rows; ++j) {
						System.out.print("*");
					}
				}
				else{
					for (int j = 0; j < rows; ++j) {
						if(j == Math.ceil(rows/2)){
							System.out.print("*");
						}
						else{
							System.out.print(" ");
						}
					}
				}
				System.out.println();
			}
		
	 }
}
*/