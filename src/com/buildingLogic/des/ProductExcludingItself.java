package com.buildingLogic.des;

import java.util.Arrays;

public class ProductExcludingItself {

  public static void main(String[] args) {
    int arr[] = {10, 3, 5, 6, 2};
    int[] product = findProduct(arr);
    
    for (int i = 0; i < product.length; i++) {
      System.out.print(product[i] + "\t");
    }
  }

  private static int[] findProduct(int[] arr) {
    int n = arr.length;
    if(n <= 1) {
      return null;
    }
    
    int[] product = new int[n];
    Arrays.fill(product, 1);
    
    int temp = 1;
    
    for (int i = 0; i < n; i++) {
      product[i] = temp;
      temp *= arr[i];
    }
    
    temp = 1;
    
    for (int i = n-1; i >= 0; --i) {
      product[i] *= temp;
      temp *= arr[i];
    }
    
    return product;
  }

}
