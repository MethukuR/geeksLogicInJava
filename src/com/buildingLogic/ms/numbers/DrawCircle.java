/**
 * Draw a circle without floating point arithmetic: 
 * 
 * Given a radius of a circle, draw the circle without using floating point arithmetic. Following 
 * program uses a simple concept. Let the radius of the circle be r. Consider a square of size 
 * (2r+1)*(2r+1) around the circle to be drawn. Now walk through every point inside the square. For 
 * every every point (x,y), if (x, y) lies inside the circle (or x^2+ y^2 < r^2), then print it, 
 * otherwise print space.
 */
package com.buildingLogic.ms.numbers;

public class DrawCircle {

  public static void main(String[] args) {
      drawCircle(5);
  }
  
  public static void drawCircle(int radius) {
    if(radius <= 0) {
      return;
    }
    int sqrLen = 2*radius + 1;
    
    for (int i = 0; i < sqrLen; i++) {
      for (int j = 0; j < sqrLen; j++) {
        int x = i - radius;
        int y = j - radius;
        
        if(x*x + y*y <= radius*radius + 1) {
          System.out.print("*");
        }else {
          System.out.print(" ");
        }
      }
      
      System.out.println();
    }
  }

}
