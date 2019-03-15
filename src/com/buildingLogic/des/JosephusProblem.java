/**
 * Josephus Problem:
====================
This problem is named after Flavius Josephus a Jewish historian who fought against the Romans. According 
to Josephus him and his group of Jewish soldiers were cornered & surrounded by the Romans inside a cave 
and they chose murder and suicide inside of surrender and capture. They decided that all the soldiers 
will sit in a circle and starting from the soldier sitting at the first position every soldier will kill 
the soldier to their in a sequential way. So if there are 5 soldiers sitting in a circle with positions 
numbered as 1, 2, 3, 4, 5. The soldier 1 kills 2, then 3 kills 4, then 5 kills 1, then 3 kills 5 and 
since 3 is the only one left then 3 commits suicide.

Now Josephus doesn’t want to get murdered or commit suicide. He would rather be captured by the Romans 
and is presented with a problem. He has to figure out at which position should he sit in a circle 
(provided there are n men in total and the man sitting at position 1 gets the first chance to murder) so 
that he is the last man standing and instead of committing suicide he will surrender to the Romans.


The Pattern:
============

If you work this out for different values of n the you will find a pattern here. If n is a true power of 
2 then the answer is always 1. For every n greater than that power of 2 the answer is incremented by 2.

N SOLDIERS  2^A+ L   SURVIVOR W(N) = 2L + 1
1   1 + 0   2 * 0 + 1 = 1
2   2 + 0   2 * 0 + 1 = 1
3   2 + 1   2 * 1 + 1 = 3
4   4 + 0   2 * 0 + 1 = 1
5   4 + 1   2 * 1 + 1 = 3
6   4 + 2   2 * 2 + 1 = 5
7   4 + 3   2 * 3 + 1 = 7
8   8 + 0   2 * 0 + 1 = 1
9   8 + 1   2 * 1 + 1 = 3
10  8 + 2   2 * 2 + 1 = 5
11  8 + 3   2 * 3 + 1 = 7
12  8 + 4   2 * 4 + 1 = 9
Now for every n the right position for Josephus can be found out by deducting the biggest possible power 
of 2 from the number and we get the answer (provided that value of n is not a pure power of 2 otherwise 
the answer is 1)

N = 2a + something


Where, a = biggest possible power

The Trick:
==========

Whenever someone talks about the powers of 2 the first word that comes to mind is “binary”. The solution 
to this problem is much is easier and shorter in binary than in decimal. There is a trick to this. Since 
we need to deduct the biggest possible power of in binary that number is the Most Significant Bit. In the 
original Josephus problem there were 40 other soldiers along with Josephus which makes n = 41. 41 in 
binary is 101001. If we shift the MSB i.e. the leftmost 1 to the rightmost place we get 010011 which is 
19 (in decimal) which is the answer. This is true for all cases. This can be done easily using bit 
manipulation.

Steps:
Idea is remove most significant 1(make it zero) and append it at end 

1. Find position of most significant 1 in n
2. Make most significant 1 to zero
3. Append 1 at the end of n
 */
package com.buildingLogic.des;

public class JosephusProblem {

  public static void main(String[] args) {
    System.out.println(findJosephusNumber(41));
  }

  private static int findJosephusNumber(int n) {
    if(n < 1) {
      return -1;
    }
    
    int position = findMostSignificantBitPosition(n);
    
    int j = 1 << (position-1);
    n = n^j;
    
    n = n << 1;

    n = n | 1;

    return n;
  }

  private static int findMostSignificantBitPosition(int n) {
    int position = 0;
    
    while(n != 0) {
      n = n>>1;
     ++position;
    }
    return position;
  }
  
  

}
