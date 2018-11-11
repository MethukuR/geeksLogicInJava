package com.improvingLogic;

import java.util.Scanner;
public class Display
{
    static Scanner scr = new Scanner(System.in);
    static Scanner scrInt = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.print("\fEnter no. of rows to display : ");
        int rows = scrInt.nextInt();
        System.out.print("Enter the alphabet to display : ");
        char ch = scr.next().charAt(0);
        ch = Character.toUpperCase(ch);
        System.out.print("\n\n");
        switch(ch)
        {
            case 'A':{
            	 A obj = new A(rows);
                 break;
            }
            case 'B':
                B obj1 = new B(rows);
            case 'C':
                C obj2 = new C(rows);
            case 'H':
                H obj3 = new H(rows);
            case 'I':
                I obj4 = new I(rows);
            case 'N':
                N obj5 = new N(rows);
            case 'T':
                T obj6 = new T(rows);
            case 'U':
                U obj7 = new U(rows);
            /*case 'I':
                I obj8 = new I(rows);
            case 'J':
                J obj9 = new J(rows);
            case 'K':
                K obj10 = new K(rows);
            case 'L':
                L obj11 = new L(rows);
            case 'M':
                M obj12 = new M(rows);
            case 'N':
                N obj13 = new N(rows);
            case 'O':
                O obj14 = new O(rows);
            case 'P':
                P obj15 = new P(rows);
            case 'Q':
                Q obj16 = new Q(rows);
            case 'R':
                R obj17 = new R(rows);
            case 'S':
                S obj18 = new S(rows);
            case 'T':
                T obj19 = new T(rows);
            case 'U':
                U obj20 = new U(rows);
            case 'V':
                V obj21 = new V(rows);
            case 'W':
                W obj22 = new W(rows);
            case 'X':
                X obj23 = new X(rows);
            case 'Y':
                Y obj24 = new Y(rows);
            case 'Z':
                Z obj25 = new Z(rows);*/
        }
    }
}

class A
{
    A(int row)
    {
        if(row<5)
        row=5;
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
}

class B{
	B(int row){
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
}

class C{
	C(int row){
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
}

class H{
	H(int row){
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
}

class I{
	I(int rows){
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
}

class T{
	T(int rows){
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

class U{
	U(int rows){
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

class N{
	N(int rows){
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
}