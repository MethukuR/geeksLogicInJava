package com.improvingLogic;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
/*
 <APPLET CODE="Animation.JAVA" WIDTH=400 HEIGHT=300>
 </APPLET>
*/
//The basic applet class.The applet shows 4 cars crossing each other at a square.
public class Animation extends Applet implements Runnable
{
 Thread t;
 //4 variables used to vary the car's positions.
 int x1=0,x2=380,y1=50,y2=250;
 @Override
public void start()
 {
  if(t==null)
  {
   t=new Thread(this,"New Thread");//New side Thread created on start of applet.
   t.start();
  }
 }
 @Override
public void stop()
 {
  if(t!=null)
  {
   t=null;//On stop of applet the created thread is destroyed.
  }
 }
 //Implementation of method run() of Runnable interface.
 @Override
public void run()
 {
  Thread t1=Thread.currentThread();
  while(t==t1)
  {
   repaint();
   try
   {
    Thread.sleep(10000);
   }
   catch(Exception e)
   {   }
  }
 }
 @Override
public void paint(Graphics g)
 {
  setBackground(Color.cyan);
  g.setColor(Color.BLACK);
  printH(5);
  printB(5);
  printC(5);

  printH(5);

  printI(5);

  printN(5);

  printT(5);
  printU(5);

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
 
 static void printC(int row){

		for (int i = 0; i < row; ++i) {
			if(i == 0 || i == row-1){
				System.out.print(" ");
				for (int j = 0; j < row; ++j) {
					System.out.print("*");
				}
			}
			else{
				System.out.print("*");
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
 
 static void printU(int rows){

		for (int i = 0; i < rows; ++i) {
			if(i == rows-1){
				for (int j = 0; j < rows; ++j) {
					System.out.print("*");
				}
			}
			else{
				for (int j = 0; j < rows; ++j) {
					if(j == 0 || j == rows-1){
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