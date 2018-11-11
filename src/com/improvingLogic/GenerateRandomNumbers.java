package com.improvingLogic;
/**
 * If you are a software developer, you may have come across the requirement of generating
 * random numbers in your application. While developing any kind of applications, you 
 * often need to generate random numbers. In Java, it is easy to generate random numbers
 * using some in-built methods and classes. In this article, we will see three different
 *  ways to generate random numbers in java. Let’s start with the definition of random numbers.

What Is Random Number?

“Randomness” is something which is totally unpredictable and unbiased. Random number is a 
number picked randomly from the given set of numbers. There will be no relation or 
dependency between the two successively picked numbers.

Random Number Generator :

An ideal Random Number Generator is the one which generates a series of numbers in the 

given range where,

Each possible number have equal probability of picking up.
There will be no relation or dependency between the previously generated number and the 
present one.
How To Generate Random Numbers In Java?

Java provides two ways to generate random numbers. One is using java.util.Random class 
and another one is using Math.random() method. There is one more method introduced in 
JAVA 7. It is using ThreadLocalRandom class. 
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomNumbers {

	public static void main(String[] args) {
		usingRandom();
		usingMathRandom();
		usingThreadLocalRandom();
	}
	
	static void usingRandom(){
		Random random = new Random();
		for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Integers : "+random.nextInt());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random doubles using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random Doubles : "+random.nextDouble());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random booleans using Random class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Random booleans : "+random.nextBoolean());
        }
        
        System.out.println("Random integers between 0 and 50 using Random class :");

        for (int i = 0; i < 5; i++)
        {
            System.out.println(random.nextInt(50));
        }
 
       
	}
	
	static void usingMathRandom(){
		
		//Using Math.random() method, you can generate only random doubles.
		
		for(int i = 0; i < 5; i++){
            System.out.println("Math Random Doubles : "+Math.random());
        }
		
		System.out.println("Math Random integers between 0 and 50 using Math.random() :");
		 
        for (int i = 0; i < 5; i++){
            System.out.println((int)(Math.random() * 50));
        }
	}
	
	static void usingThreadLocalRandom(){
		//Generating random integers using ThreadLocalRandom class
		 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("ThreadLocalRandom Random Integers : "+ThreadLocalRandom.current().nextInt());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random doubles using ThreadLocalRandom class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("ThreadLocalRandom Random Doubles : "+ThreadLocalRandom.current().nextDouble());
        }
 
        System.out.println("-----------------------------");
 
        //Generating random booleans using ThreadLocalRandom class
 
        for(int i = 0; i < 5; i++)
        {
            System.out.println("ThreadLocalRandom Random booleans : "+ThreadLocalRandom.current().nextBoolean());
        }
        
        //Generating random integers between 0 and 50 using ThreadLoclaRandom
        
        System.out.println("ThreadLocalRandom Random integers between 0 and 50 using ThreadLocalRandom :");
 
        for (int i = 0; i < 5; i++)
        {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 50));
        }
    
	}

}
