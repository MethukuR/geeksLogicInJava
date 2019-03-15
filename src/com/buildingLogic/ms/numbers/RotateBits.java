package com.buildingLogic.ms.numbers;

public class RotateBits {
  private static int BITS_IN_INTEGER = 32;
  
  public static void main(String[] args) {
    RotateBits rotateBits = new RotateBits();
    int result = rotateBits.rotateBitsRight(1, 2);
    System.out.println(result);
  }
  
  public int rotateBitsRight(int number, int rotateBy) {
    System.out.println(Integer.toBinaryString(number));
    System.out.println(Integer.toBinaryString(
        (number >> rotateBy) | 
        (number << (BITS_IN_INTEGER - rotateBy)
            )));
    return (number >> rotateBy) | (number << (BITS_IN_INTEGER - rotateBy));
  }

}
